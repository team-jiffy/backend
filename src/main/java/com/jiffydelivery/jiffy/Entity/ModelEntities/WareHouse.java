package com.jiffydelivery.jiffy.Entity.ModelEntities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "warehouse")
public class WareHouse implements Serializable {
    private final static long serialVersionUID = 462927345537961L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String warehouseId;

    private int latitude;
    private int longitude;

    private int chargingCapacity;

    private int numOfRobots;

    @OneToOne(mappedBy = "address")
    private Address address;
}
