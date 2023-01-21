package com.arman.build.service;

import com.arman.build.models.Item;
import com.arman.build.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    @Autowired
    private ItemsRepository repository;

    public Item addItem(Item item){
        item.setId(UUID.randomUUID().toString());
        return repository.save(item);
    }

    public List<Item> index(){
        return repository.findAll();
    }

    public Item getItemById(String id){
        return repository.findById(id).get();
    }

    public Item updateItem(Item newItem){
        Item currentItem = repository.findById(newItem.getId()).get();
        currentItem.setName(newItem.getName());
        currentItem.setCost(newItem.getCost());
        currentItem.setService(newItem.getService());
        currentItem.setCategory(newItem.getCategory());
        currentItem.setDescription(newItem.getDescription());
        currentItem.setLocation(newItem.getLocation());
        return repository.save(currentItem);
    }

    public String deleteItem(String id){
        repository.deleteById(id);
        return "Item with id " + id + " was deleted";
    }


}
