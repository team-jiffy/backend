package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.DeletePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.NewPaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.SetDefaultRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.UpdatePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.*;
import com.jiffydelivery.jiffy.Service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;

@RestController
public class PaymentController {

//    @Autowired
//    private PaymentService peymentService;

    @PostMapping("/billing/createPayment")
    public NewPaymentResponse addPayment(@RequestBody NewPaymentRequest newPaymentRequest) {
        return new NewPaymentResponse("200", "ok", new Card("1234","credit",
                "visa","yubo",new Address(), new Address(),"card-1",true));
    }

    @PutMapping("/billing/createPayment")
    public UpdatePaymentResponse updatePayment(@RequestBody UpdatePaymentRequest updatePaymentRequest) {
        return new UpdatePaymentResponse("200", "ok", new Card("1234","credit",
                "visa","yubo",new Address(), new Address(),"card-1",true));
    }

    @GetMapping("/billing/getPayments")
    public AllPaymentsResponse getAllPayments(@RequestParam(value="UID") String UID) {
        //System.out.println("testRequestParam" + UID);

        //List<Payment> payments = paymentService.getAllPayments();

        return new AllPaymentsResponse("200", "OK", new Card[]{new Card("1234", "credit",
                "visa", "yubo", new Address(), new Address(), "card-1", true)});
    }

    @PutMapping("/billing/deletePayment")
    public DeletePaymentResponse deletePayment(@RequestBody DeletePaymentRequest deletePaymentRequest) {

        //paymentsService.deletePayment(UID);
        //return "redirect:/getAllPayments";
        return new DeletePaymentResponse("200", "ok");
    }

    @PutMapping("/billing/setDefault")
    public SetDefaultResponse setDefault(@RequestBody SetDefaultRequest setDefaultRequest) {
        return new SetDefaultResponse("200", "ok", new Card("1234","credit",
                "visa","yubo",new Address(), new Address(),"card-1",true));
    }
}
