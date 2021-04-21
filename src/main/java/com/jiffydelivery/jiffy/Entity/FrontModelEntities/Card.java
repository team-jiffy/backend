package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.DBDAO.CreditCard;
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
    private String expDate;
    private Address CardAddress;
    private Address BillingAddress;

    private String CardId;

    private boolean Default;

    public CreditCard toDAO(){
        CreditCard creditCard = new CreditCard();
        creditCard.setHolderName(HolderName);
        creditCard.setId(Long.valueOf(CardId));
        creditCard.setCardLabel(CardLabel);
        creditCard.setExpDate(expDate);
        creditCard.setDef(Default);
        return creditCard;
    }
}
