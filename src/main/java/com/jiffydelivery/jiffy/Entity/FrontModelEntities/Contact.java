package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contact {

    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private ContactType contactType;

    private Address address;

    private Card card;

    private String contactLabel;
    private boolean isDefaultContact;
}
