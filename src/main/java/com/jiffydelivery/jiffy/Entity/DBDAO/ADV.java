package com.jiffydelivery.jiffy.Entity.DBDAO;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADV")
public class ADV implements Serializable {
    private static final long serialVersionUID = 7564993652252519993L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private double currentBatteryPercentage;
    private double currentLatitude;
    private double currentLongitude;
    private double currentElevation;
    private double currentPackageAmount;

    @ManyToOne
    private WareHouse currentWarehouse;

    @ManyToOne
    private ADVSpec ADVSpec;

    @OneToMany(mappedBy = "ADV")
    private List<Trip> trip;

}
