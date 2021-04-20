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

}
