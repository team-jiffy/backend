package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import com.jiffydelivery.jiffy.Entity.DBDAO.CreditCard;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AllPaymentsResponse {
    private String status;
    private String message;
    private List<Card> cards;
}
