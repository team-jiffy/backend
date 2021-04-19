package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Trip")
public class Trip implements Serializable {
    private static final long serialVersionUID = 7551999649952252363L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    private TripType tripType;

    @OneToOne
    private ADV ADV;

    @OneToOne
    private Order order;

    @OneToOne
    private Address address;

    @Temporal(TemporalType.TIME)
    private Date currentTime;
}
