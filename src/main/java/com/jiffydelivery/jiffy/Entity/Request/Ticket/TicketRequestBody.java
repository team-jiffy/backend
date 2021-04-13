package com.jiffydelivery.jiffy.Entity.Request.Ticket;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TicketRequestBody {
    public String Name;
    public String Email;
    public String Phone;
    public String Content;
}
