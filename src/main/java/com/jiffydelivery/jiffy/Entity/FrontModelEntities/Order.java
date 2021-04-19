package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {

    private String OrderLabel;

    private Contact SenderContactId;
    private Contact RecipientContactId;

    private int TrackNumber;

    private User BuyerUserId;

    private String ADVType;
    private String ETA;
    private boolean SameDay;
    private String Price;
    private String OrderDate;
    private String OrderStatus;

    private String PackageInfo;

    private Position Position;

    private Card PaymentCardId;
}
