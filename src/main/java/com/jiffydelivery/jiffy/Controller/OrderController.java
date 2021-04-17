package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.*;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;
import com.jiffydelivery.jiffy.Entity.ModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.ModelEntities.Reco;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @PutMapping("/order/createOrder")
    public NewOrderResponse createOrder(@RequestBody NewOrderRequest newOrderRequest) {
        System.out.println(newOrderRequest.toString());
        // TODO: return related service API with newOrderRequest as param
        return new NewOrderResponse("200","OK",new Order("label", null, null, "12345", null, "drone", "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @GetMapping("/order/getAllOrders")
    public AllOrdersResponse getAllOrders(@RequestParam(value="UID") String UID) {
        System.out.println("testRequestParam: " + UID);
        // TODO: return related service API with allOrdersRequest as param
        return new AllOrdersResponse("200", "OK", new BriefOrder[]{new BriefOrder("123", "hayley", "zev", "Apr 11",
                "robot",
            "Apr 13",
                "on process")});
    }

    @GetMapping("/order/getOrderHistory")
    public OrderHistoryResponse getOrderHistory(@RequestParam(value="trackNumber", required = false) String trackNumber,
                                                @RequestParam(value="UID", required = false) String UID) {
        System.out.println("testRequestParam: " + "trackNumber: " + trackNumber + "; " + "UID: " + UID);
        // TODO: return related service API with orderHistoryRequest as param
        return new OrderHistoryResponse("200", "OK", new Order("label", null, null, "12345", null, "drone",
                "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @PostMapping("/order/getReco")
    public RecoResponse createReco(@RequestBody RecoRequest recoRequest) {
        System.out.println(recoRequest.toString());
        // TODO: return related service API with recoRequest as param
        return new RecoResponse("200", "OK", new Reco[]{new Reco("drone", "$19.90", "13:30")});
    }

}
