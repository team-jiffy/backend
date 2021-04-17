package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    @Autowired
    private SessionFactory sessionFactory;

//    public void addPayment(Card card ) {
//        try (Session session = sessionFactory.openSession()) {
//            String cardNum = card.cardNumber;
//            String name = card
//            Card newCard = new Card();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public List<Card> getAllPayments() {
//        List<Card> cards = new ArrayList<>();
//        try (Session session = sessionFactory.openSession()) {
//            cards = session.createCriteria(Card.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return cards;
//    }
}
