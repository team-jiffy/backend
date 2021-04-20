package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact addContactToUser(String UID, Contact contact) {
        Session session = null;
        Customer user = null;
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbcontact = new com.jiffydelivery.jiffy.Entity.DBDAO.Contact();

        try {
            session = sessionFactory.openSession();
            //string uid to long dbuser id
            //int userintID =

            user = session.get(Customer.class,UID);
            dbcontact.setCustomer(user);

            session.beginTransaction();
            session.save(dbcontact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dbcontact;
    }

    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact updateContactToUser(String UID,
                                                                           Contact contact,
                                                                            String ContactID) {
        Session session = null;
        Customer user = null;
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbcontact = new com.jiffydelivery.jiffy.Entity.DBDAO.Contact();

        try {
            session = sessionFactory.openSession();
            user = session.get(Customer.class,UID);
            //List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact address : addressList>
            //for ()
            dbcontact.setCustomer(user);

            session.beginTransaction();
            session.save(dbcontact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dbcontact;
    }

    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact setContact(String UID, String ContactID) {
        Session session = null;
        Customer user = null;
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbcontact = new com.jiffydelivery.jiffy.Entity.DBDAO.Contact();

        try {
            session = sessionFactory.openSession();
            user = session.get(Customer.class,UID);
            //List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact address : addressList>
            //for ()
            dbcontact.setCustomer(user);

            session.beginTransaction();
            session.save(dbcontact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dbcontact;
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
            return user.getDefaultRecipient();
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
