package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.DBDAO.*;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // insert a new order record to order table
    public void createOrder(Order order) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(order);
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

    public List<BriefOrder> getAllOrders(String UID) {
        List<Order> orders = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            orders = session.createCriteria(Order.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<BriefOrder> result = new ArrayList<>();
        for (Order order : orders) {
            BriefOrder briefOrder = this.extractOrder(order);
            result.add(briefOrder);
        }
        return result;
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
    public Order getOrderHistory(String trackNumber) {
        Order order = null;
        try (Session session = sessionFactory.openSession()) {
            order = session.get(Order.class, trackNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    // get reco
    public List<Reco> getReco(Address pickupAddress, Address senderAddress) {
        List<Reco> res = new ArrayList<>();
        // TODO: call reco service API
        return res;
    }

    public static void main(String[] args) {
        OrderRepository o = new OrderRepository();
        o.createOrder(new Order(123, 2.3, 13.3, true, OrderStatus.values()[0], new Date(), new Date(),
                Calendar.getInstance(), Calendar.getInstance(), ADVType.values()[0], new WareHouse(),
                new CreditCard(), new Contact(), new Contact(), new Customer(), new ArrayList<Trip>()));
    }

}
