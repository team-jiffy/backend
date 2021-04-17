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
    private TripType type;
    private Coordinates coordinates;
    private String code;
}
