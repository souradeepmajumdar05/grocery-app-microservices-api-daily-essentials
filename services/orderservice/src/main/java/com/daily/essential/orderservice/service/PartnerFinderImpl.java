package com.daily.essential.orderservice.service;

import com.daily.essential.orderservice.model.DeliverPartner;
import com.daily.essential.orderservice.repository.DeliverPartnerRepository;
import org.springframework.stereotype.Service;


@Service
public class PartnerFinderImpl {
    DeliverPartnerRepository deliverPartnerRepository;
    PartnerFinderImpl(DeliverPartnerRepository deliverPartnerRepository)
    {
        this.deliverPartnerRepository=deliverPartnerRepository;
    }
    public DeliverPartner getDeliverPartner()
    {
        //This is mocker will always give one output
        //stay tuned for delivery app :) will integrate then
        return deliverPartnerRepository.findById(1).get();
    }
}
