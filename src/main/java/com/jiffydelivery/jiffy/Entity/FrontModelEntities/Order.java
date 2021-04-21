package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {

    private String OrderLabel;

    private Contact SenderContactId;
    private Contact RecipientContactId;

    private int TrackNumber;

    private User BuyerUserId;

    private com.jiffydelivery.jiffy.Entity.Constance.ADVType ADVType;
    private String ETA;
    private boolean SameDay;
    private String Price;
    private String OrderDate;
    private String OrderStatus;

    private String PackageInfo;

    private Position Position;

    private Card PaymentCardId;

    public com.jiffydelivery.jiffy.Entity.DBDAO.Order toDAO(){
        com.jiffydelivery.jiffy.Entity.DBDAO.Order order =
                new com.jiffydelivery.jiffy.Entity.DBDAO.Order();
        order.setTrackNumber(String.valueOf(this.TrackNumber));
        order.setADVType(this.ADVType);
        order.setOrderLabel(this.OrderLabel);
        order.setPrice(Double.valueOf(this.Price));
        order.setSameday(this.SameDay);
        //todo make up
//        order.setPlaceOrderDate();
//        order.setOrderStatus();
        return order;
    }
}
