package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1136816939279566769L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String street1;
    private String street2;
    private final String city = "San Francisco";
    private final String state = "California";
    private String zip;
    private String aptNo;

    private int latitude;
    private int longitude;
}
