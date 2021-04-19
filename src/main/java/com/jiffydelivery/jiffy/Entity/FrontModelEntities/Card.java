package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Card {

    private String LastFourDigits;
    private String CardType;
    private String CardLabel;
    private String HolderName;

    private Address CardAddress;

    private Address BillingAddress;

    private String CardId;

    private boolean Default;
}
