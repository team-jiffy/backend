package com.jiffydelivery.jiffy.Entity.Request.CustomerRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerCreationRequest {

  public String LastName;
  public String FirstName;
  public String Email;
  public String Password;



}
