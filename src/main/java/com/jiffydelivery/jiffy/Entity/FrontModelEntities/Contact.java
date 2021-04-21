package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ContactType;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {

    private String LastName;
    private String FirstName;
    private String Phone;
    private String Email;
    private com.jiffydelivery.jiffy.Entity.Constance.ContactType ContactType;

    private Address Address;

    private Card Card;

    private String ContactLabel;
    private boolean Default;
}
