package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TripRepository {
    @Autowired
    SessionFactory sessionFactory;

    Session session;

    public Trip getTrip(String tripID){
        session = null;
        Trip trip = new Trip();
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            trip = session.get(Trip.class,tripID);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session!=null) {
                session.close();
            }
        }
        return trip;
    }

    public Trip updateTrip(Trip trip){
        session = null;
        Trip newTrip = new Trip();
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(trip);
            newTrip = session.get(Trip.class,trip.getId());
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session!=null) {
                session.close();
                return null;
            }
        }
        return newTrip;
    }

    public Trip createTrip(Trip trip){
        session = null;
        Trip newTrip = new Trip();
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long ) session.save(trip);
            newTrip = session.get(Trip.class,id);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session!=null) {
                session.close();
                return null;
            }
        }
        return newTrip;
    }
}
