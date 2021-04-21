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


    public Address(com.jiffydelivery.jiffy.Entity.DBDAO.Address backendAddress){
        this.Street1 = backendAddress.getStreet1();
        this.Street1 = backendAddress.getStreet2();
        this.City = "San Francisco";
        this.State ="California";
        this.Zip = backendAddress.getZip();
        this.AptNo = backendAddress.getAptNo();

    }

}
