package com.jiffydelivery.jiffy.Repository.APIRepository;
import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;

import java.util.*;
import java.lang.*;
import java.io.*;


public class StraightDistance {

//    get Straight distance of two addresses for Drone;

    public double distance(PositionCoordinates coord1, PositionCoordinates coord2) {
        double lat1 = coord1.getLatitude(), lat2 = coord2.getLatitude(),
                lon1 = coord1.getLongitude(), lon2=coord2.getLongitude(),
                ele1 = coord1.getElevation(), ele2 = coord2.getElevation();
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;

            dist = Math.sqrt(dist*dist + Math.pow((ele2-ele2)/1.6/1000,2));

            return (dist);
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        StraightDistance straightDistance = new StraightDistance();
        PositionCoordinates coor1 = new PositionCoordinates();
        PositionCoordinates coor2 = new PositionCoordinates();
        coor1.setLatitude(37.777932499472485);
        coor1.setLongitude(-122.44752128696365);
        coor1.setElevation(4411.94189453125);
        coor2.setLatitude(37.743231072877926);
        coor2.setLongitude(-122.47482151074911);
        coor2.setElevation(1608.637939453125);
        System.out.println(straightDistance.distance(coor1, coor2));

    }
}
