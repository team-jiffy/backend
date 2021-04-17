package com.jiffydelivery.jiffy.Controller;


import com.jiffydelivery.jiffy.Entity.DAO.TicketDao;
import com.jiffydelivery.jiffy.Entity.Request.TicketRequest.TicketRequestBody;
import com.jiffydelivery.jiffy.Entity.Response.TicketResponse.TicketResponse;
import com.jiffydelivery.jiffy.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired TicketService ticketService;

    @PostMapping("/assist/createTicket")
    public String createTicket (@RequestBody TicketDao ticket) {
        ticketService.createTicket(ticket);
        return "Request Processed";
    }

}
