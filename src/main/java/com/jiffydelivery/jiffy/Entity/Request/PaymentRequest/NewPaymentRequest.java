package com.jiffydelivery.jiffy.Entity.Request.PaymentRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import lombok.*;
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
    private Address billingAddress;

    public boolean getDef() {
        return this.def;
    }

}
