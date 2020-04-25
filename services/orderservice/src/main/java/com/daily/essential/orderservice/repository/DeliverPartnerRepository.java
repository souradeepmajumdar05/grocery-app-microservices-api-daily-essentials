package com.daily.essential.orderservice.repository;

import com.daily.essential.orderservice.model.DeliverPartner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverPartnerRepository extends CrudRepository<DeliverPartner,Integer> {
}
