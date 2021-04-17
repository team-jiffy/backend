package com.jiffydelivery.jiffy.Entity.Request.CustomerRequest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateCustomerRequest {
  public String lastName;
  public String firstName;
  public String email;
  public String password;

}
