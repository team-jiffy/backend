package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import lombok.*;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date ETA;

    private long tripId;

    @ManyToOne
    @JsonIgnore
    private WareHouse closestWarehouse;

    @OneToOne
    private CreditCard creditCard;


    @OneToOne(cascade = CascadeType.ALL)
    private Contact senderContact;


    @OneToOne(cascade = CascadeType.ALL)
    private Contact recipientContact;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "order")
    @JsonIgnore
    private Trip trip;

    public com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order extract(){
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order res =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order();
        res.setADVType(this.ADVType);
        res.setOrderStatus(this.orderStatus);
        res.setADVType(this.ADVType);
        res.setTrackNumber(this.TrackNumber);
        res.setETA(DateFormatUtils.format(this.ETA, "MM/dd/yyyy HH:mm"));
        res.setSameDay(this.sameday);
        res.setPrice(String.valueOf(this.price));
        res.setOrderDate(DateFormatUtils.format(this.placeOrderDate,"MM/dd/yyyy"));

        res.setBuyerUserId(this.customer.extract());
        res.setSenderContactId(this.senderContact.extract());
        res.setRecipientContactId(this.recipientContact.extract());
        res.setPaymentCardId(this.creditCard.extract());
        return res;

    }

    public BriefOrder toBriefOrder(){
        BriefOrder briefOrder = new BriefOrder();
        briefOrder.setSenderName(senderContact.getFirstName() + " "
                + senderContact.getLastName());
        briefOrder.setRecipientName(recipientContact.getFirstName() + " "
                + recipientContact.getLastName());
        briefOrder.setTrackNumber(TrackNumber);
        briefOrder.setOrderDate(new SimpleDateFormat("mm-dd-yyy").format(placeOrderDate.getTime()));

        return briefOrder;
    }
}
