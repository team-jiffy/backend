package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class BriefOrder {
    private String trackNumber;

    private String senderName;
    private String recipientName;
    private String orderDate;
    private String ADVType;
    private String ETA;
    private String orderStatus;
}