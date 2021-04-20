package com.jiffydelivery.jiffy.Entity.Constance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TripType {
    Outside("outside"),
    Charging("charging");

    private String tripType;

    @Override
    public String toString(){
        return tripType;
    }
    TripType(String typeString){
        this.tripType = typeString;
    }
    @JsonValue
    public String getTripType(){
        return tripType;
    }

    @JsonCreator
    public static TripType fromValue(String text) {
        for (TripType b : TripType.values()) {
            if (String.valueOf(b.tripType).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
