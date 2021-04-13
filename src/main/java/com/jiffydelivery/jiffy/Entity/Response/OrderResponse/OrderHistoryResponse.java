package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Order;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class OrderHistoryResponse {
    private Order order;
}
