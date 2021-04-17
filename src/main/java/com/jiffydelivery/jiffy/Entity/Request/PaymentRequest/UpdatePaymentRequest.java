package com.jiffydelivery.jiffy.Entity.Request.PaymentRequest;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UpdatePaymentRequest {
    private String cardNumber;
    private String name;
    private String cardExpire;
    private String cardCVV;
    private String holderName;
    private String cardType;
    private Address cardAddress;
    private Address billingAddress;
    private String UID;
    private String cardID;
}
