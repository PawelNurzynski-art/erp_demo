package com.erp_demo.controller;

import com.erp_demo.entity.ItemEntity;
import com.erp_demo.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    public ItemRepository itemRepository;

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


    record NewItemRequest (
            String productId,
            double price
    ) {}

    // add item
    @PostMapping("")
    public ItemEntity addItem(@RequestBody NewItemRequest request) {
        ItemEntity item = new ItemEntity();

        item.setProductId(request.productId);
        item.setPrice(request.price);

        itemRepository.save(item);
        return item;
    }


    // delete item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") UUID id) {
        itemRepository.deleteById(id);
    }
}
