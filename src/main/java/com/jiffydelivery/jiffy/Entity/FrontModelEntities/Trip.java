package com.jiffydelivery.jiffy.Entity.FrontModelEntities;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Trip {
    private String type;
    private Coordinates coordinates;
    private String code;
}
