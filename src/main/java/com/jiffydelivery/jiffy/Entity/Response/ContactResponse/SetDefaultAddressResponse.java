package com.jiffydelivery.jiffy.Entity.Response.ContactResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SetDefaultAddressResponse {
   public String Status;
   public String Message;
   public com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact Contact;
}
