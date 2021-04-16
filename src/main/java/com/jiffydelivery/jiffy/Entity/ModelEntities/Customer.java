package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1472658321636234L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String UID;

    private String lastName;
    private String firstName;
    private String phone;
    private String email;

    @OneToOne(mappedBy = "contact")
    private Contact defaultSender;

    @OneToOne(mappedBy = "contact")
    private Contact defaultRecipient;

    private String profilePictureURL;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> locations;
}
