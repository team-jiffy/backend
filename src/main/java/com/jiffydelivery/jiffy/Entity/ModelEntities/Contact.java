package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Contact {
    private String lastName;
    private String firstName;
    private String phone;
    private String email;

    private ContactType contactType;
    private Address address;

    private Card card;

    private boolean isDefaultContact;

    private String contactLabel;
}
