package com.jiffydelivery.jiffy.Repository;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCustomerRepository extends CrudRepository<User, Long> {
  //Optional<User> findByEmailAndPassword(String email, String password);
  public LoginResponse loginVerify (String email, String password);



}
