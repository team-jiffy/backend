package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LoginResponse;
import com.jiffydelivery.jiffy.Repository.TestCustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCustomerServiceImpl implements TestCustomerRepository {
  private TestCustomerRepository testCustomerRepository;


  @Autowired
  public TestCustomerServiceImpl(TestCustomerRepository testCustomerRepository){
    this.testCustomerRepository = testCustomerRepository;

  }
//  @Override
//  public LoginResponse loginVerify(String email, String password) {
//    LoginResponse loginResponse = new LoginResponse();
//
//
//  }

//  @Override
////  public LoginResponse login(String email, String password) {
////
////
////    Optional<User> user = Optional.of(new User());
////    if(user.isPresent()){
////
////
////    }
////
////    //return Optional.empty();
////  }

  @Override
  public <S extends User> S save(S s) {
    return null;
  }

  @Override
  public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
    return null;
  }

  @Override
  public Optional<User> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<User> findAll() {
    return null;
  }

  @Override
  public Iterable<User> findAllById(Iterable<Long> iterable) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(User user) {

  }

  @Override
  public void deleteAll(Iterable<? extends User> iterable) {

  }

  @Override
  public void deleteAll() {

  }


  @Override
  public LoginResponse loginVerify(String email, String password) {
    return null;
  }
}
