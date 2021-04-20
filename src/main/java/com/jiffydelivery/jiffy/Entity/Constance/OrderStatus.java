package com.jiffydelivery.jiffy.Entity.Constance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    Placed("Order Placed"),
    OnTheWay("On the way to pick up"),
    OnDeliver("On deliver"),
    Delivered("Delivered");

    private String orderStatus;

    @Override
    public String toString(){
        return orderStatus;
    }

    OrderStatus(String typeString){
        this.orderStatus = typeString;
    }
    @JsonValue
    public String getOrderStatus(){
        return orderStatus;
    }

    @JsonCreator
    public static OrderStatus fromValue(String text){
        for (OrderStatus b : OrderStatus.values()) {
            if (String.valueOf(b.orderStatus).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
