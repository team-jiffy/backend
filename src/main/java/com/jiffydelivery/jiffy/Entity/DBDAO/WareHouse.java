package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int numberOfDrone;
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "closestWarehouse")
    @JsonIgnore
    private List<Order> order;

    @OneToMany(mappedBy = "currentWarehouse")
    @JsonIgnore
    private List<ADV> ADV;
}
