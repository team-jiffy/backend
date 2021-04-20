package com.jiffydelivery.jiffy.Service;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerCreationResponse;
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
    *  @param CreateOrderRequest
    *  @return CreateOrderResponse
    */
    public CreateOrdersResponse CreateCreateOrderResponse(CreateOrderRequest req){

    }

    public NewOrderResponse CreateNewOrderResponse(){

    }

    public OrderHistoryResponse CreateOrderHistoryResponse(){

    }

    public RecoResponse CreateRecoResponse(){

    }

    public CustomerCreationResponse CreateCustomerResponse (CustomerCreationRequest customerCreationRequest){
        Customer dbuser = customerRepository.createCustomer(customerCreationRequest);
        User user = new User();
        CustomerCreationResponse customerCreationResponse = new CustomerCreationResponse();
        if (dbuser == null) {
            customerCreationResponse.setMessage("user creation fail.");
            customerCreationResponse.setStatus("404");
        } else {
            String s = Integer.toString((int) dbuser.getId());

            user.setUID(s);
            user.setLastName(dbuser.getLastName());
            user.setFirstName(dbuser.getFirstName());
            user.setEmail(dbuser.getEmail());
            user.setPhone(dbuser.getPhone());
            user.setProfilePictureURL(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzH6TfTtq91hzmeIvm_4JOdb5y1UWjTlYZdA&usqp=CAU");
            customerCreationResponse.setMessage("user creation success.");
            customerCreationResponse.setUser(user);
            customerCreationResponse.setStatus("200");
        }

        return customerCreationResponse;
    }

}
