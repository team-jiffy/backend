package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Contact;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class NewOrderRequest {
    public String ADVType;
    public String orderDate;
    public String cardId;
    public boolean sameDay;

    public Contact senderContactId;
    public Contact recipientContactId;
}
