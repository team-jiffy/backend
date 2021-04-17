package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AllPaymentsResponse {
    private String Status;
    private String Message;
    private Card[] cards;
}
