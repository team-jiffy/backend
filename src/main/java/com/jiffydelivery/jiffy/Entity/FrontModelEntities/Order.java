package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {

    private String orderLabel;

    private Contact senderContactId;
    private Contact recipientContactId;

    private int trackNumber;

    private User buyerUserId;

    private String ADVType;
    private String ETA;
    private boolean sameDay;
    private String price;
    private String orderDate;
    private String orderStatus;

    private String packageInfo;

    private Position position;

    private Card paymentCardId;
}
