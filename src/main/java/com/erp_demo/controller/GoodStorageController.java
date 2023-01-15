package com.erp_demo.controller;

import com.erp_demo.entity.GoodStorageEntity;
import com.erp_demo.repository.GoodStorageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good-storage")
public class GoodStorageController {
    public GoodStorageRepository goodStorageRepository;

    public GoodStorageController(GoodStorageRepository goodStorageRepository) {
        this.goodStorageRepository = goodStorageRepository;
    }


    // displaying all goods in storage
    @GetMapping("")
    public List<GoodStorageEntity> getGoodStorage() {
        return goodStorageRepository.findAll();
    }


    // adding good to storage (buying goods)
    // template
    record addGoodToStorage(
            int goodId,
            int supplierId, // from counterparty
            double quantity,
            String goodBatch
    ) {}
}
