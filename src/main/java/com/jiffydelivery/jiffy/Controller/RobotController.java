package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.AccidentReportRequest;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.ProgressReportRequest;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.AccidentReportResponse;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.ProgressReportResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    @PostMapping("/Robot/AccidentReport")
    public AccidentReportResponse accidentReport(
            @RequestBody AccidentReportRequest request){
        return new AccidentReportResponse();

    }

    @PostMapping("/Robot/ProgressReport")
    public ProgressReportResponse progressReportResponse(
            @RequestBody ProgressReportRequest request) {
        return new ProgressReportResponse();
    }
}
