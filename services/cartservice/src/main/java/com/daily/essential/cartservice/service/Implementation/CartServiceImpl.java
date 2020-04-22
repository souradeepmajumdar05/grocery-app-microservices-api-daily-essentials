package com.daily.essential.cartservice.service.Implementation;

import com.daily.essential.cartservice.model.Cart;
import com.daily.essential.cartservice.model.Items;
import com.daily.essential.cartservice.repository.CartRepository;
import com.daily.essential.cartservice.service.CartInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartInterface {

    CartRepository cartRepository;
    CartServiceImpl(CartRepository cartRepository)
    {
        this.cartRepository=cartRepository;
    }
    @Override
    public List<Cart> getCartForUser(long userid)
    {
        return cartRepository.findByUserId(userid);
    }
    @Override
    public void deleteCart(long userid) {
        cartRepository.deleteByUserId(userid);

    }

    @Override
    public void removeItemInCart(Cart cart) {
        List<Cart> currentCartItems= cartRepository.findByUserId(cart.getUserId());
        Integer itemIdToBeRemoved=cart.getListOfItems().get(0).getItemid();
        int count = 0;
        List<Items> listOfItems=currentCartItems.get(0).getListOfItems();
        for(int i =0 ;i <listOfItems.size() ;i++)
        {
            if(listOfItems.get(i).getItemid().equals(itemIdToBeRemoved))
            {
                currentCartItems.get(0).getListOfItems().remove(i);
                System.out.println("after removing item : "+currentCartItems);
                cartRepository.save(currentCartItems.get(0));
            }
        }
    }
    @Override
    public void addItemInCart(Cart cart)
    {
        List<Cart> currentCartItems= cartRepository.findByUserId(cart.getUserId());
        currentCartItems.get(0).getListOfItems().addAll(cart.getListOfItems());
        cartRepository.save(currentCartItems.get(0));

    }
}
