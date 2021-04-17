package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Address;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RecoRequest {
    private Address pickupAddress;
    private Address deliveryAddress;
    private int weight;
}
