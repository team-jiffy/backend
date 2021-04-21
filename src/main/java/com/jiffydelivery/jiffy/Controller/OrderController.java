package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.*;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.SetDefaultResponse;
import com.jiffydelivery.jiffy.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PutMapping("/order/createOrder")
    public NewOrderResponse createOrder(@RequestBody NewOrderRequest newOrderRequest ,
                                        HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        if (session==null){
            NewOrderResponse response = new NewOrderResponse();
            response.setStatus("Failed");
            response.setMessage("You should login first");
            res.setStatus(404);
            return response;
        }
        System.out.println(newOrderRequest.toString());
//      TODO: return related service API with newOrderRequest as param
        return new NewOrderResponse("200","OK",new Order("label", null, null, 1, null, "drone", "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @GetMapping("/order/getAllOrders")
    public AllOrdersResponse getAllOrders(@RequestParam(value="UID", required = true, defaultValue = "unknown") String UID,
                                        HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        if (session==null){
            AllOrdersResponse response = new AllOrdersResponse();
            response.setStatus("Failed");
            response.setMessage("You should login first");
            res.setStatus(404);
            return response;
        }
        System.out.println("testRequestParam: " + UID);
        // TODO: return related service API with allOrdersRequest as param
        return new AllOrdersResponse("200", "OK", new BriefOrder[]{new BriefOrder.BriefOrderBuilder()
                .trackNumber(1)
                .senderName("hayley")
                .recipientName("zev")
                .orderDate("Apr 11")
                .ADVType("robot")
                .orderDate("Apr 13")
                .orderStatus("on process")
                .build()});
    }

    @GetMapping("/order/getOrderHistory")
    public OrderHistoryResponse getOrderHistory(@RequestParam(value="trackNumber", required = false) String trackNumber,
                                                @RequestParam(value="UID", required = false) String UID) {
        System.out.println("testRequestParam: " + "trackNumber: " + trackNumber + "; " + "UID: " + UID);
        // TODO: return related service API with orderHistoryRequest as param
        return new OrderHistoryResponse("200", "OK", new Order("label", null, null, 1, null, "drone",
                "13:30", true,
                "$19.90", "Apr 11", "on delivery", "small", null, null));
    }

    @PostMapping("/order/getReco")
    public RecoResponse createReco(@RequestBody RecoRequest recoRequest) {

        System.out.println(recoRequest.toString());
        // TODO: return related service API with recoRequest as param
        return new RecoResponse("200", "OK", new Reco[]{new Reco("private drone", "$19.90", "13:30"),
                new Reco("private robot", "$15.90", "09:30"),
                new Reco("shared drone", "$9.90", null)});
    }

}
