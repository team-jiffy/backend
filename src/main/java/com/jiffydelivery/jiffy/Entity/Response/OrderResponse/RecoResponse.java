package com.jiffydelivery.jiffy.Entity.Response.OrderResponse;

import com.jiffydelivery.jiffy.Entity.ModelEntities.Reco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class RecoResponse {
    private Reco[] recos;
}
