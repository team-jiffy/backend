package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;

import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerSigninRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.*;

import com.jiffydelivery.jiffy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired UserService userService;

    /* maps to API #17. Sign up a user*/
    @PutMapping("/signup")
    public CustomerCreationResponse createOrder(@RequestBody CustomerCreationRequest userRequest) {
        return userService.CreateCustomerResponse(userRequest);
    }

    @PostMapping("/signin")
    public CustomerSigninResponse signin(@RequestBody CustomerSigninRequest userSigninRequest){
//        System.out.println(userSigninRequest);
        User user = userService.checkUserPassword(userSigninRequest.getEmail(),userSigninRequest.getPassword());
        if (user!=null) {
            CustomerSigninResponse response = new CustomerSigninResponse();
            response.setUser(user);
            response.setStatus("OK");
        }
        return new CustomerSigninResponse();
    }
    /* maps to API #18. logout*/
//    @PutMapping("/logout")
//    public LogoutResponse createOrder(@RequestParam(value="UID", required = true, defaultValue = "unknownID") String UID) {
//        System.out.println("UID is: " + UID);
//        return new userService.("200", "OK");
//    }

    /* maps to API #20 update a user's info */
    @PostMapping("/users/updateInfo")
    public CustomerUpdateResponse updateCustomer(@RequestBody User newUser) {
        System.out.print("sadf");
        // TODO: User actual user input to initialize the User
        return userService.updateCustomer(newUser);
    }

    /* maps to API #21. get user profile */
    @GetMapping("/user/profile")
    public GetCustomerResponse getCustomer(@RequestParam(value="UID", required = false) String UID) {
        int uidAsInt=Integer.parseInt(UID);
        return userService.getCustomer(uidAsInt);
    }

    /* maps to API #22. update password */
    @GetMapping("/user/updatePassword")
    public PasswordUpdateResponse updatePassword(@RequestParam(value="UID", required = true, defaultValue="id") String UID, @RequestParam(value="password", required = true, defaultValue="defaultPassword") String password) {
//        System.out.println("UID is: " + UID);
        return userService.updatePassword(UID, password);
    }
}

