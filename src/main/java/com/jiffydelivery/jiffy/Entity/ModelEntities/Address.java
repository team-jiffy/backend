package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street1;
    private String street2;
    private final String city = "San Francisco";
    private final String state = "California";
    private String zip;
    private String aptNo;
}
