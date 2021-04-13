package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.ModelEntities.UnfinishedOrder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class NonFinishedOrderResponse {
    private UnfinishedOrder unfinishedOrder;
}
