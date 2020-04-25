package com.daily.essential.orderservice.service;

import com.daily.essential.orderservice.model.*;
import com.daily.essential.orderservice.repository.DeliverStatusRepository;
import com.daily.essential.orderservice.repository.OrderItemMappingRepository;
import com.daily.essential.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl
{
    OrderRepository orderRepository;
    DeliverStatusRepository deliverStatusRepository;
    OrderItemMappingRepository orderItemMappingRepository;
    OrderServiceImpl(OrderRepository orderRepository, DeliverStatusRepository deliverStatusRepository, OrderItemMappingRepository orderItemMappingRepository)
    {
        this.deliverStatusRepository=deliverStatusRepository;
        this.orderRepository=orderRepository;
        this.orderItemMappingRepository=orderItemMappingRepository;
    }
    //@Transactional
    public void createOrder(Cart cart)
    {
        Orders orders=new Orders();
        orders.setId(5);               //should be fetched populated dynamically
        orders.setUid(cart.getUserId());
        orders.setActive(true);
        orders.setCod_charges(new BigDecimal(50));            // should set from a different service
        orders.setCourier_partner_id(1);          // should set from a different service
        orders.setShipping_charges(new BigDecimal(50));
        orders.setStatus("Placed");

        List<OrderItemMapping> items=new ArrayList<>();
        BigDecimal tot=new BigDecimal(0);
        for(Items item:cart.getListOfItems())
        {
            items.add(new OrderItemMapping(orders.getId(),item.getItemid(),item.getQty(),item.getQty_type(),"available"));
            BigDecimal temp=new BigDecimal(item.getQty()).multiply(item.getCost());
            tot=tot.add(temp);
        }
        orders.setTotal(tot);
        orders.setListOfItems(items);
        orders.setDe_coins(orders.getTotal());
        orders.setTotal_cash_to_take(orders.getTotal());
        List<DeliverStatus> ld = new ArrayList<>();
        ld.add(new DeliverStatus(orders.getId(),"placed","Not picked",orders.getCourier_partner_id().toString()));
        orders.setListDeliverStatus(ld);
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        orders.setETA(ts);

        orderRepository.save(orders);
        for(OrderItemMapping oim: orders.getListOfItems())
        {
            orderItemMappingRepository.save(oim);
        }
        deliverStatusRepository.save(orders.getListDeliverStatus().get(0));
    }
    public List<Orders> getOrderForUser(long userid) {
        return orderRepository.getOrderByUserId(userid);
    }
}
