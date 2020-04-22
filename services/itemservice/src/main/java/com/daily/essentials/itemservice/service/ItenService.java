package com.daily.essentials.itemservice.service;

import com.daily.essentials.itemservice.model.Item;
import com.daily.essentials.itemservice.model.Itemcatalog;

import java.util.List;

public interface ItenService
{
    public List<Item> getAllItems();
    public Item getItemByid(long itemId);
    public Item checkItemAvailability();
    public Item addNewItem(Item item);
    public Itemcatalog addNewItemCatalog(Itemcatalog itemcatalog);
    Item getItemAvailableByid(long itemId);
}
