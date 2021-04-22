package com.jiffydelivery.jiffy.Repository.RecommendationRepo;

import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Repository.APIRepository.StraightDistance;

public class TotalStraightDistance {

    public double getTotalStraightDistance(PositionCoordinates closestWarehouse, PositionCoordinates pickupPositionCoordinates, PositionCoordinates deliveryPositionCoordinates) {
        //get the straight distance between the closest warehouse to the pickup address
        StraightDistance straightDistanceW2Pickup = new StraightDistance();
        double straightDistanceW2P = straightDistanceW2Pickup.distance(closestWarehouse, pickupPositionCoordinates);

        //get the straight distance between pickup address and delivery address
        StraightDistance straightDistanceP2Delivery = new StraightDistance();
        double straightDistanceP2D = straightDistanceP2Delivery.distance(pickupPositionCoordinates, deliveryPositionCoordinates);

        //get the straight distance between delivery address and the closest warehouse
        StraightDistance straightDistanceD2Warehouse = new StraightDistance();
        double straightDistanceD2W = straightDistanceD2Warehouse.distance(deliveryPositionCoordinates, closestWarehouse);
        //total fly distance for drone delivery
        double totalFlyDistance = straightDistanceW2P + straightDistanceP2D + straightDistanceD2W;
        return totalFlyDistance;
    }
}


