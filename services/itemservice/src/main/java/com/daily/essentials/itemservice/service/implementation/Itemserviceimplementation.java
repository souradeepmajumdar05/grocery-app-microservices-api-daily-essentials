package com.daily.essentials.itemservice.service.implementation;

import com.daily.essentials.itemservice.model.Item;
import com.daily.essentials.itemservice.model.Itemcatalog;
import com.daily.essentials.itemservice.repository.ItemCatalogRepository;
import com.daily.essentials.itemservice.repository.ItemRepository;
import com.daily.essentials.itemservice.service.ItenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Itemserviceimplementation implements ItenService {
    ItemRepository itemRepository;
    ItemCatalogRepository itemCatalogRepository;

    Itemserviceimplementation(ItemRepository itemRepository, ItemCatalogRepository itemCatalogRepository )
    {
        this.itemCatalogRepository=itemCatalogRepository;
        this.itemRepository=itemRepository;
    }
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAllInstock();
    }

    @Override
    public Item getItemByid(long itemId) {
        return itemRepository.findItemById(itemId);
    }

    @Override
    public Item checkItemAvailability() {
        return null;
    }

    @Override
    public Item addNewItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Itemcatalog addNewItemCatalog(Itemcatalog itemcatalog) {
        return itemCatalogRepository.save(itemcatalog);
    }

    @Override
    public Item getItemAvailableByid(long itemId) {
        return itemRepository.findItemAvailableBy(itemId);
    }
}
