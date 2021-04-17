package com.jiffydelivery.jiffy.Entity.Request.RobotRequest;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccidentReportRequest {
    private int accidentCode;
    private String accidentType;
    private double batteryPercent;
    private int onGoingTripID;
}
