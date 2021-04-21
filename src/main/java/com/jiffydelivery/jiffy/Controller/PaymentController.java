package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.DeletePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.NewPaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.SetDefaultRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.UpdatePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.*;


import com.jiffydelivery.jiffy.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.rmi.server.UID;

@RestController
public class PaymentController {


    @Autowired
    PaymentService peymentService;
    

    @PostMapping("/billing/createPayment")
    public NewPaymentResponse addPayment(@RequestBody NewPaymentRequest newPaymentRequest,
                                         HttpServletRequest req, HttpServletResponse res) {

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            NewPaymentResponse response = new NewPaymentResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        NewPaymentResponse newPaymentResponse = peymentService.addPayment(newPaymentRequest);

        return newPaymentResponse;
    }

    @PutMapping("/billing/createPayment")
    public UpdatePaymentResponse updatePayment(@RequestBody UpdatePaymentRequest updatePaymentRequest,
                                               HttpServletRequest req, HttpServletResponse res) {

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            UpdatePaymentResponse response = new UpdatePaymentResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
//        UpdatePaymentResponse updatePaymentResponse = peymentService.updatePayment(updatePaymentRequest);

        return new UpdatePaymentResponse("200", "ok", new Card("1234","credit",
                "visa","yubo","asdf",new Address(),  new Address(),"card-1",true));
    }

    @GetMapping("/billing/getPayments")
    public AllPaymentsResponse getAllPayments(@RequestParam(value="UID") String UID,
                                              HttpServletRequest req, HttpServletResponse res) {
        //System.out.println("testRequestParam" + UID);

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            AllPaymentsResponse response = new AllPaymentsResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        AllPaymentsResponse allPaymentsResponse = peymentService.getAllPayments(UID);

        return allPaymentsResponse;
    }

    @PutMapping("/billing/deletePayment")
    public DeletePaymentResponse deletePayment(@RequestBody DeletePaymentRequest deletePaymentRequest,
                                                HttpServletRequest req, HttpServletResponse res) {

//        HttpSession session = req.getSession(false);
//        if (session==null){
//            DeletePaymentResponse response = new DeletePaymentResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        peymentService.deletePayment(deletePaymentRequest);

        return new DeletePaymentResponse("200", "ok");
    }

    @PutMapping("/billing/setDefault")
    public SetDefaultResponse setDefault(@RequestBody SetDefaultRequest setDefaultRequest,
                                         HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            SetDefaultResponse response = new SetDefaultResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }

        return new SetDefaultResponse("200", "ok", new Card("1234","credit",
                "visa","yubo","asdf",new Address(),  new Address(),"card-1",true));
    }
}
