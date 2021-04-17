package com.jiffydelivery.jiffy.Entity.Response.ContactResponse;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Contact;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class addAddressResponse {
    String Status;
    String Message;
    Contact Contact;
}
