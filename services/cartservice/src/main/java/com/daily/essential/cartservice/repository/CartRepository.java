package com.daily.essential.cartservice.repository;

import com.daily.essential.cartservice.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer>
{
    List<Cart> findByUserId(long userId);

    //@Query(value="{'id' : $0}", delete = true)
    void deleteByUserId (long userId);
}
