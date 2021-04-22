package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Constance.ADVType;
import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.*;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Reco;
import com.jiffydelivery.jiffy.Entity.Response.PaymentsResponse.SetDefaultResponse;
import com.jiffydelivery.jiffy.Service.OrderService;
import com.jiffydelivery.jiffy.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    RobotService robotService;

    @PutMapping("/order/createOrder")
    public NewOrderResponse createOrder(@RequestBody NewOrderRequest newOrderRequest ,
                                        HttpServletRequest req, HttpServletResponse res) throws MalformedURLException {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            NewOrderResponse response = new NewOrderResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        System.out.println(newOrderRequest.toString());
        NewOrderResponse newOrderResponse = orderService.createOrder(newOrderRequest);
        robotService.assignNewOrderToRobot(newOrderResponse.getOrder().toDAO());
        return newOrderResponse;
    }

    @GetMapping("/order/getAllOrders")
    public AllOrdersResponse getAllOrders(@RequestParam(value="UID", required = true, defaultValue = "unknown") String UID,
                                        HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            AllOrdersResponse response = new AllOrdersResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        System.out.println("testRequestParam: " + UID);
        // TODO: return related service API with allOrdersRequest as param
        return orderService.GetAllOrders(UID);
    }

    @GetMapping("/order/getOrderHistory")
    public OrderHistoryResponse getOrderHistory(@RequestParam(value="trackNumber", required = false) String trackNumber,
                                        HttpServletRequest req, HttpServletResponse res) {
        OrderHistoryResponse response = orderService.GetOrderHistory(trackNumber);
        if (!response.getStatus().equals("success")) {
            res.setStatus(404);
        }
        return response;
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
