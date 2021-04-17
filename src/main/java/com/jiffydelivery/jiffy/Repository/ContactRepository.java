package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void addContact(Contact contact) {

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    public void setContactAsDefault(String contactId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(contactId);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public Contact getRecipientContactByOrderId (String orderId) {
//        Order order = null;
//        try (Session session = sessionFactory.openSession()) {
//            order = session.get(Order.class, orderId);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        if (order != null) {
//            return order.getRecipientContact();
//        }
//        return null;
//    }

    public Contact getSenderContactByOrderId (String orderId) {
        Order order = null;
        try (Session session = sessionFactory.openSession()) {
            order = session.get(Order.class, orderId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (order != null) {
            return order.getSenderContactId();
        }
        return null;
    }

    public Contact getDefaultRecipientOfOneUser (String userId) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (user != null) {
            return user.getDefaultDeliver();
        }
        return null;
    }

    public Contact getDefaultSenderOfOneUser (String userId) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (user != null) {
            return user.getDefaultSender();
        }
        return null;
    }
}
