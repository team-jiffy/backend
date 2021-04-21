package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private String Email;
    private String LastName;
    private Contact DefaultSender;
    private String UID;
    private String FirstName;
    private String Phone;
    private String ProfilePictureURL;
    private Contact DefaultDeliver;
    private Address Location;

    public Customer ToCustomer(){
        Customer customer= new Customer();
        customer.setEmail(this.Email);
        customer.setLastName(this.LastName);
        customer.setFirstName(this.FirstName);
        customer.setPhone(this.Phone);
        return customer;
    }
}