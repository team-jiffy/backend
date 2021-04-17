package com.jiffydelivery.jiffy.Entity.DBDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Warehouse")
public class WareHouse implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double longitude;
    private double latitude;
    private double elevation;
    private double chargingCapacity;
    private int numberOfRobot;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "closestWarehouse")
    private List<Order> order;

    @OneToMany(mappedBy = "currentWarehouse")
    private List<ADV> ADV;
}
