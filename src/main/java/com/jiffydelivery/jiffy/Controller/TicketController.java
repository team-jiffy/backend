package com.jiffydelivery.jiffy.Controller;


import com.jiffydelivery.jiffy.Entity.Request.Ticket.TicketRequestBody;
import com.jiffydelivery.jiffy.Entity.Response.Ticket.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {
    @PostMapping("/assist/createticket")
    public TicketResponse CreateTicket (@RequestBody TicketRequestBody ticketRequestBody) {
        System.out.println(ticketRequestBody.toString());
        return new TicketResponse("true","yuqixiao");
    }

}
