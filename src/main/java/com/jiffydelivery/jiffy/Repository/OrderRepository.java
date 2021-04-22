package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.*;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;
import com.jiffydelivery.jiffy.JiffyApplicationConfig;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;
    // insert a new order record to order table
    public Order createOrder(Order order, long UID, long creditCardID) {

        order.setTrackNumber(GenerateTrackNumber());
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Customer customer = session.get(Customer.class,UID);
            CreditCard creditCard = session.get(CreditCard.class,creditCardID);
            Hibernate.initialize(creditCard);
            Hibernate.initialize(customer);
            order.setCustomer(customer);
            order.setCreditCard(creditCard);
            order.getRecipientContact().setCustomer(customer);
            order.getSenderContact().setCustomer(customer);
            session.beginTransaction();
            Long recipientID = (Long) session.save(order.getRecipientContact());
            Long senderID = (Long)session.save(order.getSenderContact());
            order.getRecipientContact().setId(recipientID);
            order.getSenderContact().setId(senderID);
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            order = null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return order;
    }

    public List<Order> getAllOrders(String UID) {

        List<Order> orders = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
//            String  hql = "From Order e where e.customer.id = :t";
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            Query query = session.createQuery(hql);
//            query.setParameter("t",UID);
//            List results = session.CriteriaQuery(Order.class)
//                    .add(Restrictions.eq("customer.id", Long.valueOf(UID)))
//                    .list();
////            List<Order> results = query.list();

//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Order> cr = cb.createQuery(Order.class);
//            Root<Order> root = cr.from(Order.class);
//            cr.select(root).where(cb.equal(root.get("customer.id"),Long.valueOf(UID)));
//
//            Query<Order> query = session.createQuery(cr);
//            List<Order> results = query.getResultList();

            Customer customer = session.get(Customer.class, Long.valueOf(UID));

            List<Order> order = customer.getOrder();
            Hibernate.initialize(order);
            return order;

//            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public Order getOrderHistory(String trackNumber) {
        Order order = null;

        try (Session session = sessionFactory.openSession()) {
            String  hql = "From Order e where e.TrackNumber = :t";
            Query query = session.createQuery(hql);
            query.setParameter("t",trackNumber);
            List<Order> results = query.list();
            if (results.size()==0) return null;
            else return results.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // get reco
    public RecoResponse getReco(Address pickupAddress, Address senderAddress) {
        RecoResponse recoResponse = new RecoResponse();
        List<Reco> res = new ArrayList<>();
        // TODO: call reco service API
        if (!res.isEmpty()) {
            recoResponse.setMessage("Get recommendation list");
            recoResponse.setStatus("200");
            // TODO: recoResponse.setOrder(mapped Reco[] recos);
        }
        return recoResponse;
    }

    private static String GenerateTrackNumber(){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < 10){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, 10);
    }

    public Order updateOrderStatus(long OrderID, OrderStatus orderStatus,
                                   Date pickupTime, Date deliverTime,
                                   Calendar deliverOrderDate, Boolean sameDay, Long tripID){

        Order newOrder = null;
        Session session = null;
        try  {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Order order = session.get(Order.class, OrderID);
            if (tripID!=null){
                Trip trip = session.get(Trip.class, tripID);
                order.setTrip(trip);
            }
            order.setOrderStatus(orderStatus);
            if (pickupTime!=null) order.setPickupTime(pickupTime);
            if (deliverTime!=null) order.setDeliverTime(deliverTime);
            if (deliverOrderDate!=null) order.setDeliverOrderDate(deliverOrderDate);
            if (sameDay!=null) order.setSameday(sameDay);
            session.update(order);
            newOrder = order;
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
        return newOrder;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JiffyApplicationConfig.class);
        OrderRepository test = applicationContext.getBean(OrderRepository.class);
//
//        Trip trip = new Trip(1, TripType.Charging,null,null,null,new Date());
//        test.createOrder(new Order(30,GenerateTrackNumber(),"Good", 2.3, 13.3, true, OrderStatus.values()[0], new Date(), new Date(),
//                Calendar.getInstance(), Calendar.getInstance(), ADVType.values()[0], null,
//                null, null, null, null, null));


    }
}
