package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Creditcard")
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 7964993652255519923L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String holderName;

    private String cardNumber;

    private String CVV;

    private String zip;

    private String expDate;

    private boolean def = false;

    @OneToOne
    @JoinColumn(unique=true)
    Address billingAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "creditCard")
    @JsonIgnore
    private List<Order> order;

}

