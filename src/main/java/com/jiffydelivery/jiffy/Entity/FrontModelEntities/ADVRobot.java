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
    private TripType tripType;
    private Coordinates position;
    private int capacity;
    private double batterStatus;
    private Error error;
    private Coordinates pendingAddress;
    private Trip trip;
}
