package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UpdatePaymentResponse {
    private String status;
    private String message;
    private Card card;
}
