package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Order_table")
public class Order implements Serializable {
    private static final long serialVersionUID = 7529996499351526523L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String TrackNumber;
    private String OrderLabel;
    private double packageWeight;
    private double price;
    private boolean sameday;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverTime;

    @Temporal(TemporalType.DATE)
    private Calendar placeOrderDate;

    @Temporal(TemporalType.DATE)
    private Calendar deliverOrderDate;

    @Enumerated(EnumType.STRING)
    private ADVType ADVType;

    @ManyToOne
    private WareHouse closestWarehouse;

    @ManyToOne
    private CreditCard creditCard;

    @OneToOne
    private Contact senderContact;

    @OneToOne
    private Contact recipientContact;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private Trip trip;
}
