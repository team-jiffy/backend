package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.AccidentReportRequest;
import com.jiffydelivery.jiffy.Entity.Request.RobotRequest.ProgressReportRequest;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.AccidentReportResponse;
import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.ProgressReportResponse;
import com.jiffydelivery.jiffy.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/robot")
public class RobotController {
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json");
    }

    @Autowired
    RobotService progressReportService;

    @PostMapping("/accidentReport")
    public AccidentReportResponse accidentReport(@RequestBody AccidentReportRequest request){

        return new AccidentReportResponse(12);
    }

    @PostMapping("/progressReport")
    public ProgressReportResponse progressReportResponse(
            @RequestBody ProgressReportRequest request) throws MalformedURLException {
        return progressReportService.assignNextTrip(request.getAdvDao());
    }
}
