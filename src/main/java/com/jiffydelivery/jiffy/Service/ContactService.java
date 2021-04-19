package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.AddAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.SetAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.UpdateAddressResponse;
import com.jiffydelivery.jiffy.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    //9. add address
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
        //mapping logic goes here
        Contact dbcontact = contactRepository.addContact(addAddressRequest.getUID(), addAddressRequest.getContact());
        User user = new User();
        String s = Integer.toString(dbcontact.getID());
        user.getUID(s);
        user.setLastName(dbcontact.getLastName());
        user.setFirstName(dbcontact.getFirstName());
        user.setEmail(dbcontact.getEmail());
        user.setPhone(dbcontact.getPhone());
        user.setAddress(dbcontact.getAddress());


        AddAddressResponse addAddressResponse = new AddAddressResponse();
        if (dbcontact == null) {
            addAddressResponse.setMessage("user creation fail.");
            addAddressResponse.setStatus("404");
        } else {
            addAddressResponse.setMessage("user creation success");
            addAddressResponse.setContact(Contact);
            addAddressResponse.setStatus("200");
        }
        return new AddAddressResponse();
    }

    //7. update address
    public UpdateAddressResponse updateAddress(UpdateAddressRequest updateAddressRequest) {
        //mapping logic goes here
        Contact dbcontact = contactRepository.updateContact(updateAddressRequest.getUID(), updateAddressRequest.getContact());
        User user = new User();



        UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();
        if (dbcontact == null) {
            updateAddressResponse.setMessage("user creation fail.");
            updateAddressResponse.setContact("404");
        } else {
            updateAddressResponse.setMessage("user creation success");
            updateAddressResponse.setContact(Contact);
            updateAddressResponse.getStatus("200");
        }

        return new UpdateAddressResponse();
    }

    //8. set address
    public SetAddressResponse setAddress(SetAddressRequest setAddressRequest) {
        //mapping logic goes here
        Contact dbcontact = contactRepository.setContact(setAddressRequest.getContactID(), setAddressRequest.getUID());
        User user = new User();




        SetAddressResponse setAddressResponse = new SetAddressResponse();
        if (dbcontact == null) {
            setAddressResponse.setMessage("user creation fail.");
            setAddressResponse.setStatus("404");
        } else {
            setAddressResponse.setMessage("user creation success");
            setAddressResponse.setContact(Contact);
            setAddressResponse.setStatus("200");
        }
        return new SetAddressResponse();
    }


}
