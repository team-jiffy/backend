package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private String UID;

    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String password;
    private Contact defaultSender;

    private Contact defaultRecipient;

    private String profilePictureURL;

    private Address location;
}
