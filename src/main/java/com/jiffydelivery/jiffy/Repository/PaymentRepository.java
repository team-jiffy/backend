package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Address;
import com.jiffydelivery.jiffy.Entity.DBDAO.CreditCard;
import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.DeletePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.NewPaymentRequest;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.DeletePaymentResponse;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CreditCard addPayment(NewPaymentRequest newPaymentRequest) {
        Session session = null;
        CreditCard creditCard = new CreditCard();

        //map eneity address to DAO address
        Address Dbaddress = new com.jiffydelivery.jiffy.Entity.DBDAO.Address();
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address EntityAddress = newPaymentRequest.getBillingAddress();

        Dbaddress.setStreet1(EntityAddress.getStreet1());
        Dbaddress.setStreet2(EntityAddress.getStreet2());
        Dbaddress.setCity(EntityAddress.getCity());
        Dbaddress.setZip(EntityAddress.getZip());
        Dbaddress.setAptNo(EntityAddress.getAptNo());

        creditCard.setCardNumber(newPaymentRequest.getCardNumber());
        creditCard.setHolderName(newPaymentRequest.getHolderName());
        creditCard.setCVV(newPaymentRequest.getCardCVV());
        creditCard.setZip(newPaymentRequest.getZipCode());
        creditCard.setExpDate(newPaymentRequest.getCardExpire());
        creditCard.setDef(newPaymentRequest.getDef());
        creditCard.setBillingAddress(Dbaddress);

        try{
            session = sessionFactory.openSession();
            Customer customer = session.get(Customer.class, newPaymentRequest.getUID());
            creditCard.setCustomer(customer);
            session.beginTransaction();
            session.saveOrUpdate(creditCard);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (creditCard == null) {
            return null;
        }
        return creditCard;
    }

    public void deletePayment(String UID, String cardID) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Customer customer = session.get(Customer.class, UID);
            List<CreditCard> cardList = customer.getCreditCard();
            for (CreditCard card : cardList) {
                if (Integer.toString((int) card.getId()).equals(cardID)) {
                    cardList.remove(card);
                }
            }
            session.beginTransaction();
            session.saveOrUpdate(cardList);
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

    public List<CreditCard> getAllPayments(String UID) {
        try(Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, Long.valueOf(UID));

            List<CreditCard> creditCard = customer.getCreditCard();
            Hibernate.initialize(creditCard);
            return creditCard;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDefault (String UID, String cardID) {

    }



}
