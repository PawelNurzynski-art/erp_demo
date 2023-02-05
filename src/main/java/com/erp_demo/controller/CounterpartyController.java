package com.erp_demo.controller;

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



    // adding new counterParty
    // template
    record NewCounterPartyRequest(
            String name,
            String street,
            String houseNumber,
            String zipCode,
            String city,
            String bankAccount
    ) {}

    // adding new counterParty to database
    @PostMapping("")
    public CounterpartyEntity addCounterparty(@RequestBody NewCounterPartyRequest request) {
        CounterpartyEntity counterparty = new CounterpartyEntity();

        counterparty.setName(request.name);
        counterparty.setStreet(request.street);
        counterparty.setHouseNumber(request.houseNumber);
        counterparty.setZipCode(request.zipCode);
        counterparty.setCity(request.city);
        counterparty.setBankAccount(request.bankAccount);

        counterpartyRepository.save(counterparty);
        return counterparty;
    }


    // delete counterParty from database
    @DeleteMapping("/{id}")
    public void deleteCounterparty(@PathVariable("id") UUID id) {
        counterpartyRepository.deleteById(id);
    }


    // update the contractor
    // template
    record UpdateCounterPartyRequest(
            String name,
            String street,
            String houseNumber,
            String zipCode,
            String city,
            String bankAccount
    ) {}

    // update data in database
    @PutMapping("/{id}")
    public void updateCounterparty(@PathVariable("id") UUID id,
                                   @RequestBody UpdateCounterPartyRequest request) {
        CounterpartyEntity counterparty = counterpartyRepository.getById(id);

        counterparty.setName(request.name);
        counterparty.setStreet(request.street);
        counterparty.setHouseNumber(request.houseNumber);
        counterparty.setZipCode(request.zipCode);
        counterparty.setCity(request.city);
        counterparty.setBankAccount(request.bankAccount);

        counterpartyRepository.save(counterparty);
    }

}
