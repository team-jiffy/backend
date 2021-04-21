package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import com.jiffydelivery.jiffy.Repository.APIRepository.GetLatLong;
import lombok.*;

import java.net.MalformedURLException;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Coordinates {
    private String Longitude;
    private String Latitude;
    private String Elevation;

    public Coordinates(String valueOf, String valueOf1) {
    }

    public Coordinates(Address address) throws MalformedURLException {
        GetLatLong getLatLong = new GetLatLong();
        double[] res = getLatLong.getCoordinates(address);
        this.Latitude = String.valueOf(res[0]);
        this.Longitude = String.valueOf(res[1]);
    }
}
