package com.jiffydelivery.jiffy.Entity.Constance;

public enum OrderStatus {
    placed("Order Placed"),
    onTheWay("On the way to pick up"),
    onDeliver("On deliver"),
    delivered("Delivered");

    private String orderStatus;

    OrderStatus(String typeString){
        this.orderStatus = typeString;
    }

    public String getString(){
        return orderStatus;
    }
}
