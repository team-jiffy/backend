package com.jiffydelivery.jiffy.Entity.Request.OrderRequest;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.PlaceOrderContact;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewOrderRequest {
    private com.jiffydelivery.jiffy.Entity.Constance.ADVType ADVType;
    private String orderDate;
    private String cardId;
    private boolean sameDay;
    private double price;
    private int UID;

    private PlaceOrderContact Pickup;
    private PlaceOrderContact Deliver;
    private PositionCoordinates DeliverCoordinates;
    private PositionCoordinates PickupCoordinates;
    // price is a double

}
