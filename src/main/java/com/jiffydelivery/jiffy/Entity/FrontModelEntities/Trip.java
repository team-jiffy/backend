package com.jiffydelivery.jiffy.Entity.FrontModelEntities;


import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import lombok.*;

import java.net.MalformedURLException;
import java.util.Date;

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

    // toooo complicated to implements TripDao <=> TripDto

    public Trip(com.jiffydelivery.jiffy.Entity.DBDAO.Trip tripDao) throws MalformedURLException {
        this.TripType = tripDao.getTripType();
        this.Coordinates = new Coordinates(tripDao.getAddress().extract());
        this.TripID = String.valueOf(tripDao.getId());
    }
}
