package com.erp_demo.controller;

import com.erp_demo.dto.CounterpartyDTO;
import com.erp_demo.entity.CounterpartyEntity;
import com.erp_demo.repository.CounterpartyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/counterparty")
public class CounterpartyController {
    public CounterpartyRepository counterpartyRepository;

    public CounterpartyController(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    // displaying all counterparty
    @GetMapping("")
    public List<CounterpartyEntity> getAllCounterparty() {
        return counterpartyRepository.findAll();
    }


    // displaying counterparty chosen by id
    @GetMapping("/{id}")
    public Optional<CounterpartyEntity> getCounterparty(@PathVariable("id") UUID id) {
        return counterpartyRepository.findById(id);
    }

    // to add and update counterparty
    CounterpartyDTO newCounterparty = new CounterpartyDTO();

    // adding new counterparty
    @PostMapping("")
    public CounterpartyEntity addCounterparty(@RequestBody CounterpartyDTO newCounterparty) {
        CounterpartyEntity counterparty = new CounterpartyEntity();

        counterparty.setName(newCounterparty.getName());
        counterparty.setStreet(newCounterparty.getStreet());
        counterparty.setHouseNumber(newCounterparty.getHouseNumber());
        counterparty.setZipCode(newCounterparty.getZipCode());
        counterparty.setCity(newCounterparty.getCity());
        counterparty.setBankAccount(newCounterparty.getBankAccount());

        counterpartyRepository.save(counterparty);
        return counterparty;
    }


    // delete counterparty
    @DeleteMapping("/{id}")
    public void deleteCounterparty(@PathVariable("id") UUID id) {
        counterpartyRepository.deleteById(id);
    }


    // update the counterparty
    @PutMapping("/{id}")
    public void updateCounterparty(@PathVariable("id") UUID id,
                                   @RequestBody CounterpartyDTO newCounterparty) {
        CounterpartyEntity counterparty = counterpartyRepository.getById(id);

        counterparty.setName(newCounterparty.getName());
        counterparty.setStreet(newCounterparty.getStreet());
        counterparty.setHouseNumber(newCounterparty.getHouseNumber());
        counterparty.setZipCode(newCounterparty.getZipCode());
        counterparty.setCity(newCounterparty.getCity());
        counterparty.setBankAccount(newCounterparty.getBankAccount());

        counterpartyRepository.save(counterparty);
    }

}
