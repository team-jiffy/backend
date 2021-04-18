package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.Contact;
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
    public AddAddressResponse addAddress(AddAddressRequest address) {
        //mapping logic goes here


        return new AddAddressResponse();
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


}
