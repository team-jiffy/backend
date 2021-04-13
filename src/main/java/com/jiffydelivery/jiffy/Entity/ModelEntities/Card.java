package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Card {
    private final String cardId;
    private String last4Digits;
    private String cardType;
    private String cardLabel;
    private String holderName;

    private Address cardAddress;
    private Address billingAddress;

    private boolean isDefaultCard;
}
