package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Address;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RecoRequest {
    public Address pickupAddress;
    public Address deliveryAddress;
}
