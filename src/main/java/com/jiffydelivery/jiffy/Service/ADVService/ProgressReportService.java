package com.jiffydelivery.jiffy.Service.ADVService;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.DBDAO.Trip;
import com.jiffydelivery.jiffy.Entity.Singletons.ADVFamily;
import com.jiffydelivery.jiffy.Entity.Singletons.OrderQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Queue;

@Service
public class ProgressReportService {

    @Autowired
    OrderQueue orderQueue;

    public void assignNextTrip(ADV adv) {
        int id = (int)adv.getId();
        ADVType advType = adv.getADVSpec().getADVType();
        Queue<Trip> advQueue = ADVFamily.values()[id].getQueue();
        Queue<Order> orderQ = advType.equals(ADVType.drone) ? orderQueue.getDroneOrderQueue() : orderQueue.getRobotOrderQueue();

        // step1: pull the last trip ADV just completed from the queue
        Trip lastTrip = advQueue.poll();
        assert lastTrip != null;
        Order order = lastTrip.getOrder();

        // revise current order status + update db
        if (lastTrip.getTripType().equals(TripType.outside)) {
            updateOrderStatus(order);
            // TODO: update db if status needs to be updated
        }

        // step2: get new order, call optimizer()
        Order newOrder = orderQ.peek();
        // hard code now, shall get optimized results via Optimizer()
        ArrayDeque<Trip> optimizedQueue = new ArrayDeque<>();
        if (optimizedQueue != null) {
            advQueue = optimizedQueue.clone();
            orderQ.poll();
        }
        Trip newTrip = advQueue.peek();
//        adv.getTrip().add(newTrip);
    }


    private void updateOrderStatus(Order order) {
        OrderStatus orderStatus = order.getOrderStatus();
        if (orderStatus.equals(OrderStatus.placed)) {
            order.setOrderStatus(OrderStatus.onTheWay);
        } else if (orderStatus.equals(OrderStatus.onTheWay)) {
            order.setOrderStatus(OrderStatus.onDeliver);
        } else if (orderStatus.equals(OrderStatus.onDeliver)) {
            order.setOrderStatus(OrderStatus.delivered);
        }
    }

}
