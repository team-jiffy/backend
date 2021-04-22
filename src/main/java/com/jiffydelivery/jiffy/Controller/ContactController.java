package com.jiffydelivery.jiffy.Controller;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.DeleteAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetDefaultAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.*;
import com.jiffydelivery.jiffy.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class ContactController {

    @Autowired private ContactService contactService;

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.PUT)
    public AddAddressResponse addAddress(@RequestBody AddAddressRequest address,
                                         HttpServletRequest req, HttpServletResponse res) {

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            AddAddressResponse response = new AddAddressResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        //4/28
        //call contact service, input address request, return address response
        AddAddressResponse addressResponse = contactService.addAddressToUser(address);

        System.out.println(address.toString());
//        Contact a = new Contact("lastname","firstname","123",
//                "232@jiffy.com",ContactType.Sender, new Address(),
//                new Card(), "123",true);

        return addressResponse;
    }

    @RequestMapping(value = "/contact/updateContact", method = RequestMethod.POST)
    public UpdateAddressResponse updateAddress(@RequestBody UpdateAddressRequest address,
                                               HttpServletRequest req, HttpServletResponse res) {

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            UpdateAddressResponse response = new UpdateAddressResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        UpdateAddressResponse updateAddressResponse = contactService.updateAddress(address);

        System.out.println(address.toString());
//        Contact a = new Contact("lastname","firstname","123",
//                "232@jiffy.com",ContactType.Sender, new Address(),
//                new Card(), "123",true);
        return updateAddressResponse;
    }

    @RequestMapping(value = "/contact/setDefault", method = RequestMethod.POST)
    public SetDefaultAddressResponse setAddress(@RequestBody SetDefaultAddressRequest address,
                                         HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            SetDefaultAddressResponse response = new SetDefaultAddressResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        SetDefaultAddressResponse setDefaultAddressResponse = contactService.setAddressAsDefault(address);

        System.out.println(address.toString());
//        Contact a =  new Contact("lastname","firstname","123",
//                "232@jiffy.com",ContactType.Sender, new Address(),
//                new Card(), "123",true);
        return setDefaultAddressResponse;
    }

    @RequestMapping(value = "/contact/getContacts", method = RequestMethod.GET)
    public GetAddressResponse getAddress(@RequestParam String UID,
                                         HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            GetAddressResponse response = new GetAddressResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        System.out.println("testRequestParam: " + UID);
        return contactService.getAllAddresses(UID);
    }

    @RequestMapping(value = "contact/deleteContact", method = RequestMethod.DELETE)
    public DeleteAddressResponse deleteAddress(@RequestBody DeleteAddressRequest address,
                                               HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            DeleteAddressResponse response = new DeleteAddressResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        return contactService.deleteAddress(address);
    }
}
