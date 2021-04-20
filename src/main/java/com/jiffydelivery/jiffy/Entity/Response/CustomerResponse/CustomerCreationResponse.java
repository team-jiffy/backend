package com.jiffydelivery.jiffy.Entity.Response.CustomerResponse;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class CustomerCreationResponse {
  private String status;
  private String message;
  private User user;


}
