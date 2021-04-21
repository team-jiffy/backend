package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ContactType;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    private String ContactID;
    private String LastName;
    private String FirstName;
    private String Phone;
    private String Email;
    private com.jiffydelivery.jiffy.Entity.Constance.ContactType ContactType;

    private Address Address;



    private String ContactLabel;
    private boolean Default;

    public com.jiffydelivery.jiffy.Entity.DBDAO.Contact toDAO(){
        com.jiffydelivery.jiffy.Entity.DBDAO.Contact contact =
                new com.jiffydelivery.jiffy.Entity.DBDAO.Contact();

        contact.setId(Long.valueOf(ContactID));
        contact.setLastName(LastName);
        contact.setFirstName(FirstName);
        contact.setPhone(Phone);
        contact.setEmail(Email);
        contact.setContactType(ContactType);
        contact.setAddress(Address.toDAO());
        contact.setDef(Default);

        return contact;
    }

    public Contact (com.jiffydelivery.jiffy.Entity.DBDAO.Contact backendContact)
    {

        this.ContactID= String.valueOf(backendContact.getId());
        this.LastName = backendContact.getLastName();
        this.FirstName = backendContact.getFirstName();
        this.Email=backendContact.getEmail();
        this.Address = new Address(backendContact.getAddress());
        this.Phone = backendContact.getPhone();
        this.Default = backendContact.isDef();

    }
}
