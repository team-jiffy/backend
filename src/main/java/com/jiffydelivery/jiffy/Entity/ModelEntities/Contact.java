package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1892966489425832L;

    @Id
    private String contactLabel;

    private boolean isDefaultContact;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private ContactType contactType;

    @OneToOne(mappedBy = "address")
    private Address address;

    @OneToOne(mappedBy = "card")
    private Card card;


}
