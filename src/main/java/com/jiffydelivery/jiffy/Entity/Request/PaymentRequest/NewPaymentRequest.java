package com.jiffydelivery.jiffy.Entity.Request.PaymentRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jiffydelivery.jiffy.Entity.DBDAO.CreditCard;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import lombok.*;
import org.hibernate.transform.CacheableResultTransformer;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class NewPaymentRequest {
    private String cardNumber;
//    private String name;
    private String cardExpire;
    private String cardCVV;
    private String holderName;
    private String cardType;
    private String UID;
    private String zipCode;
    private boolean def;
    private Address cardAddress;
    @JsonIgnore
    private Address billingAddress;

    public boolean getDef() {
        return this.def;
    }

    public CreditCard toDAO(){
        CreditCard card = new CreditCard();
        card.setCardNumber(cardNumber);
        card.setExpDate(cardExpire);
        card.setCVV(cardCVV);
        card.setHolderName(holderName);
        card.setZip(zipCode);
        card.setDef(def);
        card.setBillingAddress(cardAddress.toDAO());
        return card;
    }

}
