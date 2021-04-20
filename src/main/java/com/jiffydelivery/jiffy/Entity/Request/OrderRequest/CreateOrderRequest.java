package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Pickup;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateOrderRequest {
    private String ADVType;
    private String OrderDate;
    private String CardId;
    private boolean SameDay;

    private Contact senderContactId;
    private Contact recipientContactId;
}
