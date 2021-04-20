package com.jiffydelivery.jiffy.Entity.Response.CustomerResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class CustomerSigninResponse {
    private String Status;
    private String Message;
    private User user;
}
