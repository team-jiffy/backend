package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Pickup;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Deliver;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
//public class RecoRequest {
//    private Address pickupAddress;
//    private Address deliveryAddress;
//    private int weight;
//}
public class RecoRequest {
    private Address Deliver;
    private Address Pickup;
    private int weight;
}

