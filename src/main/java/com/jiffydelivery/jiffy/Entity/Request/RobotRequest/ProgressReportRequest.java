package com.jiffydelivery.jiffy.Entity.Request.RobotRequest;


import com.jiffydelivery.jiffy.Entity.Constance.TripType;
import com.jiffydelivery.jiffy.Entity.DBDAO.ADV;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.ADVRobot;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Coordinates;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProgressReportRequest {
    private ADV adv;
}
