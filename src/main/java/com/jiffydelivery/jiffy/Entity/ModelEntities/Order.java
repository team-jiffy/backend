package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 3996866815386778109L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderLabel;

    @ManyToOne
    private Contact senderContactId;

    @ManyToOne
    private Contact recipientContactId;

    private String trackNumber;

    @OneToOne(mappedBy = "customer")
    private Customer buyerUserId;

    private String ADVType;
    private String ETA;
    private boolean sameDay;
    private String price;
    private String orderDate;
    private String status;

    private String packageInfo;

    @OneToOne(mappedBy = "warehouse")
    private WareHouse closestWareHouse;

//    private int[] positions;

    @OneToOne(mappedBy = "card")
    private Card paymentCardId;
}
