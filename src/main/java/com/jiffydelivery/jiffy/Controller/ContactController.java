package com.jiffydelivery.jiffy.Controller;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.ModelEntities.ContactType;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.addAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.addAddressResponse;
import org.springframework.web.bind.annotation.*;


@RestController
public class ContactController {

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.PUT)
    public addAddressResponse addAddress(@RequestBody addAddressRequest address) {
        System.out.println(address.toString());
        Contact a = new Contact("123",true,"123","232","234","234",
                ContactType.Sender,new Address(),new Card());
        return new addAddressResponse("ok","ok",a);
    }


}