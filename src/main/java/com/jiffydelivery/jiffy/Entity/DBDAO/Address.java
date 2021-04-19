package com.jiffydelivery.jiffy.Entity.DBDAO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="Address")
public class Address implements Serializable {
    private static final long serialVersionUID = 7559964993652219523L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
