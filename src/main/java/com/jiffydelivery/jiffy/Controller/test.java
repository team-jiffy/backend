package com.jiffydelivery.jiffy.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/address")
    public String test(@RequestParam String aa ){
        return "adf";
    }
}
