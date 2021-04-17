package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Card {

    private String last4Digits;
    private String cardType;
    private String cardLabel;
    private String holderName;

    private Address cardAddress;

    private Address billingAddress;

    private String cardId;

    private boolean isDefaultCard;
}
