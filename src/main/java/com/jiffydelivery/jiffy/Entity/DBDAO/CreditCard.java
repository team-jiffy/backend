package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Creditcard")
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String holderName;

    private String cardNumber;

    private String CVV;

    private String zip;

    private String expDate;

    private boolean def;

    @OneToOne
    @JoinColumn(unique=true)
    Address billingAddress;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "creditCard")
    private List<Order> order;


}
