package com.jiffydelivery.jiffy.Entity.Response.CustomerResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LogoutResponse {
  private String status;
  private String message;



  public LogoutResponse() {

  }


}
