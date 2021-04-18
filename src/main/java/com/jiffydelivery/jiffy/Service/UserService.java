package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerCreationResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//  @Autowired
//  private CustomerRepository customerRepository;
//
//  public CustomerCreationResponse CreateCustomerResponse (
//      CustomerCreationRequest customerCreationRequest){
//    customerRepository.createCustomer(customerCreationRequest);
//
//
//    CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
//
//    User user = new User();
//    return customerCreationResponse;
//  }
// public GetCustomerResponse getCustomer(int UID){
//
//    Customer dbuser = customerRepository.getCustomerProfile(UID);
//    User user = new User();
//    String s = Integer.toString(dbuser.getId());
//    user.setUID(s);
//    user.setLastName(dbuser.getLastName());
//    user.setFirstName(dbuser.getFirstName());
//    user.setEmail(dbuser.getEmail());
//    user.setPhone(dbuser.getPhone());
//    //// TODO: 4/18/21 setContactasDefault needed
////    user.setDefaultRecipient();
////    user.setDefaultSender();
//    user.setLocation();
//    user.setProfilePictureURL();
//
//   GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
//
// }
//
//
}
