package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BriefOrder {
    private String trackNumber;

    private String senderName;
    private String recipientName;
    private String orderDate;
    private String ADVType;
    private String ETA;
    private String orderStatus;

}
