package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private String Email;
    private String LastName;
    private Contact DefaultSender;
    private String UID;
    private String FirstName;
    private String Phone;
    private String ProfilePictureURL;
    private Contact DefaultDeliver;
    private Address Location;

}