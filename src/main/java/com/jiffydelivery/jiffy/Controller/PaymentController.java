package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.NewPaymentRequest;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.AllPaymentsResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.DeletePaymentResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.NewPaymentResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.SetDefaultResponse;

import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

//    @Autowired
//    private PaymentService paymentService;

    @PutMapping
    public NewPaymentResponse createPayment(@RequestBody NewPaymentRequest newPaymentRequest) {
        return new NewPaymentResponse("status", "message", new Card());
    }

    @GetMapping("/billing/getPayments")
    public AllPaymentsResponse getAllPayments(@RequestParam(value="UID") String UID) {
        System.out.println("testRequestParam" + UID);

        //List<Payment> payments = paymentService.getAllPayments();

        return new AllPaymentsResponse("200", "OK", new Card[]{new Card("1234",
                "card-type",
                "card-label",
                "GUnit",
                new Address(),
                new Address(),
                "card",
                true)});
    }

    @PutMapping("/billing/deletePayment")
    public DeletePaymentResponse deletePayment(@RequestParam(value= "UID") String UID,
                                               @RequestParam(value= "CardID") String CardID) {

        //paymentsService.deletePayment(UID);
        //return "redirect:/getAllPayments";
        return new DeletePaymentResponse("status", "message");
    }

    @PutMapping("/billing/setDefault")
    public SetDefaultResponse setDefault(@RequestParam(value="CardID") String CardID,
                                         @RequestParam(value="UID") String UID) {
        return new SetDefaultResponse("status", "message", new Card());
    }
}
