package com.jiffydelivery.jiffy.Entity.DBDAO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Warehouse")
public class WareHouse implements Serializable {
    private static final long serialVersionUID = 7551999649239365225L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

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
