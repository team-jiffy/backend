package com.jiffydelivery.jiffy.Entity.DBDAO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 7596499365251992523L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

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
