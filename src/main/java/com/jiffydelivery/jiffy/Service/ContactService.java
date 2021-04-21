package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Contact;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.DeleteAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetDefaultAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.AddAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.DeleteAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.SetDefaultAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.UpdateAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Repository.ContactRepository;
import java.util.ArrayList;
import java.util.List;
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


    public GetCustomerResponse getAllAddresses(String UID){
        List<com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact> frontContact = new ArrayList<>();
//         =  contactRepository.getAllAddress(UID);


        return new GetCustomerResponse();
    }
    //7. update address
    public UpdateAddressResponse updateAddress(UpdateAddressRequest address) {
        //mapping logic goes here



        return new UpdateAddressResponse();
    }

    //8. set address
    public SetDefaultAddressResponse setAddressAsDefault(SetDefaultAddressRequest request) {
        //mapping logic goes here



        return contactRepository.setContactAsDefault(request);
    }
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest deleteAddressRequest){

        return  contactRepository.deleteAddressforUser(deleteAddressRequest.getUID(),deleteAddressRequest.getContactID());


    }


}
