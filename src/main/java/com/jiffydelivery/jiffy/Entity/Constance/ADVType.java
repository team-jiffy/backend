package com.jiffydelivery.jiffy.Entity.Constance;

public enum ADVType {
    drone("drone"),
    Robot("robot");

    private String advType;

    ADVType(String typeString){
        this.advType = typeString;
    }

    public String getString(){
        return advType;
    }
}
