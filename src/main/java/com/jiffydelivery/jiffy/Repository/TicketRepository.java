package com.jiffydelivery.jiffy.Repository;


import com.jiffydelivery.jiffy.Entity.DAO.TicketDao;
import com.jiffydelivery.jiffy.Entity.Request.TicketRequest.TicketRequestBody;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void createTicket(TicketDao ticket) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(ticket);
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
}
