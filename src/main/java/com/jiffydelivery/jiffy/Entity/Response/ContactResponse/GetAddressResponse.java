package com.jiffydelivery.jiffy.Entity.Response.ContactResponse;


import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class GetAddressResponse {
    private String Status;
    private String Message;
    private List<Contact> Contacts;
}
