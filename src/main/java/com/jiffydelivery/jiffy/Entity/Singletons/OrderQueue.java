package com.jiffydelivery.jiffy.Entity.Singletons;

import com.jiffydelivery.jiffy.Entity.DBDAO.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Getter
@NoArgsConstructor
@Component
public class OrderQueue {
    private Queue<Order> robotOrderQueue;
    private Queue<Order> droneOrderQueue;
}