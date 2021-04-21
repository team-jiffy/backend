package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import lombok.*;

import java.net.MalformedURLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ADVDto {
    private int ADVID;          // enum index
    private ADVType ADVType;
    private Coordinates position;
    private double capacity;
    private double batteryStatus;
    private Error error;
    private Coordinates pendingAddress;
    private Trip trip;

    public ADVDto(ADV ADVDao) throws MalformedURLException {
        this.ADVID = (int) ADVDao.getId();
        this.ADVType = ADVDao.getADVSpec().getADVType();
        this.position = new Coordinates(String.valueOf(ADVDao.getCurrentLatitude()),
                String.valueOf(ADVDao.getCurrentLongitude()),
                String.valueOf(ADVDao.getCurrentElevation()));
        this.capacity = ADVDao.getCurrentPackageAmount();
        this.batteryStatus = ADVDao.getCurrentBatteryPercentage();
        this.trip = new Trip(ADVDao.getTrip());
    }
}
