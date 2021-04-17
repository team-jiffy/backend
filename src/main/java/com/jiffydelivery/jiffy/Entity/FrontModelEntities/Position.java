package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Position {
    private Coordinates delivery;
    private Coordinates pickup;
    private Coordinates curr;
}
