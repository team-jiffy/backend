package com.jiffydelivery.jiffy.Entity.Constance;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum ContactType {
    sender("sender"),
    recipient("recipient");

    private String contactType;

    ContactType(String typeString){
        this.contactType = typeString;
    }

    public String getString(){
        return contactType;
    }


    @Override
    public String toString(){
        return  contactType;
    }

    @JsonCreator
    public static ContactType fromValue(String text) {
        for (ContactType b : ContactType.values()) {
            if (String.valueOf(b.contactType).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
