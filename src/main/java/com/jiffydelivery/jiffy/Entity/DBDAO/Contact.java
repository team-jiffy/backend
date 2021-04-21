package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiffydelivery.jiffy.Entity.Constance.ContactType;
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
    private boolean def;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Address address;

    @ManyToOne
    private Customer customer;


    @OneToOne(mappedBy = "senderContact")
    @JsonIgnore
    private Order orderSend;

    @OneToOne(mappedBy = "recipientContact")
    @JsonIgnore
    private Order orderRecipient;

    public com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact extract(){
        com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact contact =
                new com.jiffydelivery.jiffy.Entity.FrontModelEntities.Contact();
        contact.setContactID(String.valueOf(id));
        contact.setLastName(lastName);
        contact.setFirstName(firstName);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setContactType(contactType);
        contact.setAddress(address.extract());
        contact.setDefault(def);
        return contact;
    }
}
