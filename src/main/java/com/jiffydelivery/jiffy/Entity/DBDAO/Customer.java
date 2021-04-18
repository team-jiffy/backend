package com.jiffydelivery.jiffy.Entity.DBDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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


    public Customer() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }


    public Customer(int id, String email, String password, String authorities,
        String firstName, String lastName, String phone,
        List<CreditCard> creditCard,
        List<Contact> contact, List<Order> order) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.creditCard = creditCard;
        this.contact = contact;
        this.order = order;
    }
}
