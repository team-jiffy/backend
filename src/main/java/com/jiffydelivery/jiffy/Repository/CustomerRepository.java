package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.PasswordUpdateResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
  @Autowired
  private SessionFactory sessionFactory;
//
//  public Customer loginVerify (String email, String password){
//    LoginResponse loginResponse = new LoginResponse();
//    Customer
//        user = null;
//    try (Session session = sessionFactory.openSession()) {
//
//      user = session.get(Customer
//          .class,email);
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
// return user;
//    }


//
//  public LogoutResponse logoutVerify (String UID){
//    LogoutResponse logoutResponse = new LogoutResponse();
//    Customer
//        user = null;
//    try (Session session = sessionFactory.openSession()) {
//      //// TODO: 4/17/21
//      user = session.get(Customer
//          .class,UID);
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//    //// TODO: 4/17/21 怎么知道logout了 是token? 还是什么
//    if(user!= null){
//      logoutResponse.setMessage("logout success.");
//
//      logoutResponse.setStatus("200");
//
//
//    }
//    else {
//      logoutResponse.setMessage("logout fail.");
//
//      logoutResponse.setStatus("401");
//
//    }
//    return logoutResponse;
//
//  }




//create customer

  public Customer createCustomer (CustomerCreationRequest customerCreationRequest){
    Session session = null;
    //CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
    Customer user = new Customer();
    user.setEmail(customerCreationRequest.getEmail());
    user.setFirstName(customerCreationRequest.getFirstName());
    user.setLastName(customerCreationRequest.getLastName());
    user.setPassword(customerCreationRequest.getPassword());
    try {
      session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();
    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      if (session != null) {
        session.close();
      }
    }
    return user;
  }



//update password
  public PasswordUpdateResponse updatePassword (String UID, String password){
    Session session = null;
    PasswordUpdateResponse passwordUpdateResponse = new PasswordUpdateResponse();
    Customer
        user= null;

    try {
      session = sessionFactory.openSession();
      user = session.get(Customer
          .class,UID);
      if(user == null ){
        passwordUpdateResponse.setMessage("user not found");
        passwordUpdateResponse.setStatus("404");

      }
      user.setPassword(password);
      session.beginTransaction();
      session.update(user);
      session.getTransaction().commit();
    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();
      passwordUpdateResponse.setMessage("fail");
    } finally {
      if (session != null) {
        session.close();
      }
    }
    passwordUpdateResponse.setMessage("update success");
    passwordUpdateResponse.setStatus("200");

    return passwordUpdateResponse;
  }
//get customer information
  public Customer getCustomerProfile (int UID){
    GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
    Customer user = null;
    try (Session session = sessionFactory.openSession()) {
      user = session.get(Customer
          .class,(long)UID);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return user;
  }

  //update customer profile
  public Customer updateCustomer (User
      updatedUser
  ){
    Session session = null;
   Customer dbuser = null;
  long dbuserID = 0;
    try {
      session = sessionFactory.openSession();

      try{
        dbuserID = Integer.parseInt(updatedUser.getUID());
      } catch (NumberFormatException e) {
        e.printStackTrace();

      }

         dbuser = session.get(Customer
            .class,dbuserID);
         if(dbuser!= null) {
           dbuser.setEmail(updatedUser.getEmail());
           dbuser.setFirstName(updatedUser.getFirstName());
           dbuser.setLastName(updatedUser.getLastName());
           dbuser.setPhone(updatedUser.getPhone());
         }
        session.update(updatedUser);


        session.beginTransaction();

//        session.update(updatedCustomer
//        );
        session.getTransaction().commit();

    } catch (Exception ex) {
      ex.printStackTrace();
      session.getTransaction().rollback();

    } finally {
      if (session != null) {
        session.close();
      }
    }
//    customerUpdateResponse.setMessage("update success");
//    customerUpdateResponse.setStatus("200");
//    customerUpdateResponse.setCustomer(user);
    return dbuser;
  }


  public Customer checkUserPassword(String email, String password){
    Session session = null;
    Customer customer =null;
    try{
      session = sessionFactory.openSession();
      session.beginTransaction();
      String hql = "From Customer c where c.email=:e and c.password=:w";
      Query query = session.createQuery(hql,Customer.class);
      query.setParameter("e",email);
      query.setParameter("w",password);
      List<Customer> list = query.list();
      System.out.println(list.size());
      if (list.size()!=0){
        customer = list.get(0);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return customer;
  }

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
//     //test.updateCustomer(testCustomer);
//    // 3. test for getting customer profile
//    // String log = test.getCustomerProfile(3).getCustomer().toString();
//    // System.out.println(log);
//
////        test.updatePassword();
//
//  }


}
