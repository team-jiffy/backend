package com.jiffydelivery.jiffy.Controller;

import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerCreationRequest;

import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerSigninRequest;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CustomerSignoutRequest;
import com.jiffydelivery.jiffy.Entity.Response.CustomerResponse.*;

import com.jiffydelivery.jiffy.Entity.Response.RobotResponse.AccidentReportResponse;
import com.jiffydelivery.jiffy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jiffydelivery.jiffy.Entity.FrontModelEntities.User;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.net.http.HttpRequest;

@RestController
public class UserController {

    @Autowired UserService userService;

    /* maps to API #17. Sign up a user*/
    @PostMapping("/signup")
    public CustomerCreationResponse createOrder(@RequestBody CustomerCreationRequest userRequest) {
        return userService.CreateCustomerResponse(userRequest);
    }

    @PostMapping("/signin")
    public CustomerSigninResponse signin(@RequestBody CustomerSigninRequest userSigninRequest,
                                         HttpServletRequest request){
//        System.out.println(userSigninRequest);
        User user = userService.checkUserPassword(userSigninRequest.getEmail(),userSigninRequest.getPassword());
        CustomerSigninResponse response = new CustomerSigninResponse();
        if (user!=null) {
            HttpSession session = request.getSession(); //create session and save it to server.
            session.setAttribute("user_id", user.getUID());

            response.setUser(user);
            response.setStatus("OK");
            response.setMessage("Success!");
            return response;
        } else {
            response.setStatus("failed");
            response.setStatus("can't login");
        }
        return response;
    }
    /* maps to API #18. logout*/
    @PostMapping("/signout")
    public LogoutResponse signout(@RequestBody CustomerSignoutRequest request,
                                  HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        if (session==null){
            LogoutResponse response = new LogoutResponse();
            response.setStatus("Failed");
            response.setMessage("You should login first");
            res.setStatus(404);
            return response;
        } else {
            session.invalidate();
            System.out.println("UID is: " + request.getUID());
            return new LogoutResponse("200", "OK");
        }
    }

    /* maps to API #20 update a user's info */
    @PostMapping("/users/updateInfo")
    public CustomerUpdateResponse updateCustomer(@RequestBody User newUser, HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            CustomerUpdateResponse response = new CustomerUpdateResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        // TODO: User actual user input to initialize the User
        return userService.updateCustomer(newUser);
    }

    /* maps to API #21. get user profile */
    @GetMapping("/user/profile")
    public GetCustomerResponse getCustomer(@RequestParam(value="UID", required = false) String UID,  HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            GetCustomerResponse response = new GetCustomerResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        int uidAsInt=Integer.parseInt(UID);
        return userService.getCustomer(uidAsInt);
    }

    /* maps to API #22. update password */
    @GetMapping("/user/updatePassword")
    public PasswordUpdateResponse updatePassword(@RequestParam(value="UID", required = true, defaultValue="id") String UID,
                                                 @RequestParam(value="password", required = true, defaultValue="defaultPassword") String password,
                                                 HttpServletRequest req, HttpServletResponse res) {
//        System.out.println("UID is: " + UID);
//        HttpSession session = req.getSession(false);
//        if (session==null){
//            PasswordUpdateResponse response = new PasswordUpdateResponse();
//            response.setStatus("Failed");
//            response.setMessage("You should login first");
//            res.setStatus(404);
//            return response;
//        }
        return userService.updatePassword(UID, password);
    }
}

