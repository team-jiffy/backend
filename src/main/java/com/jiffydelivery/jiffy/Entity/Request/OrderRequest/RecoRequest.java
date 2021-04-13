package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Address;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RecoRequest {
    public Address pickupAddress;
    public Address deliveryAddress;
}
