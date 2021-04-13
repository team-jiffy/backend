package com.jiffydelivery.jiffy.Entity.ModelEntities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Reco {
    private String ADVType;
    private String price;
    private String ETA;
}
