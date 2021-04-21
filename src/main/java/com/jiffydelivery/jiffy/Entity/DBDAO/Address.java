package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long id;

    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String aptNo;

    @OneToOne(mappedBy = "billingAddress")
    @JsonIgnore
    private CreditCard creditCard;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Contact contact;


    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private WareHouse wareHouse;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Trip trip;
}
