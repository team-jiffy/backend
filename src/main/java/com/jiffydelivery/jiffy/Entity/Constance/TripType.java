package com.jiffydelivery.jiffy.Entity.Constance;

public enum TripType {
    outside("outside123"),
    charging("charging123");

    private String tripType;

    @Override
    public String toString(){
        return tripType;
    }
    TripType(String typeString){
        this.tripType = typeString;
    }

    public String getString(){
        return tripType;
    }
}
