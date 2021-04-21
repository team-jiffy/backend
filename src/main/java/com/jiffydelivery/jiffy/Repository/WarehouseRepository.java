package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.DBDAO.WareHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WarehouseRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<WareHouse> getWareHouses() {
        List<WareHouse> wareHouses = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            wareHouses = session.createQuery("from WareHouse").list();
            if (wareHouses.size() == 0) return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return wareHouses;
    }
}
