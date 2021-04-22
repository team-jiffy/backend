package com.jiffydelivery.jiffy.Repository.RecommendationRepo;

import com.jiffydelivery.jiffy.Entity.DAO.PositionCoordinates;
import com.jiffydelivery.jiffy.Repository.APIRepository.StraightDistance;

public class ClosestWarehouse {
    public PositionCoordinates getClosestWarehouse(PositionCoordinates pickupPositionCoordinates) {

        // create PositionCoordinates for 3 warehouses
        PositionCoordinates warehouse1Coordinates = new PositionCoordinates();
        warehouse1Coordinates.setLatitude(37.73476682228622);
        warehouse1Coordinates.setLongitude(-122.41740295676183);
        warehouse1Coordinates.setElevation(1107);

        PositionCoordinates warehouse2Coordinates = new PositionCoordinates();
        warehouse2Coordinates.setLatitude(37.777932499472485);
        warehouse2Coordinates.setLongitude(-122.44752128696365);
        warehouse2Coordinates.setElevation(1354);

        PositionCoordinates warehouse3Coordinates = new PositionCoordinates();
        warehouse3Coordinates.setLatitude(37.743231072877926);
        warehouse3Coordinates.setLongitude(-122.47482151074911);
        warehouse3Coordinates.setElevation(895);

    //get min straight distance from three warehouses to the pickup address
    StraightDistance straightDistance = new StraightDistance();
    double straightDistance1 = straightDistance.distance(warehouse1Coordinates, pickupPositionCoordinates);
    double straightDistance2 = straightDistance.distance(warehouse2Coordinates, pickupPositionCoordinates);
    double straightDistance3 = straightDistance.distance(warehouse3Coordinates, pickupPositionCoordinates);

    //record the closest warehouse to the pickup address
    PositionCoordinates closestWarehouse = new PositionCoordinates();
    closestWarehouse = warehouse1Coordinates;
        if (straightDistance2 < straightDistance1 && straightDistance2 < straightDistance3) {
        closestWarehouse = warehouse2Coordinates;
    } else if (straightDistance3 < straightDistance1 && straightDistance3 < straightDistance3){
        closestWarehouse = warehouse3Coordinates;
    }
        return closestWarehouse;
    }
}
