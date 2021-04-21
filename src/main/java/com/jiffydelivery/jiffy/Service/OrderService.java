package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;

import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.NewOrderRequest;
import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.RecoRequest;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;

import com.jiffydelivery.jiffy.Repository.OrderRepository;
import com.jiffydelivery.jiffy.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    private BriefOrder extractOrder(com.jiffydelivery.jiffy.Entity.DBDAO.Order order) {
        return new BriefOrder.BriefOrderBuilder()
                .trackNumber(order.getTrackNumber())
                .senderName(order.getSenderContact().getFirstName() + order.getSenderContact().getLastName())
                .recipientName(order.getRecipientContact().getFirstName() + order.getRecipientContact().getLastName())
                .orderDate(order.getDeliverOrderDate().toString())
                .ADVType(order.getADVType().toString())
                .ETA(order.getDeliverTime().toString())
                .orderStatus(order.getOrderStatus().toString())
                .build();
    }

    /**
    *  Used for API #12
    *  @param CreateOrderRequest req
    *  @return CreateOrderResponse createOrdersResponse
    */
    public NewOrderResponse createOrder(NewOrderRequest req){


        NewOrderResponse dbOrder = new NewOrderResponse();//orderRepository.createOrder(req);
        com.jiffydelivery.jiffy.Entity.DBDAO.Order newOrder
                = new com.jiffydelivery.jiffy.Entity.DBDAO.Order();
        newOrder.setADVType(req.getADVType());
        newOrder.setSameday(req.isSameDay());
        newOrder.setPrice(req.getPrice());
        newOrder.setSenderContact(req.getPickup().extract());
        newOrder.setRecipientContact(req.getDeliver().extract());

        NewOrderResponse newOrderResponse = new NewOrderResponse();
        Order placedOrder = orderRepository.createOrder(newOrder);
        newOrderResponse.setOrder(placedOrder.extract());

        if(placedOrder == null){
            newOrderResponse.setMessage("user creation failed");
            newOrderResponse.setStatus("404");
        }else{
            newOrderResponse.setMessage("order creation success.");
            newOrderResponse.setOrder(placedOrder.extract());
            newOrderResponse.setStatus("200");
        }

        return newOrderResponse;
    }

    /**
     *  Used for API #14
     *  @param int UID
     *  @return AllOrdersResponse res
     */
    public AllOrdersResponse GetAllOrders(String UID){
        AllOrdersResponse res = new AllOrdersResponse();

        List<Order> orders = orderRepository.getAllOrders(UID);

        if(orders.size() == 0){
            res.setMessage("get all orders failed.");
            res.setStatus("failed");
        }else{
            // should prob set the fields of dbOrders explicitly
            res.setMessage("get all orders success.");
            res.setStatus("success");
            BriefOrder[] briefOrders = new BriefOrder[orders.size()];
            for (int i=0;i<orders.size();i++){
                briefOrders[i] = orders.get(i).toBriefOrder();
            }
            res.setOrders(briefOrders);
        }
        return res;
    }

    /**
     *  Used for API #15 order/getOrderHistory
     *  @param TrackNumber string
     *  @param  UID string (or int?)
     *  @return AllOrdersResponse res
     */
    public OrderHistoryResponse GetOrderHistory(String trackNumber){
        OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
        com.jiffydelivery.jiffy.Entity.DBDAO.Order order = orderRepository.getOrderHistory(trackNumber);
        if(order == null){
            orderHistoryResponse.setMessage("Can't find Ordder");
            orderHistoryResponse.setStatus("failed");
        }else{
            orderHistoryResponse.setOrder(order.extract());
            orderHistoryResponse.setMessage("get order history success.");
            orderHistoryResponse.setStatus("success");
        }
        return orderHistoryResponse;
    }

    /**
     *  Used for API #16 order/getReco
     *  @param RecoRequest req
     *  @return RecoResponse res
     */
//    public RecoResponse CreateRecoResponse(RecoRequest req){
//        RecoResponse dbRecoRes = new RecoResponse();
//        Address pickupAddress = req.getPickupAddress().getPickupAddress();
//        Address deliveryAddress = req.getDeliveryAddress().getDeliveryAddress();
//        // @TODO: DBDAO Address vs Frontend Address
//        // orderRepository.getReco();
//        return dbRecoRes;
//    }

}
