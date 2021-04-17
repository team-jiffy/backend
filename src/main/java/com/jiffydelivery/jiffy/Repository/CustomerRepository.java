package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;

    ;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CreateCustomerRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CreateCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LogoutResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.UpdateCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.UpdatePasswordResponse;
import com.jiffydelivery.jiffy.JiffyApplication;
import com.jiffydelivery.jiffy.JiffyApplicationConfig;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
  @Autowired
  private SessionFactory sessionFactory;

  public LoginResponse loginVerify (String email, String password){
    LoginResponse loginResponse = new LoginResponse();
    Customer
        user = null;
    try (Session session = sessionFactory.openSession()) {
      //// TODO: 4/17/21
      user = session.get(Customer
          .class,email);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if(user!= null && user.getPassword() == password){
      loginResponse.setMessage("user verify success.");
      loginResponse.setCustomer
          (user);
      loginResponse.setStatus("200");
      return loginResponse;

    }
    else return null;
  }


  public LogoutResponse logoutVerify (String UID){
    LogoutResponse logoutResponse = new LogoutResponse();
    Customer
        user = null;
    try (Session session = sessionFactory.openSession()) {
      //// TODO: 4/17/21
      user = session.get(Customer
          .class,UID);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    //// TODO: 4/17/21 怎么知道logout了 是token? 还是什么
    if(user!= null){
      logoutResponse.setMessage("logout success.");

      logoutResponse.setStatus("200");


    }
    else {
      logoutResponse.setMessage("logout fail.");

      logoutResponse.setStatus("401");

    }
    return logoutResponse;

  }
//create customer
  public CreateCustomerResponse createCustomer (CreateCustomerRequest createCustomerRequest){
    Session session = null;
    CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();
    Customer user = new Customer();
    user.setEmail(createCustomerRequest.getEmail());
    user.setFirstName(createCustomerRequest.getFirstName());
    user.setLastName(createCustomerRequest.getLastName());
    user.setPassword(createCustomerRequest.getPassword());
    try {
      session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();
    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();
      createCustomerResponse.setMessage("fail");
    } finally {
      if (session != null) {
        session.close();
      }
    }
    createCustomerResponse.setMessage("success");
    createCustomerResponse.setStatus("200");
    createCustomerResponse.setCustomer(user);
    return createCustomerResponse;
  }
//update password
  public UpdatePasswordResponse updatePassword (String UID, String password){
    Session session = null;
    UpdatePasswordResponse updatePasswordResponse = new UpdatePasswordResponse();
    Customer
        user= null;

    try {
      session = sessionFactory.openSession();
      user = session.get(Customer
          .class,UID);
      if(user == null ){
        updatePasswordResponse.setMessage("user not found");
        updatePasswordResponse.setStatus("404");

      }
      user.setPassword(password);
      session.beginTransaction();
      session.update(user);
      session.getTransaction().commit();
    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();
      updatePasswordResponse.setMessage("fail");
    } finally {
      if (session != null) {
        session.close();
      }
    }
    updatePasswordResponse.setMessage("update success");
    updatePasswordResponse.setStatus("200");

    return updatePasswordResponse;
  }
//get customer information
  public GetCustomerResponse getCustomerProfile (int UID){
    GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
    Customer
        user = null;
    try (Session session = sessionFactory.openSession()) {
      user = session.get(Customer
          .class,UID);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if(user!= null){
      getCustomerResponse.setMessage("get user success.");
      getCustomerResponse.setCustomer(user);
      getCustomerResponse.setStatus("200");


    }
    else{
      getCustomerResponse.setMessage("get user fail.");
      getCustomerResponse.setStatus("404");

    }
    return getCustomerResponse;
  }

  //update customer profile
  public UpdateCustomerResponse updateCustomer (Customer
      updatedCustomer
  ){
    Session session = null;
    UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();
    Customer
        user= null;

    try {
      session = sessionFactory.openSession();
      user = session.get(Customer
          .class,updatedCustomer
          .getId());
      if(user == null ){
        updateCustomerResponse.setMessage("user not found");
        updateCustomerResponse.setStatus("404");

      } else {
        user = updatedCustomer;
        session.beginTransaction();
        session.update(user
        );
        session.getTransaction().commit();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();
      updateCustomerResponse.setMessage("fail");
    } finally {
      if (session != null) {
        session.close();
      }
    }
    updateCustomerResponse.setMessage("update success");
    updateCustomerResponse.setStatus("200");
    updateCustomerResponse.setCustomer(user);
    return updateCustomerResponse;
  }


  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        JiffyApplicationConfig.class);

    CustomerRepository test=  applicationContext.getBean(CustomerRepository.class);
    // 1. Test for customer creation
    // CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest("1@gmail.com","ethan","hunt","12345");
    // test.createCustomer(createCustomerRequest);
    // 2. test for customer update
    // Customer testCustomer = new Customer(5,"update@email.com","oldpass","admin","updatefirst","updateLast","update phone",null,null,null);
    // test.updateCustomer(testCustomer);
    // 3. test for getting customer profile
    // String log = test.getCustomerProfile(3).getCustomer().toString();
    // System.out.println(log);

//        test.updatePassword();

  }


}
