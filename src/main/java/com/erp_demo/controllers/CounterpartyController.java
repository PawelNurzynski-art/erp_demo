package com.erp_demo.controllers;

import com.erp_demo.dtos.CounterpartyDto;
import com.erp_demo.entities.CounterpartyEntity;
import com.erp_demo.repositories.CounterpartyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/counterparty")
public class CounterpartyController {
    public CounterpartyRepository counterpartyRepository;
    public CounterpartyDto newCounterparty = new CounterpartyDto();

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


    // adding new counterparty
    @PostMapping("")
    public CounterpartyEntity addCounterparty(@RequestBody CounterpartyDto counterpartyDto) {
        CounterpartyEntity newCounterparty = new CounterpartyEntity();

        newCounterparty.setName(counterpartyDto.getName());
        newCounterparty.setStreet(counterpartyDto.getStreet());
        newCounterparty.setHouseNumber(counterpartyDto.getHouseNumber());
        newCounterparty.setZipCode(counterpartyDto.getZipCode());
        newCounterparty.setCity(counterpartyDto.getCity());
        newCounterparty.setBankAccount(counterpartyDto.getBankAccount());

        counterpartyRepository.save(newCounterparty);
        return newCounterparty;
    }


    // delete counterparty
    @DeleteMapping("/{id}")
    public void deleteCounterparty(@PathVariable("id") UUID id) {
        counterpartyRepository.deleteById(id);
    }


    // update the counterparty
    @PutMapping("/{id}")
    public CounterpartyEntity updateCounterparty(@PathVariable("id") UUID id,
                                   @RequestBody CounterpartyDto counterpartyDto) {
        CounterpartyEntity editedCounterparty = counterpartyRepository.getById(id);

        editedCounterparty.setName(counterpartyDto.getName());
        editedCounterparty.setStreet(counterpartyDto.getStreet());
        editedCounterparty.setHouseNumber(counterpartyDto.getHouseNumber());
        editedCounterparty.setZipCode(counterpartyDto.getZipCode());
        editedCounterparty.setCity(counterpartyDto.getCity());
        editedCounterparty.setBankAccount(counterpartyDto.getBankAccount());

        counterpartyRepository.save(editedCounterparty);
        return editedCounterparty;
    }

}
