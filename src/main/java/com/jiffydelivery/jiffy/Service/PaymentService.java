package com.jiffydelivery.jiffy.Service;


import com.jiffydelivery.jiffy.Entity.DBDAO.CreditCard;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.DeletePaymentRequest;
import com.jiffydelivery.jiffy.Entity.Request.PaymentRequest.NewPaymentRequest;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.AllPaymentsResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.DeletePaymentResponse;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.NewPaymentResponse;
import com.jiffydelivery.jiffy.Repository.PaymentRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public NewPaymentResponse addPayment(NewPaymentRequest newPaymentRequest) {
        CreditCard Dbcard = paymentRepository.addPayment(newPaymentRequest);

        Card EntityCard = new Card();

        NewPaymentResponse newPaymentResponse = new NewPaymentResponse();
        if (Dbcard == null) {
            newPaymentResponse.setStatus("250");
            newPaymentResponse.setMessage("failed");
        } else {
            EntityCard.setHolderName(Dbcard.getHolderName());
            EntityCard.setCardId(Integer.toString((int) Dbcard.getId()));
            EntityCard.setDefault(true);
            newPaymentResponse.setStatus("200");
            newPaymentResponse.setMessage("add sucess");
            newPaymentResponse.setCard(EntityCard);
        }
        return newPaymentResponse;
    }

    public void deletePayment(DeletePaymentRequest deletePaymentRequest) {
        String UID = deletePaymentRequest.getUID();
        String cardId = deletePaymentRequest.getCardID();
        paymentRepository.deletePayment(UID, cardId);
    }

    public AllPaymentsResponse getAllPayments(String UID) {
        List<CreditCard> result = paymentRepository.getAllPayments(UID);
        List<Card> cards = new ArrayList<>();
        for (CreditCard card: result){
            cards.add(card.extract());
        }
        AllPaymentsResponse allPaymentsResponse = new AllPaymentsResponse("200", "success", cards);
        return allPaymentsResponse;
    }


}


