package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private final String UID;

    private String lastName;
    private String firstName;
    private String phone;
    private String email;

    private Contact defaultSender;
    private Contact defaultRecipient;

    private String profilePictureURL;

    private Address location;
}
