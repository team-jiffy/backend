package com.jiffydelivery.jiffy.Entity.Constance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@Getter
public enum ContactType {

    Sender("sender"),
    Recipient("recipient");

    private String contactType;

    ContactType(String typeString){
        this.contactType = typeString;
    }

    @JsonValue
    public String getContactType(){
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
