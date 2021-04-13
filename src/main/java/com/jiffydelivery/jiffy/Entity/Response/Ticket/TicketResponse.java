package com.jiffydelivery.jiffy.Entity.Response.Ticket;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TicketResponse {
    public String Status;
    public String Message;
}
