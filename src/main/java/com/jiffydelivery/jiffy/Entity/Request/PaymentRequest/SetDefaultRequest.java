package com.jiffydelivery.jiffy.Entity.Request.PaymentRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SetDefaultRequest {
    private String UID;
    private String cardID;
}
