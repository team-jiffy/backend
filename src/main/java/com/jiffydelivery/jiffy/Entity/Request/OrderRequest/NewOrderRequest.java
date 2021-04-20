package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewOrderRequest {
    private String ADVType;
    private String orderDate;
    private String cardId;
    private boolean sameDay;

    private Contact senderContactId;
    private Contact recipientContactId;

    // price is a double

}
