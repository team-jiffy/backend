package com.jiffydelivery.jiffy.Entity.Response.ContactResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressResponse {
   public String Status;
   public String Message;
   public Contact Contact;
}
