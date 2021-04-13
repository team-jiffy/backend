package com.jiffydelivery.jiffy.Entity.ModelEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Order {
    @JsonProperty
    private final String orderLabel;

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
