package com.jiffydelivery.jiffy.Entity.Constance;

public enum ADVType {
    drone("Drone"),
    pRobot("Private Robot"),
    sRobot("Shared Robot");

    private String advType;

    ADVType(String typeString){
        this.advType = typeString;
    }

    public String getString(){
        return advType;
    }
}
