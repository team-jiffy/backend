package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Address;
import com.jiffydelivery.jiffy.Entity.DBDAO.Contact;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.AddAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.DeleteAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.SetAddressRequest;
import com.jiffydelivery.jiffy.Entity.Request.ContactRequst.UpdateAddressRequest;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.AddAddressResponse;
import com.jiffydelivery.jiffy.Entity.Response.ContactResponse.DeleteAddressResponse;
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

    //7. update address
    public UpdateAddressResponse updateAddress(UpdateAddressRequest address) {
        //mapping logic goes here



        return new UpdateAddressResponse();
    }

    //8. set address
    public SetAddressResponse setAddress(SetAddressRequest addressRequest) {
        //mapping logic goes here



        return new SetAddressResponse();
    }
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest deleteAddressRequest){

        return  contactRepository.deleteAddressforUser(deleteAddressRequest.getUID(),deleteAddressRequest.getContactID());


    }


}
