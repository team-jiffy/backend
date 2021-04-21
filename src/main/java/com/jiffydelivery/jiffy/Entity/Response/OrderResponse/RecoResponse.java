package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecoResponse {
    private String status;
    private String message;
    private Reco[] recos;

}
