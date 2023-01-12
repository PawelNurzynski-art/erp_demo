package com.erp_demo.controller;

import com.erp_demo.entity.CounterpartyEntity;
import com.erp_demo.repository.CounterpartyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counter-party")
public class CounterpartyController {
    public CounterpartyRepository counterPartyRepository;

    public CounterpartyController(CounterpartyRepository counterPartyRepository) {
        this.counterPartyRepository = counterPartyRepository;
    }

    // displaying all counterParty
    @GetMapping("")
    public List<CounterpartyEntity> getCounterParty() {
        return counterPartyRepository.findAll();
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
    public CounterpartyEntity addCounterParty(@RequestBody NewCounterPartyRequest request) {
        CounterpartyEntity counterParty = new CounterpartyEntity();

        counterParty.setName(request.name);
        counterParty.setStreet(request.street);
        counterParty.setHouseNumber(request.houseNumber);
        counterParty.setZipCode(request.zipCode);
        counterParty.setCity(request.city);
        counterParty.setBankAccount(request.bankAccount);

        counterPartyRepository.save(counterParty);
        return counterParty;
    }


    // delete counterParty from database
    @DeleteMapping("/delete/{id}")
    public void deleteCounterParty(@PathVariable("id") Integer id) {
        counterPartyRepository.deleteById(id);
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
    @PutMapping("/update/{id}")
    public void updateCounterParty(@PathVariable("id") Integer id,
                                 @RequestBody UpdateCounterPartyRequest request) {
        CounterpartyEntity counterParty = counterPartyRepository.getById(id);

        counterParty.setName(request.name);
        counterParty.setStreet(request.street);
        counterParty.setHouseNumber(request.houseNumber);
        counterParty.setZipCode(request.zipCode);
        counterParty.setCity(request.city);
        counterParty.setBankAccount(request.bankAccount);

        counterPartyRepository.save(counterParty);
    }

}
