package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    public String email;
    public String LastName;
    public String UID;
    public String FirstName;
    public String Phone;
    public String ProfilePictureURL;
    public Contact DefaultSender;
    public Contact DefaultDeliver;
    public Address Location;
}
