package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "card")
public class Card implements Serializable {

    private static final long serialVersionUID = 91817308952404955L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cardId;

    private String last4Digits;
    private String cardType;
    private String cardLabel;
    private String holderName;

    @OneToOne(mappedBy = "address")
    private Address cardAddress;

    @OneToOne(mappedBy = "address")
    private Address billingAddress;

    private boolean isDefaultCard;
}
