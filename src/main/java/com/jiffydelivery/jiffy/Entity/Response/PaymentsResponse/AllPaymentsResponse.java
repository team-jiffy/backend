package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AllPaymentsResponse {
    private String status;
    private String message;
    private Card[] cards;
}
