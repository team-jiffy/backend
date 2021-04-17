package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;

import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class NewPaymentResponse {
    private String Status;
    private String Message;
    private Card card;
}
