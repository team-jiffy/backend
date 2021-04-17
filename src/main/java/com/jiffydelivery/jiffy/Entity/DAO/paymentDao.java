package com.jiffydelivery.jiffy.Entity.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class paymentDao {

    @Autowired
    private SessionFactory sessionFactory;

//    public List<Payment> getAllPayments() {
//        List<Payment> payments = new ArrayList<>();
//        try (Session session = sessionFactory.openSession()) {
//            payments = session.createCriteria(Payment.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return payments;
//    }
}
