package com.jiffydelivery.jiffy.Repository.APIRepository;
import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;

import java.util.*;
import java.lang.*;
import java.io.*;


public class StraightDistance {

//    get Straight distance of two addresses for Drone;

    private static double distance(PositionCoordinates coord1, PositionCoordinates coord2) {
        String unit="M";
        if ((coord1.getLatitude()==coord2.getLatitude())
                && coord1.getLongitude()==coord1.getLongitude()) {
            return 0;
        }
        else {
            double theta = coord1.getLongitude() - coord2.getLongitude();
            double dist = Math.sin(Math.toRadians(coord1.getLatitude()))
                    * Math.sin(Math.toRadians(coord2.getLatitude()))
                    + Math.cos(Math.toRadians(coord1.getLatitude()))
                    * Math.cos(Math.toRadians(coord2.getLatitude()))
                    * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
//            if (unit.equals("K")) {
//                dist = dist * 1.609344;
//            } else if (unit.equals("N")) {
//                dist = dist * 0.8684;
//            }
            double ele = Math.abs(coord1.getElevation() - coord2.getElevation());
            return (Math.sqrt(ele * ele + dist * dist));
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        PositionCoordinates coor1 = new PositionCoordinates();
        PositionCoordinates coor2 = new PositionCoordinates();
        coor1.setLatitude(36.5785810);
        coor1.setLongitude(-118.2919940);
        coor1.setElevation(4411.94189453125);
        coor2.setLatitude(39.73915360);
        coor2.setLongitude(-104.98470340);
        coor2.setElevation(1608.637939453125);
        System.out.println(distance(coor1, coor2));

    }
}
