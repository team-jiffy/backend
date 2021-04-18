package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADV_spec")
public class ADVSpec implements Serializable {
    private static final long serialVersionUID = 7551225999649936523L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Enumerated(EnumType.STRING)
    private ADVType ADVType;

    private int batteryVolumn;
    private double speed;
    private String ADVName;
    private int capacity;
    private double chargingSpeed;

    @OneToMany(mappedBy = "ADVSpec")
    private List<ADV> ADV;
}
