package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Trip")
public class Trip implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private TripType tripType;

    @ManyToOne
    private ADV ADV;

    @ManyToOne
    private Order order;

    @OneToOne
    private Address address;

    @Temporal(TemporalType.TIME)
    private Date currentTime;
}
