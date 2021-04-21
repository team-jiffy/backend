package com.jiffydelivery.jiffy.Entity.Constance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ADVType {
    Drone("drone"),
    Robot("robot");

    private String advType;

    ADVType(String typeString){
        this.advType = typeString;
    }

    @JsonValue
    public String getAdvType(){
        return advType;
    }

    @Override
    public String toString(){
        return  advType;
    }

    @JsonCreator
    public static ADVType fromValue(String text) {
        for (ADVType b : ADVType.values()) {
            if (String.valueOf(b.advType).equals(text)) {
                return b;
            }
        }
        return null;
    }
}