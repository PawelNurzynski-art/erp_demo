package com.erp_demo.controller;

import com.erp_demo.entity.CurrencyEntity;
import com.erp_demo.repository.CurrencyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    public CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    // display all currencies
    @GetMapping("")
    public List<CurrencyEntity> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    // add currency
    // template
    record CurrencyRequest(
            String currencyName,
            String currencyAbbreviation,
            int currencyState
    ) {}

    // add currency to database
    @PostMapping("")
    public CurrencyEntity addCurrency(@RequestBody CurrencyRequest request) {
        CurrencyEntity currency = new CurrencyEntity();

        currency.setCurrencyName(request.currencyName);
        currency.setCurrencyAbbreviation(request.currencyAbbreviation);
        currency.setCurrencyState(request.currencyState);

        currencyRepository.save(currency);
        return currency;
    }

    // delete currency
    @DeleteMapping("/delete/{id}")
    public void deleteCurrency(@PathVariable("id") Integer id) {
        currencyRepository.deleteById(id);
    }

    // update currency
    @PutMapping("/update/{id}")
    public void updateCurrency(@PathVariable("id") Integer id,
                                         @RequestBody CurrencyRequest request) {
        CurrencyEntity currency = currencyRepository.getById(id);

        currency.setCurrencyName(request.currencyName);
        currency.setCurrencyAbbreviation(request.currencyAbbreviation);
        currency.setCurrencyState(request.currencyState);

        currencyRepository.save(currency);
    }
}
