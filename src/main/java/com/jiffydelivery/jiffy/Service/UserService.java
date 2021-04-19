package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerCreationResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.PasswordUpdateResponse;
import com.jiffydelivery.jiffy.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private CustomerRepository customerRepository;


  public LoginResponse loginVerify(String email, String password) {

    LoginResponse loginResponse = new LoginResponse();
    Customer dbuser = customerRepository.loginVerify(email, password);
    User user = new User();

    if (dbuser != null && dbuser.getPassword() == password) {


      String s = Integer.toString((int) dbuser.getId());

      user.setUID(s);
      user.setLastName(dbuser.getLastName());
      user.setFirstName(dbuser.getFirstName());
      user.setEmail(dbuser.getEmail());
      user.setPhone(dbuser.getPhone());
      user.setProfilePictureURL(
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");
      loginResponse.setMessage("user verify success.");
      loginResponse.setStatus("200");
      loginResponse.setUser(user);


    }
    else {
      loginResponse.setMessage("user verify fail.");
      loginResponse.setStatus("400");

    }
    return loginResponse;
  }

    public CustomerCreationResponse CreateCustomerResponse (
        CustomerCreationRequest customerCreationRequest){
      Customer dbuser = customerRepository.createCustomer(customerCreationRequest);
      User user = new User();
      String s = Integer.toString((int) dbuser.getId());

      user.setUID(s);
      user.setLastName(dbuser.getLastName());
      user.setFirstName(dbuser.getFirstName());
      user.setEmail(dbuser.getEmail());
      user.setPhone(dbuser.getPhone());
      user.setProfilePictureURL(
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");

      CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
      if (dbuser == null) {
        customerCreationResponse.setMessage("user creation fail.");
        customerCreationResponse.setStatus("404");
      } else {
        customerCreationResponse.setMessage("user creation success.");
        customerCreationResponse.setUser(user);
        customerCreationResponse.setStatus("200");
      }

      return customerCreationResponse;
    }

    public GetCustomerResponse getCustomer ( int UID){

      Customer dbuser = customerRepository.getCustomerProfile(UID);
      User user = new User();
      String s = Integer.toString((int) dbuser.getId());
      user.setUID(s);
      user.setLastName(dbuser.getLastName());
      user.setFirstName(dbuser.getFirstName());
      user.setEmail(dbuser.getEmail());
      user.setPhone(dbuser.getPhone());

//    user.setDefaultRecipient();
//    user.setDefaultSender();
//    user.setLocation();
      user.setProfilePictureURL(
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");

      GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
      if (dbuser == null) {
        getCustomerResponse.setMessage("get user fail.");
        getCustomerResponse.setStatus("404");
      } else {
        getCustomerResponse.setMessage("get user success.");
        getCustomerResponse.setUser(user);
        getCustomerResponse.setStatus("200");
      }
      return getCustomerResponse;
    }

    public CustomerUpdateResponse updateCustomer (User updatedUser){

      CustomerUpdateResponse customerUpdateResponse = new CustomerUpdateResponse();

      Customer dbuser = customerRepository.updateCustomer(updatedUser);
      User user = new User();
      String s = Integer.toString((int) dbuser.getId());
      user.setUID(s);
      user.setLastName(dbuser.getLastName());
      user.setFirstName(dbuser.getFirstName());
      user.setEmail(dbuser.getEmail());
      user.setPhone(dbuser.getPhone());
      user.setProfilePictureURL(
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");

      if (dbuser == null) {
        customerUpdateResponse.setMessage("user update fail.");
        customerUpdateResponse.setStatus("404");
      } else {
        customerUpdateResponse.setMessage("user update success.");
        customerUpdateResponse.setUser(user);
        customerUpdateResponse.setStatus("200");
      }

      return customerUpdateResponse;

    }

    public PasswordUpdateResponse updatePassword (String UID, String password){
      return customerRepository.updatePassword(UID, password);


    }
  }
<<<<<<< HEAD

  public User checkUserPassword(String email, String password){
//    return contactRepository.CheckUserPassword(email,password);
    return new User();
  }
}
=======
>>>>>>> e8df8f73a3088d6c046f564a7d4ba959427f9f9e
