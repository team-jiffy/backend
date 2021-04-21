package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Getter
@Entity
@Table(name = "ADV_spec")
public class ADVSpec implements Serializable {
    private static final long serialVersionUID = 7551225999649936523L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    private ADVType ADVType;

    private double batteryVolumn;
    private double speed;
    private String ADVName;
    private int capacity;
    private double chargingSpeed;

    @OneToMany(mappedBy = "ADVSpec")
    @JsonIgnore
    private List<ADV> ADV;
}
