package com.jiffydelivery.jiffy.Entity.Constance;

public enum TripType {
    outside("outside"),
    charging("charging");

    private String tripType;

    TripType(String typeString){
        this.tripType = typeString;
    }

    public String getString(){
        return tripType;
    }
}
