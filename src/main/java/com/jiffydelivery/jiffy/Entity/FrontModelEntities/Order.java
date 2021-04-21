package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Constance.OrderStatus;
import lombok.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private int UID;
    private String OrderLabel;

    private Contact SenderContactId;
    private Contact RecipientContactId;

    private String TrackNumber;

    private User BuyerUserId;

    private com.jiffydelivery.jiffy.Entity.Constance.ADVType ADVType;
    private String ETA;
    private boolean SameDay;
    private String Price;
    private String OrderDate;
    private com.jiffydelivery.jiffy.Entity.Constance.OrderStatus OrderStatus;

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
        order.setPrice(Double.valueOf(this.Price));
        order.setSameday(this.SameDay);
        order.setOrderStatus(this.OrderStatus);
        Calendar cal= Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("dd/MM/yyyy")
                .parse(this.OrderDate,new ParsePosition(0)));
        order.setPlaceOrderDate(cal);
        order.setADVType(this.ADVType);
        order.setETA(new SimpleDateFormat("dd/MM/yyyy")
                .parse(this.ETA,new ParsePosition(0)));
        order.setCreditCard(this.PaymentCardId.toDAO());
        order.setSenderContact(this.SenderContactId.toDAO());
        order.setRecipientContact(this.RecipientContactId.toDAO());
        return order;
    }
}
