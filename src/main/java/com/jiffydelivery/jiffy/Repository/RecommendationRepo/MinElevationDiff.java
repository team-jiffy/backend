package com.jiffydelivery.jiffy.Repository.RecommendationRepo;

import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Repository.APIRepository.ElevationClient;

import java.net.MalformedURLException;

public class MinElevationDiff {
    public boolean getMinElevation(PositionCoordinates pickupPositionCoordinates, PositionCoordinates deliveryPositionCoordinates) throws MalformedURLException {
        double pickupElevation;
        double deliveryElevation;
        //get pickup address elevation
        ElevationClient pickupClient = new ElevationClient();
        pickupElevation = (pickupClient.getElevation(pickupPositionCoordinates).getElevation());
        //get delivery address elevation
        ElevationClient deliveryClient = new ElevationClient();
        deliveryElevation = (deliveryClient.getElevation(deliveryPositionCoordinates).getElevation());
        double pickupDeliveryEleDiff = Math.abs(pickupElevation - deliveryElevation);
        //check the elevation difference between warehouse, pickup address, delivery address
//        Warehouse 1: '52','37.73476682228622','-122.41740295676183'
//        Warehouse 2: '82','37.777932499472485','-122.44752128696365'
//        Warehouse 3: '108','37.743231072877926','-122.47482151074911'
        //warehouse 1
        double elevationDifference1 = Math.max((Math.abs(1107 - pickupElevation)), pickupDeliveryEleDiff);
        elevationDifference1 = Math.max((Math.abs(1107 - deliveryElevation)), elevationDifference1);
        //warehouse 2
        double elevationDifference2 = Math.max((Math.abs(1354 - pickupElevation)), pickupDeliveryEleDiff);
        elevationDifference2 = Math.max((Math.abs(1354 - deliveryElevation)), elevationDifference2);
        //warehouse 3
        double elevationDifference3 = Math.max((Math.abs(895 - pickupElevation)), pickupDeliveryEleDiff);
        elevationDifference3 = Math.max((Math.abs(895 - deliveryElevation)), elevationDifference3);

        if (elevationDifference1 < 1000 || elevationDifference2 < 1000 || elevationDifference3 < 1000) {
            return true;
        } else {
            return false;
        }
    }

}
