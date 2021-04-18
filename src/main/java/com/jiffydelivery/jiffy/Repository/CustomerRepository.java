package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;

    ;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.PasswordUpdateResponse;
import com.jiffydelivery.jiffy.JiffyApplicationConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
//  @Autowired
//  private SessionFactory sessionFactory;
//
////  public LoginResponse loginVerify (String email, String password){
////    LoginResponse loginResponse = new LoginResponse();
////    Customer
////        user = null;
////    try (Session session = sessionFactory.openSession()) {
////      //// TODO: 4/17/21
////      user = session.get(Customer
////          .class,email);
////    } catch (Exception ex) {
////      ex.printStackTrace();
////    }
////    if(user!= null && user.getPassword() == password){
////      loginResponse.setMessage("user verify success.");
////      loginResponse.setCustomer
////          (user);
////      loginResponse.setStatus("200");
////      return loginResponse;
////
////    }
////    else return null;
////  }
////
////
////  public LogoutResponse logoutVerify (String UID){
////    LogoutResponse logoutResponse = new LogoutResponse();
////    Customer
////        user = null;
////    try (Session session = sessionFactory.openSession()) {
////      //// TODO: 4/17/21
////      user = session.get(Customer
////          .class,UID);
////    } catch (Exception ex) {
////      ex.printStackTrace();
////    }
////    //// TODO: 4/17/21 怎么知道logout了 是token? 还是什么
////    if(user!= null){
////      logoutResponse.setMessage("logout success.");
////
////      logoutResponse.setStatus("200");
////
////
////    }
////    else {
////      logoutResponse.setMessage("logout fail.");
////
////      logoutResponse.setStatus("401");
////
////    }
////    return logoutResponse;
////
////  }
//
//
//
//
////create customer
//  public Customer createCustomer (CustomerCreationRequest customerCreationRequest){
//    Session session = null;
//    //CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
//    Customer user = new Customer();
//    user.setEmail(customerCreationRequest.getEmail());
//    user.setFirstName(customerCreationRequest.getFirstName());
//    user.setLastName(customerCreationRequest.getLastName());
//    user.setPassword(customerCreationRequest.getPassword());
//    try {
//      session = sessionFactory.openSession();
//      session.beginTransaction();
//      session.save(user);
//      session.getTransaction().commit();
//    } catch (Exception ex) {
//      ex.printStackTrace();
//      session.getTransaction().rollback();
//      //createCustomerResponse.setMessage("fail");
//    } finally {
//      if (session != null) {
//        session.close();
//      }
//    }
////    createCustomerResponse.setMessage("success");
////    createCustomerResponse.setStatus("200");
////    createCustomerResponse.setUser(user);
//    return user;
//  }
//
//
//
////update password
//  public PasswordUpdateResponse updatePassword (String UID, String password){
//    Session session = null;
//    PasswordUpdateResponse passwordUpdateResponse = new PasswordUpdateResponse();
//    Customer
//        user= null;
//
//    try {
//      session = sessionFactory.openSession();
//      user = session.get(Customer
//          .class,UID);
//      if(user == null ){
//        passwordUpdateResponse.setMessage("user not found");
//        passwordUpdateResponse.setStatus("404");
//
//      }
//      user.setPassword(password);
//      session.beginTransaction();
//      session.update(user);
//      session.getTransaction().commit();
//    } catch (Exception ex) {
//      ex.printStackTrace();
//      session.getTransaction().rollback();
//      passwordUpdateResponse.setMessage("fail");
//    } finally {
//      if (session != null) {
//        session.close();
//      }
//    }
//    passwordUpdateResponse.setMessage("update success");
//    passwordUpdateResponse.setStatus("200");
//
//    return passwordUpdateResponse;
//  }
////get customer information
//  public Customer getCustomerProfile (int UID){
//    GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
//    Customer user = null;
//    try (Session session = sessionFactory.openSession()) {
//      user = session.get(Customer
//          .class,UID);
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//    if(user!= null){
//      getCustomerResponse.setMessage("get user success.");
//      getCustomerResponse.setCustomer(user);
//      getCustomerResponse.setStatus("200");
//
//
//    }
//    else{
//      getCustomerResponse.setMessage("get user fail.");
//      getCustomerResponse.setStatus("404");
//
//    }
//    return getCustomerResponse;
//  }
//
//  //update customer profile
//  public CustomerUpdateResponse updateCustomer (Customer
//      updatedCustomer
//  ){
//    Session session = null;
//    CustomerUpdateResponse customerUpdateResponse = new CustomerUpdateResponse();
//    Customer
//        user= null;
//
//    try {
//      session = sessionFactory.openSession();
////      user = session.get(Customer
////          .class,updatedCustomer
////          .getId());
//      if(updatedCustomer == null ){
//        customerUpdateResponse.setMessage("user not found");
//        customerUpdateResponse.setStatus("404");
//
//      } else {
//        //user = updatedCustomer;
//        session.beginTransaction();
//        try{ session.saveOrUpdate(updatedCustomer
//        );}
//        catch (Exception ex){
//          ex.printStackTrace();
//          customerUpdateResponse.setMessage("fail");
//        }
////        session.update(updatedCustomer
////        );
//        session.getTransaction().commit();
//      }
//    } catch (Exception ex) {
//      ex.printStackTrace();
//      session.getTransaction().rollback();
//      customerUpdateResponse.setMessage("fail");
//    } finally {
//      if (session != null) {
//        session.close();
//      }
//    }
////    customerUpdateResponse.setMessage("update success");
////    customerUpdateResponse.setStatus("200");
////    customerUpdateResponse.setCustomer(user);
//    return customerUpdateResponse;
//  }
//
//
//  public static void main(String[] args) {
//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//        JiffyApplicationConfig.class);
//
//    CustomerRepository test=  applicationContext.getBean(CustomerRepository.class);
//    // 1. Test for customer creation
//    // CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest("1@gmail.com","ethan","hunt","12345");
//    // test.createCustomer(createCustomerRequest);
////     2. test for customer update
//     Customer testCustomer = new Customer(5,"xxxxx","oldpass","admin","updatefirst","updateLast","update phone",
//         null,null,null);
//     test.updateCustomer(testCustomer);
//    // 3. test for getting customer profile
//    // String log = test.getCustomerProfile(3).getCustomer().toString();
//    // System.out.println(log);
//
////        test.updatePassword();
//
//  }
//

}
