package com.jiffydelivery.jiffy.Controller;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.ContactType;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.addAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.addAddressResponse;
import org.springframework.web.bind.annotation.*;


@RestController
public class ContactController {

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.PUT)
    public addAddressResponse addAddress(@RequestBody addAddressRequest address) {
        System.out.println(address.toString());
        Contact a = new Contact("lastname","firstname","123","232@jiffy.com",ContactType.Sender, new Address(),
                new Card(), "123",true);
        return new addAddressResponse("ok","ok",a);
    }


}