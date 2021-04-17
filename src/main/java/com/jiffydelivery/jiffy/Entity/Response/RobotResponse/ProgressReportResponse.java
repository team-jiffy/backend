package com.jiffydelivery.jiffy.Entity.Response.RobotResponse;


import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Trip;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProgressReportResponse {
    private Trip trip;
}
