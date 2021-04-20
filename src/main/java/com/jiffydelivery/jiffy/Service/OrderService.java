package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Address;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.BriefOrder;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.Order;

import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.CreateOrderRequest;
import com.jiffydelivery.jiffy.Entity.Request.OrderRequest.RecoRequest;
import com.jiffydelivery.jiffy.Entity.Response.OrderResponse.*;

import com.jiffydelivery.jiffy.Repository.OrderRepository;
import com.jiffydelivery.jiffy.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
    *  Used for API #12
    *  @param CreateOrderRequest req
    *  @return CreateOrderResponse createOrdersResponse
    */
    public CreateOrderResponse CreateCreateOrderResponse(CreateOrderRequest req){

        NewOrderResponse dbOrder = orderRepository.createOrder(req);
        Order newOrder = new Order();
        CreateOrderResponse createOrdersResponse = new CreateOrderResponse();

        if(dbOrder == null){
            createOrdersResponse.setMessage("user creation failed");
            createOrdersResponse.setStatus("404");
        }else{
            newOrder = dbOrder.getOrder();
            createOrdersResponse.setMessage("order creation success.");
            createOrdersResponse.setOrder(newOrder);
            createOrdersResponse.setStatus("200");
        }

        return createOrdersResponse;
    }

    /**
     *  Used for API #14
     *  @param int UID
     *  @return AllOrdersResponse res
     */
    public AllOrdersResponse CreateGtAllOrdersResponse(int UID){
        AllOrdersResponse dbOrders = new AllOrdersResponse();
        dbOrders = orderRepository.getAllOrders(String.valueOf(UID));

        // ....getAllOrders returns an AllOrderResponse??!...

        if(dbOrders == null){
            dbOrders.setMessage("get all orders failed.");
            dbOrders.setStatus("404");
        }else{
            // should prob set the fields of dbOrders explicitly
            dbOrders.setMessage("get all orders success.");
            dbOrders.setStatus("200");
        }
        return dbOrders;
    }

    /**
     *  Used for API #15 order/getOrderHistory
     *  @param TrackNumber string
     *  @param  UID string (or int?)
     *  @return AllOrdersResponse res
     */
    public OrderHistoryResponse CreateOrderHistoryResponse(String TrackNumber, int UID){
        OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
        orderHistoryResponse = orderRepository.getOrderHistory(TrackNumber);

        if(orderHistoryResponse == null){
            orderHistoryResponse.setMessage("get order history failed.");
            orderHistoryResponse.setStatus("404");
        }else{
            //@TODO assign the fields explicitly if the return of .getOrderHistory() is updated
            orderHistoryResponse.setMessage("get order history success.");
            orderHistoryResponse.setStatus("200");
        }
        return orderHistoryResponse;
    }

    /**
     *  Used for API #16 order/getReco
     *  @param RecoRequest req
     *  @return RecoResponse res
     */
    public RecoResponse CreateRecoResponse(RecoRequest req){
        RecoResponse dbRecoRes = new RecoResponse();
        Address pickupAddress = req.getPickupAddress().getPickupAddress();
        Address deliveryAddress = req.getDeliveryAddress().getDeliveryAddress();
        // @TODO: DBDAO Address vs Frontend Address
        // orderRepository.getReco();
        return dbRecoRes;
    }

    /**
     *  Used for API #?? order/nonFinishedOrder
     *  @param int UID
     *  @return NonFiniOrder nonFiniOrder
     */
    public NonFiniOrderResponse CreateRecoResponse(int UID){
        NonFiniOrderResponse dbRecoRes = new NonFiniOrderResponse();
        // @TODO: Might need a different name for the DB Order entity?
        // @TODO: Fill in the .getNonFiniOrder method in orderRepository
        // Order dbOrder =  orderRepository.getNonFiniOrder(UID);
        return dbRecoRes;
    }
}
