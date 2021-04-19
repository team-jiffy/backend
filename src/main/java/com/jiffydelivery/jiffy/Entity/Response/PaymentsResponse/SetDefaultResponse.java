package com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString

public class SetDefaultResponse {
    private String status;
    private String message;
    private Card card;
}
