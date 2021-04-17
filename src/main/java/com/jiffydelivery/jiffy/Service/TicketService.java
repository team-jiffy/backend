package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DAO.TicketDao;
import com.jiffydelivery.jiffy.Entity.Request.TicketRequest.TicketRequestBody;
import com.jiffydelivery.jiffy.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public void createTicket(TicketDao ticket) {
        ticketRepository.createTicket(ticket);
    }

}
