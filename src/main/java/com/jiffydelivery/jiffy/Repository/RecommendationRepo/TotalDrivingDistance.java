package com.jiffydelivery.jiffy.Repository.RecommendationRepo;

import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Repository.APIRepository.DrivingDistanceClient;

import java.net.MalformedURLException;

public class TotalDrivingDistance {
    public double getTotalDrivingDistance(PositionCoordinates closestWarehouse,
                                          PositionCoordinates pickupPositionCoordinates,
                                          PositionCoordinates deliveryPositionCoordinates) throws MalformedURLException {
        //get driving distance between closest warehouse to the pickup address
        DrivingDistanceClient drivingDistanceW2Pickup = new DrivingDistanceClient();
        double drivingDistanceW2P = drivingDistanceW2Pickup.getDrivingDistance(closestWarehouse, pickupPositionCoordinates);
        //get the driving distance between pickup address and delivery address
        DrivingDistanceClient drivingDistanceP2Delivery = new DrivingDistanceClient();
        double drivingDistanceP2D = drivingDistanceP2Delivery.getDrivingDistance(pickupPositionCoordinates, deliveryPositionCoordinates);

        //get the driving distance between delivery address and the closest warehouse
        DrivingDistanceClient drivingDistanceD2Warehouse = new DrivingDistanceClient();
        double drivingDistanceD2W = drivingDistanceD2Warehouse.getDrivingDistance(deliveryPositionCoordinates, closestWarehouse);

        double totalDrivingDistance = drivingDistanceW2P + drivingDistanceP2D + drivingDistanceD2W;
        return  totalDrivingDistance;
    }

    }
