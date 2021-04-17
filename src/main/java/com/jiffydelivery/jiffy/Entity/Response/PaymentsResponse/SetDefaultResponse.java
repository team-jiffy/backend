package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SetDefaultResponse {
    private String status;
    private String message;
    private Card card;
}
