package com.daily.essential.orderservice.controller;

import com.daily.essential.orderservice.model.Cart;
import com.daily.essential.orderservice.model.Orders;
import com.daily.essential.orderservice.repository.OrderRepository;
import com.daily.essential.orderservice.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class OrderController
{
    OrderRepository orderRepository;
    OrderServiceImpl orderServiceImpl;
    OrderController(OrderServiceImpl orderServiceImpl,OrderRepository orderRepository)
    {
        this.orderServiceImpl=orderServiceImpl;
        this.orderRepository=orderRepository;
    }
    @CrossOrigin("*")
    @GetMapping("/order/user/{userid}")
    @ResponseBody
    public List<Orders> getAllOrderForUser(@PathVariable long userid)
    {
        return orderServiceImpl.getOrderForUser(userid);
    }

    @CrossOrigin("*")
    @PostMapping("/order")
    @ResponseBody
    public void addItemInCart(@RequestBody Cart cart)
    {
        orderServiceImpl.createOrder(cart);
    }
}
