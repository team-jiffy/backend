package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CreateCustomerRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CreateCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LogoutResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.UpdateCustomerResponse;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestCustomerRepository {
  @Autowired
  private SessionFactory sessionFactory;

  public LoginResponse loginVerify (String email, String password){
    LoginResponse loginResponse = new LoginResponse();
    User user = null;
    try (Session session = sessionFactory.openSession()) {
      //// TODO: 4/17/21
      user = session.get(User.class,email);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if(user!= null && user.getPassword() ==password){
      loginResponse.setMessage("user verify success.");
      loginResponse.setUser(user);
      loginResponse.setStatus("200");
      return loginResponse;

    }
    else return null;
  }


  public LogoutResponse logoutVerify (String UID){
    LogoutResponse logoutResponse = null;
    User user = null;
    try (Session session = sessionFactory.openSession()) {
      //// TODO: 4/17/21
      user = session.get(User.class,UID);
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

  public CreateCustomerResponse createCustomer (CreateCustomerRequest createCustomerRequest){
    Session session = null;
    CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();
    User user = new User();
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
    createCustomerResponse.setUser(user);
    return createCustomerResponse;
  }

  public UpdateCustomerResponse createCustomer (User updatedUser){
    Session session = null;
    UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();
    User user= null;

    try {
      session = sessionFactory.openSession();
      user = session.get(User.class,updatedUser.getUID());
      if(user == null ){
        updateCustomerResponse.setMessage("user not found");
        updateCustomerResponse.setStatus("404");

      }
      session.beginTransaction();
      session.save(updatedUser);
      session.getTransaction().commit();
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
    updateCustomerResponse.setUser(user);
    return updateCustomerResponse;
  }

  public GetCustomerResponse getCustomerProfile (String UID){
    GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
    User user = null;
    try (Session session = sessionFactory.openSession()) {
      user = session.get(User.class,UID);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if(user!= null){
      getCustomerResponse.setMessage("get user success.");
      getCustomerResponse.setUser(user);
      getCustomerResponse.setStatus("200");


    }
    else{
      getCustomerResponse.setMessage("get user fail.");
      getCustomerResponse.setStatus("404");

    }
    return getCustomerResponse;
  }

}
