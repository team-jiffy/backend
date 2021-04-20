package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiffydelivery.jiffy.Entity.Constance.ContactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "Contact")
public class Contact implements Serializable {
    private static final long serialVersionUID = 7552252199964993653L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean getDefaultContact;
    private boolean def;
    private String getContactLabel;

    @OneToOne
    @JoinColumn(unique = true)
    private Address address;

    @ManyToOne
    private Customer customer;


    @OneToOne(mappedBy = "senderContact")
    private Order orderSend;

    @OneToOne(mappedBy = "recipiantContact")
    private Order orderReci;


}
