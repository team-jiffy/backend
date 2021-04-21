package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ADVRepository {

    @Autowired
    SessionFactory sessionFactory;

    public ADV getADV(String ADVid){

        ADV adv = new ADV();

        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            adv = session.get(ADV.class,ADVid);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session!=null){
                session.close();
            }
        }
        return null;
    }

    public void updateADV(ADV adv){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(ADV.class);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session!=null){
                session.close();
            }
        }
    }


}
