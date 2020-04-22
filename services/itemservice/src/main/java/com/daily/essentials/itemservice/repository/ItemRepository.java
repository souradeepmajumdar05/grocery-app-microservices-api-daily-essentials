package com.daily.essentials.itemservice.repository;

import com.daily.essentials.itemservice.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository <Item,Integer> {
    @Query(value = "SELECT * FROM item where in_stock=1",nativeQuery = true)
    List<Item> findAllInstock();

    @Query(value = "SELECT * FROM item where id=?1",nativeQuery = true)
    Item findItemById(long itemId);

    @Query(value = "SELECT * FROM item where id=?1 and in_stock=true",nativeQuery = true)
    Item findItemAvailableBy(long itemId);
}
