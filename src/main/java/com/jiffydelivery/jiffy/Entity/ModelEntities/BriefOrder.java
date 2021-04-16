package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class BriefOrder {
    private String trackNumber;

    private String senderName;
    private String recipientName;
    private String orderDate;
    private String ADVType;
    private String ETA;
    private String orderStatus;

}
