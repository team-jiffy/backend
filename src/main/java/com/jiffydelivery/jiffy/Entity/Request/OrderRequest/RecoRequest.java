package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecoRequest {
    private Address pickupAddress;
    private Address deliveryAddress;
    private int weight;
}
