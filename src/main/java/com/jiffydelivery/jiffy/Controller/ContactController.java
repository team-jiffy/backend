package com.jiffydelivery.jiffy.Controller;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.ContactType;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.DeleteAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class ContactController {

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.PUT)
    public AddAddressResponse addAddress(@RequestBody AddAddressRequest address) {
        System.out.println(address.toString());
        Contact a = new Contact("lastname","firstname","123",
                "232@jiffy.com",ContactType.Sender, new Address(),
                new Card(), "123",true);
        return new AddAddressResponse("ok","ok",a);
    }

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.POST)
    public UpdateAddressResponse updateAddress(@RequestBody UpdateAddressRequest address) {
        System.out.println(address.toString());
        Contact a = new Contact("lastname","firstname","123",
                "232@jiffy.com",ContactType.Sender, new Address(),
                new Card(), "123",true);
        return new UpdateAddressResponse("ok","ok",a);
    }

    @RequestMapping(value = "/contact/setDefault", method = RequestMethod.POST)
    public SetAddressResponse setAddress(@RequestBody SetAddressRequest address) {
        System.out.println(address.toString());
        Contact a =  new Contact("lastname","firstname","123",
                "232@jiffy.com",ContactType.Sender, new Address(),
                new Card(), "123",true);
        return new SetAddressResponse("ok","ok",a);
    }

    @RequestMapping(value = "/contact/getContact", method = RequestMethod.GET)
    public GetAddressResponse getAddress(@RequestParam(value="UID") String ContactID) {
        System.out.println("testRequestParam: " + ContactID);
        return new GetAddressResponse("id");
    }

    @RequestMapping(value = "contact/deleteContact", method = RequestMethod.DELETE)
    public DeleteAddressResponse deleteAddress(@RequestBody DeleteAddressRequest address) {
        String a = address.toString();
        System.out.println(address.toString());
        return new DeleteAddressResponse("ok", "success");
    }
}