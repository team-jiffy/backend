package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private String email;
    private String lastName;
    private Contact defaultSender;
    private String UID;
    private String firstName;
    private String phone;
    private String profilePictureURL;
    private Contact defaultRecipient;
    private Address location;

}