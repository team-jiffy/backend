package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.*;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;
import com.jiffydelivery.jiffy.Entity.ModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Reco;
import com.jiffydelivery.jiffy.Entity.ModelEntities.UnfinishedOrder;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @PutMapping("/order/createOrder")
    public NewOrderResponse createOrder(@RequestBody NewOrderRequest newOrderRequest) {
        System.out.println(newOrderRequest.toString());
        // TODO: return related service API with newOrderRequest as param
        return new NewOrderResponse(new Order("label", null, null, "12345", null, "drone", "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @GetMapping("/order/getAllOrders")
    public AllOrdersResponse getAllOrders(@RequestBody AllOrdersRequest allOrdersRequest) {
        System.out.println(allOrdersRequest.toString());
        // TODO: return related service API with allOrdersRequest as param
        return new AllOrdersResponse(new BriefOrder[]{new BriefOrder("123", "hayley", "zev", "Apr 11",
                "robot",
            "Apr 13",
                "on process")});
    }

    @GetMapping("/order/getOrderHistory")
    public OrderHistoryResponse getOrderHistory(@RequestBody OrderHistoryRequest orderHistoryRequest) {
        System.out.println(orderHistoryRequest.toString());
        // TODO: return related service API with orderHistoryRequest as param
        return new OrderHistoryResponse(new Order("label", null, null, "12345", null, "drone",
                "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @GetMapping("/order/getReco")
    public RecoResponse getReco(@RequestBody RecoRequest recoRequest) {
        System.out.println(recoRequest.toString());
        // TODO: return related service API with recoRequest as param
        return new RecoResponse(new Reco[]{new Reco("drone", "$19.90", "13:30")});
    }

    @GetMapping("/order/nonFinishedOrder")
    public NonFinishedOrderResponse getNonFinished(@RequestBody NonFinishedOrderRequest nonFinishedOrderRequest) {
        System.out.println(nonFinishedOrderRequest.toString());
        // TODO: return related service API with nonFinishedOrderRequest as param
        return new NonFinishedOrderResponse(new UnfinishedOrder());
    }

}
