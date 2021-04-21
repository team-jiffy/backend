package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetDefaultAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.DeleteAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.GetAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.SetDefaultAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.UpdateAddressResponse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Set;
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

    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact updateContact(String UID, Contact contact, String contactID) {
        //Customer dbUser = null;
        Address address = contact.getAddress();
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbContact = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            //long dbuserID = Integer.parseInt(UID);
            long dbcontactID = Integer.parseInt(contactID);

            //Customer dbUser = session.get(Customer.class, dbuserID);
            dbContact = session.get(com.jiffydelivery.jiffy.Entity.DBDAO.Contact.class, dbcontactID);
            com.jiffydelivery.jiffy.Entity.DBDAO.Address dbAddress = dbContact.getAddress();

            dbAddress.setStreet1(address.getStreet1() == null ? null : address.getStreet1());
            dbAddress.setStreet2(address.getStreet2() == null ? null : address.getStreet2());
            dbAddress.setCity(address.getCity() == null ? null : address.getCity());
            dbAddress.setState(address.getState() == null ? null : address.getState());
            dbAddress.setZip(address.getZip() == null ? null : address.getZip());
            dbAddress.setAptNo(address.getAptNo() == null ? null : address.getAptNo());

            dbContact.setContactType(contact.getContactType() == null ? null : contact.getContactType());
            dbContact.setFirstName(contact.getFirstName() == null ? null : contact.getFirstName());
            dbContact.setLastName(contact.getLastName() == null ? null : contact.getLastName());
            dbContact.setPhone(contact.getPhone() == null ? null : contact.getPhone());
            dbContact.setEmail(contact.getEmail() == null ? null : contact.getEmail());
            dbContact.setAddress(dbAddress);

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

    public SetDefaultAddressResponse setContactAsDefault(SetDefaultAddressRequest request) {
        Session session = null;
        Customer dbUser = null;
        long uid = Long.valueOf(request.getUID());
        long cid = Long.valueOf(request.getContactID());
        SetDefaultAddressResponse response = new SetDefaultAddressResponse();
        try {
            session = sessionFactory.openSession();

            dbUser = session.load(Customer.class, uid);
            List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact> contactlist = new ArrayList<>();
            contactlist = dbUser.getContact();
            for(com.jiffydelivery.jiffy.Entity.DBDAO.Contact contact : contactlist){
                if(contact.getId()==cid && contact.isDef()==false){
                    contact.setDef(true);

                }
                else {
                    contact.setDef(false);
                }
            }
            dbUser.setContact(contactlist);
            session.beginTransaction();
            session.update(dbUser);
            session.getTransaction().commit();
            com.jiffydelivery.jiffy.Entity.DBDAO.Contact testcontact = session.get(
                com.jiffydelivery.jiffy.Entity.DBDAO.Contact.class,cid);
            if(testcontact.isDef()==true){
                response.setStatus("200");
                response.setMessage("good");
                response.setContact(new Contact(testcontact));
            }
            else {
                response.setStatus("400");
                response.setMessage("fail");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return response;
    }

    public List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact> getAllAddress(String UID) {
        //Session session = null;
        Customer dbUser = null;
        long uid = Long.valueOf(UID);
        //List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact> contactlist = new ArrayList<>();

//        try {
//            session = sessionFactory.openSession();
//
//            dbUser = session.get(Customer.class, uid);
//             contactlist = dbUser.getContact();
//            session.beginTransaction();
//            session.getTransaction().commit();
//            return contactlist;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            session.getTransaction().rollback();
//            return null;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
        try (Session session = sessionFactory.getCurrentSession()) {
//            String  hql = "From Order e where e.customer.id = :t";
//            Query query = session.createQuery(hql);
//            query.setParameter("t",UID);
            List<com.jiffydelivery.jiffy.Entity.DBDAO.Contact> contactlist = session.createCriteria(
                com.jiffydelivery.jiffy.Entity.DBDAO.Contact.class)
                .add(Restrictions.eq("customer.id", Long.valueOf(UID)))
                .list();
            return contactlist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
