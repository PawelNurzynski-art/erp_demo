package com.erp_demo.controllers;

import com.erp_demo.dtos.ItemDto;
import com.erp_demo.entities.ItemEntity;
import com.erp_demo.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    public ItemRepository itemRepository;
    public ItemDto newItem = new ItemDto();

    // constructor
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    // display all items
    @GetMapping("")
    public List<ItemEntity> getAllItem() {
        return itemRepository.findAll();
    }


    // display item chosen by id
    @GetMapping("/{id}")
    public Optional<ItemEntity> getItem(@PathVariable("id") UUID id) {
        return itemRepository.findById(id);
    }


    // add item
    @PostMapping("")
    public ItemEntity addItem(@RequestBody ItemDto newItem) {
        ItemEntity item = new ItemEntity();

        item.setProduct(newItem.getProduct());
        item.setColor(newItem.getColor());
        item.setProductionYear(newItem.getProductionYear());
        item.setEngineCapacity(newItem.getEngineCapacity());
        item.setPrice(newItem.getPrice());

        itemRepository.save(item);
        return item;
    }


    // delete item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") UUID id) {
        itemRepository.deleteById(id);
    }
}
