package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADV_Spec")
public class ADVSpec implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private ADVType ADVType;

    private int batteryVolumn;
    private double speed;
    private String ADVName;
    private int capacity;
    private double chargingSpeed;

    @OneToMany(mappedBy = "advSpec")
    private List<ADV> ADV;
}
