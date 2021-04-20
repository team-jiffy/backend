package com.jiffydelivery.jiffy.Repository.APIRepository;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;

import java.util.*;
import java.lang.*;
import java.io.*;


public class StraightDistance {

    private static double distance(Coordinates coord1, Coordinates coord2) {
        String unit="M";
        if ((coord1.getLatitude().equals(coord2.getLatitude()))
                && (coord1.getLongitude().equals(coord1.getLongitude()))) {
            return 0;
        }
        else {
            double theta = Double.valueOf(coord1.getLongitude()) - Double.valueOf(coord2.getLongitude());
            double dist = Math.sin(Math.toRadians(Double.valueOf(coord1.getLatitude())))
                    * Math.sin(Math.toRadians(Double.valueOf(coord2.getLatitude())))
                    + Math.cos(Math.toRadians(Double.valueOf(coord1.getLatitude())))
                    * Math.cos(Math.toRadians(Double.valueOf(coord2.getLatitude())))
                    * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
//            if (unit.equals("K")) {
//                dist = dist * 1.609344;
//            } else if (unit.equals("N")) {
//                dist = dist * 0.8684;
//            }
            double ele = Math.abs(Double.valueOf(coord1.getElevation())
                        - Double.valueOf(coord2.getElevation()));
            return (Math.sqrt(ele * ele + dist * dist));
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Coordinates coor1 = new Coordinates();
        Coordinates coor2 = new Coordinates();
        coor1.setLatitude("36.5785810");
        coor1.setLongitude("-118.2919940");
        coor1.setElevation("4411.94189453125");
        coor2.setLatitude("39.73915360");
        coor2.setLongitude("-104.98470340");
        coor2.setElevation("1608.637939453125");
        System.out.println(distance(coor1, coor2));

    }
}
