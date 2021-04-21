package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import com.jiffydelivery.jiffy.Entity.DBDAO.Address;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.DBDAO.Trip;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.ADVDto;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.ProgressReportResponse;
import com.jiffydelivery.jiffy.Entity.Singletons.ADVFamily;
import com.jiffydelivery.jiffy.Entity.Singletons.OrderQueue;
import com.jiffydelivery.jiffy.Repository.ADVRepository;
import com.jiffydelivery.jiffy.Repository.APIRepository.GetLatLong;
import com.jiffydelivery.jiffy.Repository.OrderRepository;
import com.jiffydelivery.jiffy.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

@Service
public class ProgressReportService {

    @Autowired
    private OrderQueue orderQueue;
    private TripRepository tripRepository;
    private OrderRepository orderRepository;
    private ADVRepository advRepository;
    private GetLatLong getLatLong;

    public ProgressReportResponse assignNextTrip(ADVDto advDto) throws MalformedURLException {

        int id = advDto.getADVID();
        ADVType advType = advDto.getADVType();
        Queue<Trip> advQueue = ADVFamily.values()[id].getQueue();
        Queue<Order> orderQ = advType.equals(ADVType.Drone) ? orderQueue.getDroneOrderQueue() : orderQueue.getRobotOrderQueue();


        // step1: pull the last finished trip ADV just completed from the queue
        Trip lastTrip = advQueue.poll();
        assert lastTrip != null;
        Order order = lastTrip.getOrder();

        // revise current order status + update db
        if (lastTrip.getTripType().equals(TripType.Outside)) {
            updateOrderStatus(order);
            // TODO: how to record pick up time and delivery time
//            if (order.getOrderStatus().equals(OrderStatus.OnDeliver)) {
//                order.getPickupTime() = new Date();
//            }
            orderRepository.updateOrderStatus(order.getId(), order.getOrderStatus(),
                    order.getPickupTime(), order.getDeliverTime(), order.getDeliverOrderDate(),
                    order.isSameday(), order.getTrip().getId());
        }

        // step2: get new order, call optimizer()
        Order newOrder = orderQ.peek();
        // create 2 new trips with mapped adv
        advRepository.updateADV(advRepository.getADV(String.valueOf(advDto.getADVID())));
        ADV adv = advRepository.getADV(String.valueOf(advDto.getADVID()));

        Trip newPickupTrip = new Trip();
        newPickupTrip.setTripType(TripType.Outside);
        newPickupTrip.setADV(adv);
        newPickupTrip.setOrder(newOrder);
        assert newOrder != null;
        newPickupTrip.setAddress(newOrder.getSenderContact().getAddress());
        newPickupTrip.setCurrentTime(new Date());

        Trip newDeliveryTrip = new Trip();
        newDeliveryTrip.setTripType(TripType.Outside);
        newDeliveryTrip.setADV(adv);
        newDeliveryTrip.setOrder(newOrder);
        newDeliveryTrip.setAddress(newOrder.getRecipientContact().getAddress());
        newDeliveryTrip.setCurrentTime(new Date());

        if (advType.equals(ADVType.Robot)) {
            // hard code now, shall get optimized results via Optimizer(), passing 2 new trips and current queue
            ArrayDeque<Trip> optimizedQueue = new ArrayDeque<>();
            if (optimizedQueue != null) {
                ADVFamily.values()[id].setQueue(optimizedQueue);
            }
        }

        orderQ.poll();
        advQueue = ADVFamily.values()[id].getQueue();
        Trip newTrip = advQueue.peek();
        adv.setTrip(newTrip);
        Order currOrder = newTrip.getOrder();
        updateOrderStatus(currOrder);

        // if pickup/delivery trip starts, update corresponding order in db
        if (currOrder.getOrderStatus().equals(OrderStatus.OnTheWay) || currOrder.getOrderStatus().equals(OrderStatus.OnDeliver)) {
            orderRepository.updateOrderStatus(currOrder.getId(), currOrder.getOrderStatus(),
                    currOrder.getPickupTime(), currOrder.getDeliverTime(), currOrder.getDeliverOrderDate(),
                    currOrder.isSameday(), currOrder.getTrip().getId());
        }
        // update corresponding trip in db
        tripRepository.updateTrip(newTrip);

        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Trip resTrip =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Trip();
        resTrip.setTripType(newTrip.getTripType());
        Address address = newTrip.getAddress();
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address addressFrontend =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address(address);
        double[] coordinates = getLatLong.getCoordinates(addressFrontend);
        Coordinates coordinate = new Coordinates(String.valueOf(coordinates[0]), String.valueOf(coordinates[1]));
        resTrip.setCoordinates(coordinate);
        resTrip.setTripID(String.valueOf(newTrip.getId()));
        return new ProgressReportResponse(resTrip);
    }

    private void updateOrderStatus(Order order) {
        OrderStatus orderStatus = order.getOrderStatus();
        if (orderStatus.equals(OrderStatus.Placed)) {
            order.setOrderStatus(OrderStatus.OnTheWay);
        } else if (orderStatus.equals(OrderStatus.OnTheWay)) {
            order.setOrderStatus(OrderStatus.OnDeliver);
        } else if (orderStatus.equals(OrderStatus.OnDeliver)) {
            order.setOrderStatus(OrderStatus.Delivered);
        }
    }

}