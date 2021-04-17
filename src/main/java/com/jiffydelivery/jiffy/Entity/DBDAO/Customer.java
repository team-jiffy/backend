package com.jiffydelivery.jiffy.Entity.DBDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String email;
    private String password;
    private String authorities;
    private String firstName;
    private String lastName;
    private String phone;


    @OneToMany(mappedBy = "customer")
    private List<CreditCard> creditCard;

    @OneToMany(mappedBy = "customer")
    private List<Contact> contact;

    @OneToMany(mappedBy = "customer")
    private List<Order> order;
}
