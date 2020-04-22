package com.daily.essentials.itemservice.repository;

import com.daily.essentials.itemservice.model.Itemcatalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCatalogRepository extends CrudRepository <Itemcatalog,Integer> {
}
