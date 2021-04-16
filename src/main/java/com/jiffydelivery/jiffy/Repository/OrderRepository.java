package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.ModelEntities.*;
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

            Contact senderContactId = order.getSenderContactId();
            Contact recipientContactId = order.getRecipientContactId();
            Card cardId = order.getPaymentCardId();
            Address pickupAddress = senderContactId.getAddress();
            Address deliveryAddress = recipientContactId.getAddress();

            Contact senderContactIdExistsOrNot = session.get(Contact.class, senderContactId);
            Contact recipientContactIdExistsOrNot = session.get(Contact.class, recipientContactId);
            Card cardIdExistsOrNot = session.get(Card.class, cardId);
            Address pickupAddressExistsOrNot = session.get(Address.class, pickupAddress);
            Address deliveryAddressExistsOrNot = session.get(Address.class, deliveryAddress);

            if (!senderContactIdExistsOrNot.equals(senderContactId)) session.save(senderContactId);
            if (!recipientContactIdExistsOrNot.equals(recipientContactId)) session.save(recipientContactId);
            if (!cardIdExistsOrNot.equals(cardId)) session.save(cardId);
            if (!pickupAddressExistsOrNot.equals(pickupAddress)) session.save(pickupAddress);
            if (!deliveryAddressExistsOrNot.equals(deliveryAddress)) session.save(deliveryAddress);

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
            BriefOrder briefOrder = new BriefOrder(order.getTrackNumber(),
                    order.getSenderContactId().getFirstName() + order.getSenderContactId().getLastName(),
                    order.getRecipientContactId().getFirstName() + order.getRecipientContactId().getLastName(),
                    order.getOrderDate(),
                    order.getADVType(),
                    order.getETA(),
                    order.getStatus()
            );
            result.add(briefOrder);
        }
        return result;
    }

    //    public List<Order> getAllOrders(String UID) {
    //        Session session = null;
    //        Query query = session.createQuery("from order");
    //        return query.list();
    //    }

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

}
