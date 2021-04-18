package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderHistoryResponse {
    private String status;
    private String message;
    private Order order;
}
