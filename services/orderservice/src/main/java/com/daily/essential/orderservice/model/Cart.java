package com.daily.essential.orderservice.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Cart
{
    @Id
    Integer userId;
    List<Items> listOfItems;

    public Cart() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Items> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Items> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public Cart(Integer userId, List<Items> listOfItems) {
        this.userId = userId;
        this.listOfItems = listOfItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", listOfItems=" + listOfItems +
                '}';
    }
}
