package com.erp_demo.controller;

import com.erp_demo.entity.GoodEntity;
import com.erp_demo.entity.GoodStorageEntity;
import com.erp_demo.repository.GoodStorageRepository;
import org.springframework.web.bind.annotation.*;

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
    // or updating good in storage
    // template
    record GoodToStorageRequest(
            GoodEntity goodId, // from GoodEntity
            int supplierId, // from CounterpartyEntity
            double quantity,
            String goodBatch,
            int invoiceId // from InvoiceEntity
    ) {}


    // adding new good to storage in database
    @PostMapping("")
    public GoodStorageEntity addGoodToStorage(@RequestBody GoodToStorageRequest request) {
        GoodStorageEntity good = new GoodStorageEntity();

        good.setGoodId(request.goodId);
        good.setSupplierId(request.supplierId);
        good.setQuantity(request.quantity);
        good.setGoodBatch(request.goodBatch);
        good.setInvoiceId(request.invoiceId);

        goodStorageRepository.save(good);
        return good;
    }


    // deleting good from storage in database
    @DeleteMapping("/delete/{id}")
    public void deleteGoodFromStorage(@PathVariable("id") Integer id) {
        goodStorageRepository.deleteById(id);
    }


    // updating good in database
    @PutMapping("/update/{id}")
    public void updateGoodInStorage(@PathVariable("id") Integer id,
                           @RequestBody GoodToStorageRequest request) {
        GoodStorageEntity good = goodStorageRepository.getById(id);

        good.setGoodId(request.goodId);
        good.setSupplierId(request.supplierId);
        good.setQuantity(request.quantity);
        good.setGoodBatch(request.goodBatch);
        good.setInvoiceId(request.invoiceId);

        goodStorageRepository.save(good);
    }
}
