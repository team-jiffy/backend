package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Trip;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.AccidentReportRequest;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.ProgressReportRequest;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.AccidentReportResponse;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.ProgressReportResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    @PostMapping("/robot/accidentReport")
    public AccidentReportResponse accidentReport(
            @RequestBody AccidentReportRequest request){
        System.out.println(request);
        return new AccidentReportResponse(12);
    }

    @PostMapping("/robot/progressReport")
    public ProgressReportResponse progressReportResponse(
            @RequestBody ProgressReportRequest request) {
        System.out.println(request.toString());
        return new ProgressReportResponse(new Trip(TripType.outside,
                new Coordinates("32","65","75"),
                "343"));
    }
}
