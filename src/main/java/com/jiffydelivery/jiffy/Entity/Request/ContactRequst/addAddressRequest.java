package com.jiffydelivery.jiffy.Entity.Request.ContactRequst;


import com.jiffydelivery.jiffy.Entity.ModelEntities.Contact;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class addAddressRequest {
    public String UID;
    Contact contact;
}


