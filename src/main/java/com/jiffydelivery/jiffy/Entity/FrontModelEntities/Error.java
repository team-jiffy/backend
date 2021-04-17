package com.jiffydelivery.jiffy.Entity.FrontModelEntities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Error {
    private int errorCode;
    private String Message;
    private String Time;
}
