package com.jiffydelivery.jiffy.Entity.FrontModelEntities;


import com.jiffydelivery.jiffy.Entity.DBDAO.Contact;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlaceOrderContact {
    private String Name;
    private String Email;
    private String Phone;
    private Address address;

    public Contact extract(){
        Contact contact = new Contact();
        contact.setFirstName(Name.split("\\s+")[0]);
        contact.setLastName(Name.split("\\s+")[1]);
        contact.setEmail(this.Email);
        contact.setPhone(this.Phone);
        contact.setAddress(address.toDAO());
        return contact;
    }
}
