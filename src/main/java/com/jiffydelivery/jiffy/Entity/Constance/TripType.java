package com.jiffydelivery.jiffy.Entity.Constance;

public enum TripType {
    outside("Outside"),
    charging("Charging");

    private String tripType;

    TripType(String typeString){
        this.tripType = typeString;
    }

    public String getString(){
        return tripType;
    }
}
