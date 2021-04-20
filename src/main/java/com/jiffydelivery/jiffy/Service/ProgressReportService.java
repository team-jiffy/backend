package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.DBDAO.Trip;
import com.jiffydelivery.jiffy.Entity.Singletons.ADVFamily;
import com.jiffydelivery.jiffy.Entity.Singletons.OrderQueue;
import com.jiffydelivery.jiffy.Repository.OrderRepository;
import com.jiffydelivery.jiffy.Repository.TripRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

@Service
public class ProgressReportService {

    @Autowired
    OrderQueue orderQueue;
    SessionFactory sessionFactory;
    TripRepository tripRepository;
    OrderRepository orderRepository;

    public void assignNextTripToRobot(ADV adv) {
        // TODO: advId is not index, how to deal with this?
        int id = (int)adv.getId();
        ADVType advType = adv.getADVSpec().getADVType();
        Queue<Trip> advQueue = ADVFamily.values()[id].getQueue();
        Queue<Order> orderQ = advType.equals(ADVType.Drone) ? orderQueue.getDroneOrderQueue() : orderQueue.getRobotOrderQueue();

        // step1: pull the last finished trip ADV just completed from the queue
        Trip lastTrip = advQueue.poll();
        assert lastTrip != null;
        Order order = lastTrip.getOrder();

        // revise current order status + update db
        if (lastTrip.getTripType().equals(TripType.Outside)) {
            updateOrderStatus(order);
            updateOrderInDB(order);
        }

        // step2: get new order, call optimizer()
        Order newOrder = orderQ.peek();
        // create 2 new trips
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

        // add new trips into db
        tripRepository.createTrip(newPickupTrip);
        tripRepository.createTrip(newDeliveryTrip);

        // hard code now, shall get optimized results via Optimizer(), passing 2 new trips and current queue
        ArrayDeque<Trip> optimizedQueue = new ArrayDeque<>();
        if (optimizedQueue != null) {
            ADVFamily.values()[id].setQueue(optimizedQueue);
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
        }
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

    private void updateOrderInDB(Order order) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "update Order order set order.orderStatus=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, order.getOrderStatus());
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
