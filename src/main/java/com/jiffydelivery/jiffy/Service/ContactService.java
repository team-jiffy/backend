package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Contact;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.DeleteAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetDefaultAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.AddAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.DeleteAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.GetAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.SetDefaultAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.UpdateAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Repository.ContactRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    //9. add address
    public AddAddressResponse addAddressToUser(AddAddressRequest request) {
        AddAddressResponse addAddressResponse = new AddAddressResponse();
        Contact dbContact = contactRepository.addContact(request.getUID(), request.getContact());
        if (dbContact.getCustomer()!=null){
            addAddressResponse.setMessage("add contact to user succeed");
            addAddressResponse.setStatus("200");
        }
        else {
            addAddressResponse.setMessage("something wrong");
        }
        return addAddressResponse ;
    }

    public UpdateAddressResponse updateAddress(UpdateAddressRequest request) {

        UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();
        Contact dbContact = contactRepository.updateContact(request.getUID(), request.getContact(), request.getContactID());
        if (dbContact.getCustomer()!=null){
            updateAddressResponse.setMessage("update contact to user succeed");
            updateAddressResponse.setStatus("200");
        }
        else {
            updateAddressResponse.setMessage("update contact to user failed");
        }
        return updateAddressResponse ;
    }
    public GetAddressResponse getAllAddresses(String UID){
        List<com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact> frontContactList = new ArrayList<>();
        List<Contact> backendContactList =  contactRepository.getAllAddress(UID);
        GetAddressResponse response = new GetAddressResponse();
        frontContactList = backendContactList.stream().map(backContact -> new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact(backContact)).collect(
            Collectors.toList());
        if(backendContactList!=null){
            response.setStatus("200");
            response.setMessage("all contacts retrived!");
            response.setContacts(frontContactList);
        }else {
            response.setStatus("400");
            response.setMessage("fail");
        }
        return response;
    }
    //8. set address
    public SetDefaultAddressResponse setAddressAsDefault(SetDefaultAddressRequest request) {
        return contactRepository.setContactAsDefault(request);
    }

    public DeleteAddressResponse deleteAddress(DeleteAddressRequest deleteAddressRequest){
        return  contactRepository.deleteAddressforUser(deleteAddressRequest.getUID(),deleteAddressRequest.getContactID());
    }

}
