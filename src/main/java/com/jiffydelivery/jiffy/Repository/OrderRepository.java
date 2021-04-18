package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.*;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.AllOrdersResponse;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.NewOrderResponse;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.OrderHistoryResponse;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.RecoResponse;
import com.jiffydelivery.jiffy.JiffyApplicationConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // insert a new order record to order table
    public NewOrderResponse createOrder(Order order) {
        Session session = null;
        NewOrderResponse newOrderResponse = new NewOrderResponse();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                newOrderResponse.setMessage("Order created");
                newOrderResponse.setStatus("200");
                // TODO: newOrderResponse.setOrder(mapped Order)
                session.close();
            }
        }
        return newOrderResponse;
    }

    public AllOrdersResponse getAllOrders(String UID) {
        AllOrdersResponse allOrdersResponse = new AllOrdersResponse();
        List<Order> orders = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            orders = session.createCriteria(Order.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BriefOrder[] briefOrders = new BriefOrder[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            briefOrders[i] = this.extractOrder(orders.get(i));
        }
        if (briefOrders.length > 0) {
            allOrdersResponse.setMessage("Get all orders");
            allOrdersResponse.setStatus("200");
            allOrdersResponse.setOrders(briefOrders);
        }
        return allOrdersResponse;
    }

    private BriefOrder extractOrder(Order order) {
        return new BriefOrder.BriefOrderBuilder()
                .trackNumber(order.getId())
                .senderName(order.getSenderContact().getFirstName() + order.getSenderContact().getLastName())
                .recipientName(order.getRecipiantContact().getFirstName() + order.getRecipiantContact().getLastName())
                .orderDate(order.getDeliverOrderDate().toString())
                .ADVType(order.getADVType().toString())
                .ETA(order.getDeliverTime().toString())
                .orderStatus(order.getOrderStatus().toString())
                .build();
    }

//        public List<Order> getAllOrders(String UID) {
//            Session session = null;
//            Query query = session.createQuery("from Order_table");
//            return query.list();
//        }

    // get order history by tracking number
    public OrderHistoryResponse getOrderHistory(String trackNumber) {
        Order order = null;
        OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
        try (Session session = sessionFactory.openSession()) {
            order = session.get(Order.class, trackNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (order != null) {
            orderHistoryResponse.setMessage("Get order history");
            orderHistoryResponse.setStatus("200");
            // TODO: orderHistoryResponse.setOrder(mapped Order);
        }
        return orderHistoryResponse;
    }

    // get reco
    public RecoResponse getReco(Address pickupAddress, Address senderAddress) {
        RecoResponse recoResponse = new RecoResponse();
        List<Reco> res = new ArrayList<>();
        // TODO: call reco service API
        if (!res.isEmpty()) {
            recoResponse.setMessage("Get recommendation list");
            recoResponse.setStatus("200");
            // TODO: recoResponse.setOrder(mapped Reco[] recos);
        }
        return recoResponse;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JiffyApplicationConfig.class);
        OrderRepository test = applicationContext.getBean(OrderRepository.class);

        Trip trip = new Trip(1, TripType.charging,null,null,null,new Date());
        test.createOrder(new Order(30, 2.3, 13.3, true, OrderStatus.values()[0], new Date(), new Date(),
                Calendar.getInstance(), Calendar.getInstance(), ADVType.values()[0], null,
                null, null, null, null, null));


    }

}
