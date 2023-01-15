package com.erp_demo.controller;

import com.erp_demo.entity.GoodEntity;
import com.erp_demo.repository.GoodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    public GoodRepository goodRepository;

    public GoodController(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }


    // displaying all goods
    @GetMapping("")
    public List<GoodEntity> getGood() {
        return goodRepository.findAll();
    }


    // adding new good
    // template
    record NewGoodRequest(
            String name,
            String measureUnit,
            double purchasePrice,
            double margin,
            int definitionState, // 1 - new, 2 - approved, 3 - canceled, 4 - archival
            String description
    ) {}


    // adding new good to database
    @PostMapping("")
    public GoodEntity addGood(@RequestBody NewGoodRequest request) {
        GoodEntity good = new GoodEntity();

        good.setName(request.name);
        good.setDescription(request.description);
        good.setPurchasePrice(request.purchasePrice);
        good.setMeasureUnit(request.measureUnit);
        good.setMargin(request.margin);
        good.setDefinitionState(request.definitionState);

        goodRepository.save(good);
        return good;
    }


    // deleting good from database
    @DeleteMapping("/delete/{id}")
    public void deleteGood(@PathVariable("id") Integer id) {
        goodRepository.deleteById(id);
    }


    // adding new good
    // template
    record UpdateGoodRequest(
            String name,
            String measureUnit,
            double purchasePrice,
            double margin,
            int definitionState, // 1 - new, 2 - approved, 3 - canceled, 4 - archival
            String description
    ) {}


    // updating good in database
    @PutMapping("/update/{id}")
    public void updateGood(@PathVariable("id") Integer id,
                           @RequestBody UpdateGoodRequest request) {
        GoodEntity good = goodRepository.getById(id);

        good.setName(request.name);
        good.setDescription(request.description);
        good.setPurchasePrice(request.purchasePrice);
        good.setMeasureUnit(request.measureUnit);
        good.setMargin(request.margin);
        good.setDefinitionState(request.definitionState);

        goodRepository.save(good);
    }
}
