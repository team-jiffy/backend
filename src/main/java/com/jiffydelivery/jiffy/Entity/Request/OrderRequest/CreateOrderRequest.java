package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Pickup;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Deliver;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateOrderRequest {
    private String ADVType;
    private String OrderDate;
    private String CardId;
    private boolean SameDay;

    private Pickup PickupInfo;
    private Deliver DeliverInfo;

    private Coordinates DeliverCoordinates;
    private Coordinates PickupCoordinates;

    // price is a double on the frontend
    private double Price;
}
