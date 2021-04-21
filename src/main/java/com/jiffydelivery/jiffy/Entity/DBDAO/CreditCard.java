package com.jiffydelivery.jiffy.Entity.DBDAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Card;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Creditcard")
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 7964993652255519923L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String holderName;

    private String cardNumber;

    private String CardLabel;

    private String CVV;

    private String zip;

    private String expDate;

    private boolean def = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique=true)
    Address billingAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Customer customer;

    @OneToOne(mappedBy = "creditCard")
    @JsonIgnore
    private Order order;

    public Card extract(){
        Card card = new Card();
        card.setLastFourDigits("*"+cardNumber.substring(cardNumber.length()-4));
        card.setCardType("Vias");
        card.setCardLabel(CardLabel);
        card.setHolderName(holderName);
        card.setCardAddress(billingAddress.extract());
        card.setBillingAddress(billingAddress.extract());
        card.setCardId(String.valueOf(id));
        card.setDefault(def);
        card.setExpDate(expDate);
        return card;
    }

}

