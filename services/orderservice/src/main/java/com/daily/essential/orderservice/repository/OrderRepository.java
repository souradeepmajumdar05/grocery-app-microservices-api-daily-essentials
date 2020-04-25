package com.daily.essential.orderservice.repository;

import com.daily.essential.orderservice.model.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Integer> {
    @Query(value = "SELECT * FROM orders where uid=?1",nativeQuery = true)
    List<Orders> getOrderByUserId(long userid);
}
