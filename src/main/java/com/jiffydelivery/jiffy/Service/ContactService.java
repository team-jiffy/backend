package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
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

import javax.print.DocFlavor;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    //9. add address
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
        //mapping logic goes here
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbcontact =
                contactRepository.addContactToUser(addAddressRequest.getUID(), addAddressRequest.getContact());
        User user = new User();
        Card card = new Card();
        Contact frontContact = new Contact();
        Address dbAddress = new Address();
        User.setUID(dbcontact.getUID());
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address frontAddress =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address();
        frontAddress.setStreet1(dbAddress.getStreet1());
        frontAddress.setStreet2(dbAddress.getStreet2());
        frontAddress.setZip(dbAddress.getZip());
        frontAddress.setAptNo(dbAddress.getAptNo());
        frontAddress.setCity(dbAddress.getCity());
        frontAddress.setState(dbAddress.setState());

        frontContact.setLastName(dbcontact.getLastName());
        frontContact.setPhone(dbcontact.getPhone());
        frontContact.setAddress(frontAddress);
        frontContact.setCard(card);
        frontContact.setFirstName(dbcontact.getLastName());
        frontContact.setEmail(dbcontact.getEmail());
        frontContact.setContactType(dbcontact.setContactType(String));
        frontContact.setDefaultContact(dbcontact.isGetDefaultContact());
        frontContact.setContactLabel(dbcontact.getGetContactLabel());


        AddAddressResponse addAddressResponse = new AddAddressResponse();
        if (dbcontact == null) {
            addAddressResponse.setMessage("addAddress fail.");
            addAddressResponse.setStatus("404");
        } else {
            addAddressResponse.setMessage("addAddress success");
            addAddressResponse.setContact(frontContact);
            addAddressResponse.setStatus("200");
        }
        return new AddAddressResponse();
    }

    //7. update address
    public UpdateAddressResponse updateAddress(UpdateAddressRequest updateAddressRequest) {
        //mapping logic goes here
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact dbcontact =
                contactRepository.updateContactToUser(updateAddressRequest.getUID(),
                        updateAddressRequest.getContact(), updateAddressRequest.getContactId());

        Card card = new Card();
        Contact frontContact = new Contact();
        Address dbAddress = new Address();
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address frontAddress =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address();
        frontAddress.setStreet1(dbAddress.getStreet1());
        frontAddress.setStreet2(dbAddress.getStreet2());
        frontAddress.setZip(dbAddress.getZip());
        frontAddress.setAptNo(dbAddress.getAptNo());
        frontAddress.setCity(dbAddress.getCity());
        frontAddress.setState(dbAddress.setState());

        frontContact.setLastName(dbcontact.getLastName());
        frontContact.setPhone(dbcontact.getPhone());
        frontContact.setAddress(frontAddress);
        frontContact.setCard(card);
        frontContact.setFirstName(dbcontact.getLastName());
        frontContact.setEmail(dbcontact.getEmail());
        frontContact.setContactType(dbcontact.setContactType(String));
        frontContact.setDefaultContact(dbcontact.isGetDefaultContact());
        frontContact.setContactLabel(dbcontact.getGetContactLabel());


        UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();
        if (dbcontact == null) {
            updateAddressResponse.setMessage("update fail.");
            updateAddressResponse.setContact("404");
        } else {
            updateAddressResponse.setMessage("update success");
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
            User.setUID(dbcontact.getUID());
            User.setContactID(dbcontact.setContactID());


            SetAddressResponse setAddressResponse = new SetAddressResponse();
            if (dbcontact == null) {
                setAddressResponse.setMessage("set fail.");
                setAddressResponse.setStatus("404");
            } else {
                setAddressResponse.setMessage("set success");
                setAddressResponse.setContact(user);
                setAddressResponse.setStatus("200");
            }
            return new SetAddressResponse();
    }


}
