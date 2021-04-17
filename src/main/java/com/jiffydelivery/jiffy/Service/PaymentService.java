package com.jiffydelivery.jiffy.Service;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

}
