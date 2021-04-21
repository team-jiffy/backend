package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.DeleteAddressResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact addContact(String UID, Contact contact) {
        long dbUserID = Long.valueOf(UID);
        Customer dbUser = null;
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbContact = new com.jiffydelivery.jiffy.Entity.DBDAO.Contact();
        Session session = null;
        Address address = contact.getAddress();
        com.jiffydelivery.jiffy.Entity.DBDAO.Address dbAddress = new com.jiffydelivery.jiffy.Entity.DBDAO.Address();
        dbAddress.setCity(address.getCity());
        dbAddress.setStreet1(address.getStreet1());
        dbAddress.setStreet2(address.getStreet2());
        dbAddress.setAptNo(address.getAptNo());
        dbAddress.setZip(address.getZip());
        try {
            session = sessionFactory.openSession();
            dbUser = session.get(Customer.class,dbUserID);

            dbContact.setFirstName(contact.getFirstName());
            dbContact.setLastName(contact.getLastName());
            dbContact.setContactType(contact.getContactType());
            dbContact.setPhone(contact.getPhone());
            dbContact.setEmail(contact.getEmail());
            dbContact.setAddress(dbAddress);
            dbContact.setCustomer(dbUser);
            //dbContact.setDef(contact.get);
            session.beginTransaction();
            session.save(dbContact);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return dbContact;
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
    public DeleteAddressResponse deleteAddressforUser (String UID, String contactId) {
        Customer user = null;
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbContact = null;
        DeleteAddressResponse deleteAddressResponse = new DeleteAddressResponse();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            long dbuserID = Integer.parseInt(UID);
            long dbcontactID = Integer.parseInt(contactId);
            user = session.get(Customer.class, dbuserID);
            dbContact = session
                .get(com.jiffydelivery.jiffy.Entity.DBDAO.Contact.class, dbcontactID);

            user.getContact().remove(dbContact);
            session.beginTransaction();
            session.delete(dbContact);
            session.update(user);

            session.getTransaction().commit();
            if (!user.getContact().contains(dbContact)) {
                deleteAddressResponse.setMessage("delete done");
                deleteAddressResponse.setStatus("200");
            } else {
                deleteAddressResponse.setMessage("something wrong");

            }


        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return deleteAddressResponse;
    }
}
