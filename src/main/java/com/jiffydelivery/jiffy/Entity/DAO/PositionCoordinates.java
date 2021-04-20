package com.jiffydelivery.jiffy.Entity.DAO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PositionCoordinates {
    private double latitude;
    private double longitude;
    private double elevation;
}
