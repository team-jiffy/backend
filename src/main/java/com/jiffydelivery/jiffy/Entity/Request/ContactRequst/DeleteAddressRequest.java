package com.jiffydelivery.jiffy.Entity.Request.ContactRequst;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DeleteAddressRequest {
    private String UID;
    private String ContactID;
}
