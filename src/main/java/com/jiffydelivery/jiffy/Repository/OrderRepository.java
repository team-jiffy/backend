package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Reco;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    // get all orders
    public List<Order> getAllOrders(String UID) {
        Session session = null;
        Query query = session.createQuery("from Order");
        return query.list();
    }

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
        // TODO: get reco service API
        return res;
    }

    // get unfinished order

}
