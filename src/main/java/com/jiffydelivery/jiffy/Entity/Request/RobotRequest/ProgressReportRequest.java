package com.jiffydelivery.jiffy.Entity.Request.RobotRequest;


import com.jiffydelivery.jiffy.Entity.FrontModelEntities.ADVDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProgressReportRequest {
    private ADVDto advDao;
}
