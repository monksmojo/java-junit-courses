package com.in28minutes.junitMockito.section3.service;

import com.in28minutes.junitMockito.section3.entity.Item;
import com.in28minutes.junitMockito.section3.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getOneItemByService(){
        return new Item(21l,"sanitizer",5,10.00);
    }

    public List<Item> getAllItemFromRepository(){
        List<Item> itemList= (List<Item>) itemRepository.findAll();
        for (Item item:itemList){
            item.setTotalAmount(item.getItemPrice()*item.getItemQuantity());
        }
        return itemList;
    }

    public boolean saveOne(Item item) {
        itemRepository.save(item);
        return true;
    }
}
