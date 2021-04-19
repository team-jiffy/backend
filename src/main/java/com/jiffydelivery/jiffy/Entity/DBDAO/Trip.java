package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Trip")
public class Trip implements Serializable {
    private static final long serialVersionUID = 7551999649952252363L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
