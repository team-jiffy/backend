package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UnfinishedOrder {
    private String orderLabel;

    private Contact senderContactId;
    private Contact recipientContactId;

    private String trackNumber;

    private User buyerUserId;

    private String ADVType;
    private String ETA;
    private boolean sameDay;
    private String price;
    private String orderDate;
    private String status;

    private String packageInfo;

    private int[] positions;

    private Card paymentCardId;
}
