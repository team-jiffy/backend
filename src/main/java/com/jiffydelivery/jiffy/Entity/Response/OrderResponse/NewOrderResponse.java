package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Order;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class NewOrderResponse {
    private Order order;
}
