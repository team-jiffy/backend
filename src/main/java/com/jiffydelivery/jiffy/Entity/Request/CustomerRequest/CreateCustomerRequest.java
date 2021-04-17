package com.jiffydelivery.jiffy.Entity.Request.CustomerRequest;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CreateCustomerRequest {
//  public String lastName;
//  public String firstName;
//  public String email;
//  public String password;
  private String email;
  private String lastName;
  private Contact defaultSender;
  private String UID;
  private String firstName;
  private String phone;
  private String profilePictureURL;
  private Contact defaultRecipient;
  private String password;
  private Address location;
}
