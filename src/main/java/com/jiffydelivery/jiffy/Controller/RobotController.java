package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Trip;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.AccidentReportRequest;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.ProgressReportRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.AccidentReportResponse;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.ProgressReportResponse;
import com.jiffydelivery.jiffy.Service.ProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/robot")
public class RobotController {
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json");
    }

    @Autowired
    ProgressReportService progressReportService;

    @PostMapping("/accidentReport")
    public AccidentReportResponse accidentReport(@RequestBody AccidentReportRequest request){

        return new AccidentReportResponse(12);
    }

    @PostMapping("/progressReport")
    public ProgressReportResponse progressReportResponse(
            @RequestBody ProgressReportRequest request) {
        progressReportService.assignNextTrip(request.getAdvDao());
        System.out.println(request.toString());
        return new ProgressReportResponse(new Trip(TripType.Outside,
                new Coordinates("32","65","75"),
                "343"));
    }
}
