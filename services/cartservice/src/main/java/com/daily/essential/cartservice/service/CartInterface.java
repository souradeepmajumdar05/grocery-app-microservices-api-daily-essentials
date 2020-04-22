package com.daily.essential.cartservice.service;

import com.daily.essential.cartservice.model.Cart;
import com.daily.essential.cartservice.model.Items;

import java.util.List;

public interface CartInterface
{
    List<Cart> getCartForUser(long userid);
    void addItemInCart(Cart cart);
    void deleteCart(long userid);
    void removeItemInCart(Cart cart);
}
