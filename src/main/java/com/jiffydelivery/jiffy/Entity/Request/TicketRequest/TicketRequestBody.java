package com.jiffydelivery.jiffy.Entity.Request.TicketRequest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TicketRequestBody {
    public String name;
    public String email;
    public String phone;
    public String content;
}
