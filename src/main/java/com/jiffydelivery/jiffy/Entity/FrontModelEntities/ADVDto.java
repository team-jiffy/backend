package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ADVDto {
    private int ADVID;          // enum index
    private ADVType ADVType;
    private Coordinates position;
    private int capacity;
    private double batteryStatus;
    private Error error;
    private Coordinates pendingAddress;
    private Trip trip;
}
