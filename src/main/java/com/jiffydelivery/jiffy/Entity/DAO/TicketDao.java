package com.jiffydelivery.jiffy.Entity.DAO;


import javax.persistence.*;


@Entity
@Table(name = "Ticket")
public class TicketDao{

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "content")
    private String content;
    
}
