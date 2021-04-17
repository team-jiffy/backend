package com.jiffydelivery.jiffy.Entity.DBDAO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Address")
public class Address implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String aptNo;

    @OneToOne(mappedBy = "billingAddress")
    @JoinColumn(unique = true)
    private CreditCard creditCard;

    @OneToOne(mappedBy = "address")
    @JoinColumn(unique = true)
    private Contact contact;

    @OneToOne(mappedBy = "address")
    @JoinColumn(unique = true)
    private WareHouse wareHouse;

    @OneToOne(mappedBy = "address")
    @JoinColumn(unique = true)
    private Trip trip;
}
