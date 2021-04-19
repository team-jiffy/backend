package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Position {
    private Coordinates Delivery;
    private Coordinates Pickup;
    private Coordinates Curr;
}
