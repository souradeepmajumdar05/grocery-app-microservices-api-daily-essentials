package com.daily.essential.cartservice.controller;

import com.daily.essential.cartservice.model.Cart;
import com.daily.essential.cartservice.model.Items;
import com.daily.essential.cartservice.repository.CartRepository;
import com.daily.essential.cartservice.service.Implementation.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1")
public class CartController
{

    CartRepository cartRepository;
    CartServiceImpl cartServiceImpl;
    CartController(CartServiceImpl cartServiceImpl,CartRepository cartRepository)
    {
        this.cartServiceImpl=cartServiceImpl;
        this.cartRepository=cartRepository;
    }
    @CrossOrigin("*")
    @GetMapping("/cart/user/{userid}")
    @ResponseBody
    public List<Cart> getAllItems(@PathVariable long userid) {
        return cartServiceImpl.getCartForUser(userid);
    }

    @CrossOrigin("*")
    @PostMapping("/cart")
    @ResponseBody
    public void addItemInCart(Cart cart)
    {
        cartServiceImpl.addItemInCart(cart);
    }

    @CrossOrigin("*")
    @DeleteMapping("/cart/user/{userid}")
    @ResponseBody
    public void  addItemInCart(@PathVariable long userid)
    {
         cartServiceImpl.deleteCart(userid);
    }
    @CrossOrigin("*")
    @PostMapping("/cart/user/additem")
    @ResponseBody
    public void  addItemInCartForUser(@RequestBody Cart cart)
    {
        cartServiceImpl.addItemInCart(cart);
    }
    @CrossOrigin("*")
    @PostMapping("/cart/user/deleteitem")
    @ResponseBody
    public void  removeItemInCartForUser(@RequestBody Cart cart)
    {
        cartServiceImpl.removeItemInCart(cart);
    }
    @CrossOrigin("*")
    @PostMapping("/cart/create")
    @ResponseBody
    public void createDBentry() {
        Cart c = new Cart();
        c.setUserId(1);
        List<Items> l = new ArrayList<>();
        l.add(new Items(1,10,"kg",new BigDecimal(20),"INR"));
        l.add(new Items(2,10,"kg",new BigDecimal(20),"INR"));
        l.add(new Items(3,10,"kg",new BigDecimal(20),"INR"));
        c.setListOfItems(l);

        cartRepository.save(c);
    }
}
