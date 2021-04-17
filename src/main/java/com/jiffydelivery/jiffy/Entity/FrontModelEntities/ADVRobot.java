package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ADVRobot {
    private int ADVID;
    private Coordinates position;
    private int capacity;
    private double batteryStatus;
    private Error error;
    private Coordinates pendingAddress;
    private Trip trip;
}
