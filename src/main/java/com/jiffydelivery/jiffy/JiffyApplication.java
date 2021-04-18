package com.jiffydelivery.jiffy;

import com.jiffydelivery.jiffy.Entity.DBDAO.Customer;
import com.jiffydelivery.jiffy.Entity.Request.CustomerRequest.CreateCustomerRequest;
import com.jiffydelivery.jiffy.Repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JiffyApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JiffyApplicationConfig.class);
        SpringApplication.run(JiffyApplication.class, args);






    }

}
