package com.jiffydelivery.jiffy.Entity.Request.CustomerRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerSigninRequest {
//    @JsonProperty("Email")
    private String Email;
//    @JsonProperty("Password")
    private String Password;
}
