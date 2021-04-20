package com.jiffydelivery.jiffy.Entity.FrontModelEntities;


import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Trip {
    private TripType TripType;
    private Coordinates Coordinates;
    private String TripID;
}
