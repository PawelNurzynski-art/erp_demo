package com.erp_demo.contractor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counter-party")
public class CounterPartyController {
    public CounterPartyRepository counterPartyRepository;

    public CounterPartyController(CounterPartyRepository counterPartyRepository) {
        this.counterPartyRepository = counterPartyRepository;
    }

    // displaying all contractors
    @GetMapping("")
    public List<CounterParty> getCounterParty() {
        return counterPartyRepository.findAll();
    }

    // adding new contractor
    // template
    record NewCounterPartyRequest(
            String name,
            String street,
            String houseNumber,
            String zipCode,
            String city,
            String bankAccount
    ) {}

    // adding new contractor to database
    @PostMapping("")
    public CounterParty addCounterParty(@RequestBody NewCounterPartyRequest request) {
        CounterParty counterParty = new CounterParty();

        counterParty.setName(request.name);
        counterParty.setStreet(request.street);
        counterParty.setHouseNumber(request.houseNumber);
        counterParty.setZipCode(request.zipCode);
        counterParty.setCity(request.city);
        counterParty.setBankAccount(request.bankAccount);

        counterPartyRepository.save(counterParty);
        return counterParty;
    }


    // delete contractor from database
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
        CounterParty counterParty = counterPartyRepository.getById(id);

        counterParty.setName(request.name);
        counterParty.setStreet(request.street);
        counterParty.setHouseNumber(request.houseNumber);
        counterParty.setZipCode(request.zipCode);
        counterParty.setCity(request.city);
        counterParty.setBankAccount(request.bankAccount);

        counterPartyRepository.save(counterParty);
    }

}
