package com.jiffydelivery.jiffy.Controller;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;

import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerCreationResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.CustomerUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.GetCustomerResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.PasswordUpdateResponse;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.LogoutResponse;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    /* maps to API #17. Sign up a user*/
    @PutMapping("/signup")
    public CustomerCreationResponse createOrder(@RequestBody CustomerCreationRequest userRequest) {
        System.out.println(userRequest.toString());
        // User newUser = new User(userRequest.email, userRequest.lastName, userRequest.defaultSender, userRequest.UID, userRequest.firstName, userReuqest.phone, userRequest.profilePictureURL, userRequest.defaultRecipient, userRequestpassword, userRequest.location);
        User newUser = new User("e", "ln", null, "id", "fname", "phone", "url", null, null);
        return new CustomerCreationResponse("200", "OK", newUser);
    }

    /* maps to API #18. logout*/
    @PutMapping("/logout")
    public LogoutResponse createOrder(@RequestParam(value="UID", required = true, defaultValue = "unknownID") String UID) {
        System.out.println("UID is: " + UID);
        return new LogoutResponse("200", "OK");
    }

    /* maps to API #20 update a user's info */
    @PostMapping("/users/updateInfo")
    public CustomerUpdateResponse updateCustomer(@RequestBody CustomerCreationRequest updateCustomerRequest) {
        System.out.println(updateCustomerRequest.toString());
        // TODO: User actual user input to initialize the User
        User updatedUser = new User("e", "ln", null, "id", "fname", "phone", "url", null, null);
        return new CustomerUpdateResponse("200", "OK", updatedUser);
    }

    /* maps to API #21. get user profile */
    @GetMapping("/user/profile")
    public GetCustomerResponse getCustomer(@RequestParam(value="UID", required = false) String UID) {
        System.out.println("UID is: " + UID);
        return new GetCustomerResponse("200", "OK", new User());
    }

    /* maps to API #22. update password */
    @GetMapping("/user/updatePassword")
    public PasswordUpdateResponse updatePassword(@RequestParam(value="UID", required = true, defaultValue="id") String UID, @RequestParam(value="password", required = true, defaultValue="defaultPassword") String password) {
        System.out.println("UID is: " + UID);
        return new PasswordUpdateResponse("200", "OK");
    }
}

