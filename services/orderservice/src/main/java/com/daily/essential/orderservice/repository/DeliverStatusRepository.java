package com.daily.essential.orderservice.repository;

import com.daily.essential.orderservice.model.DeliverStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverStatusRepository  extends CrudRepository<DeliverStatus,Integer> {
}
