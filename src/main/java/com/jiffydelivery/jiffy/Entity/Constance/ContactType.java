package com.jiffydelivery.jiffy.Entity.Constance;

import lombok.Getter;

@Getter
public enum ContactType {
    Sender("sender"),
    Recipient("recipient");

    private String contactType;

    ContactType(String typeString){
        this.contactType = typeString;
    }

    public String getString(){
        return contactType;
    }
}
