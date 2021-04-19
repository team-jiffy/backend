package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerCreationResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.PasswordUpdateResponse;
import com.jiffydelivery.jiffy.JiffyApplicationConfig;
import com.jiffydelivery.jiffy.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
      CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
      if (dbuser == null) {
        customerCreationResponse.setMessage("user creation fail.");
        customerCreationResponse.setStatus("404");
      } else {
        String s = Integer.toString((int) dbuser.getId());

        user.setUID(s);
        user.setLastName(dbuser.getLastName());
        user.setFirstName(dbuser.getFirstName());
        user.setEmail(dbuser.getEmail());
        user.setPhone(dbuser.getPhone());
        user.setProfilePictureURL(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");
        customerCreationResponse.setMessage("user creation success.");
        customerCreationResponse.setUser(user);
        customerCreationResponse.setStatus("200");
      }

      return customerCreationResponse;
    }

    public GetCustomerResponse getCustomer ( int UID){

      Customer dbuser = customerRepository.getCustomerProfile(UID);
      User user = new User();


      GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
      if (dbuser == null) {

        getCustomerResponse.setMessage("get user fail.");
        getCustomerResponse.setStatus("404");
      } else {
        String s = Integer.toString((int) dbuser.getId());
        user.setUID(s);
        user.setLastName(dbuser.getLastName());
        user.setFirstName(dbuser.getFirstName());
        user.setEmail(dbuser.getEmail());
        user.setPhone(dbuser.getPhone());
        user.setProfilePictureURL(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");
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


      if (dbuser == null) {
        customerUpdateResponse.setMessage("user update fail.");
        customerUpdateResponse.setStatus("404");
      } else {

        String s = Integer.toString((int) dbuser.getId());
        user.setUID(s);
        user.setLastName(dbuser.getLastName());
        user.setFirstName(dbuser.getFirstName());
        user.setEmail(dbuser.getEmail());
        user.setPhone(dbuser.getPhone());
        user.setProfilePictureURL(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");
        customerUpdateResponse.setMessage("user update success.");
        customerUpdateResponse.setUser(user);
        customerUpdateResponse.setStatus("200");
      }

      return customerUpdateResponse;

    }

    public PasswordUpdateResponse updatePassword (String UID, String password){
      return customerRepository.updatePassword(UID, password);


    }

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            JiffyApplicationConfig.class);

    CustomerRepository test=  applicationContext.getBean(CustomerRepository.class);
    // 1. Test for customer creation
    // CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest("1@gmail.com","ethan","hunt","12345");
    // test.createCustomer(createCustomerRequest);
//     2. test for customer update
    Customer testCustomer = new Customer(5,"xxxxx","oldpass","admin","updatefirst","updateLast","update phone",
            null,null,null);
    User testUser = new User("yubo@mail", "zhang", null, "3", "Yubo", "1231", "ccc", null, null);
    test.updateCustomer(testUser);
    // 3. test for getting customer profile
    // String log = test.getCustomerProfile(3).getCustomer().toString();
    // System.out.println(log);

//        test.updatePassword();

  }

}
