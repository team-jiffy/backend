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
    private  String City = "San Francisco";
    private  String State = "California";
    private String Zip;
    private String AptNo;

    public com.jiffydelivery.jiffy.Entity.DBDAO.Address toDAO(){
        com.jiffydelivery.jiffy.Entity.DBDAO.Address address =
                new com.jiffydelivery.jiffy.Entity.DBDAO.Address();
        address.setStreet1(Street1);
        address.setStreet2(Street2);
        address.setState(State);
        address.setCity(City);
        address.setZip(Zip);
        address.setAptNo(AptNo);
        return address;
    }
}
