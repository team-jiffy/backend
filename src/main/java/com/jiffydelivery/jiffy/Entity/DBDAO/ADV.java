package com.jiffydelivery.jiffy.Entity.DBDAO;

import jdk.jfr.Enabled;
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
@Table(name = "ADV")
public class ADV implements Serializable {
    private static final long serialVersionUID = 7564993652252519993L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private double currentBatteryPercentage;
    private double currentLatitude;
    private double currentLongitude;
    private double currentElevation;
    private double currentPackageAmount;

    @ManyToOne
    private WareHouse currentWarehouse;

    @ManyToOne
    private ADVSpec ADVSpec;

    @OneToOne(mappedBy = "ADV")
    private Trip trip;

}
