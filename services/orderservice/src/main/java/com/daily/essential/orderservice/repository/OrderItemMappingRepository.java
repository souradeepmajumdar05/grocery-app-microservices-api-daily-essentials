package com.daily.essential.orderservice.repository;

import com.daily.essential.orderservice.model.OrderItemMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMappingRepository extends CrudRepository<OrderItemMapping,Integer> {
}
