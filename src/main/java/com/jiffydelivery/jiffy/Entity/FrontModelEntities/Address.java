package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Address {

    private String Street1;
    private String Street2;
    private String City;
    private String State;
    private String Zip;
    private String AptNo;

    public Address(String street1, String street2, String zip, String aptNo) {
    }
}
