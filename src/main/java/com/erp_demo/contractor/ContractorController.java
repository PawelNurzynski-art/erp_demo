package com.erp_demo.contractor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contractors")
public class ContractorController {
    public ContractorRepository contractorRepository;

    public ContractorController(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    // displaying all contractors
    @GetMapping("")
    public List<Contractor> getContractors() {
        return contractorRepository.findAll();
    }

    // adding new contractor
    // template
    record NewContractorRequest(
            String contractorName,
            String contractorStreet,
            String contractorHouseNumber,
            String contractorZipCode,
            String contractorCity,
            String contractorBankAccount
    ) {}

    // adding new contractor to database
    @PostMapping("")
    public void addContractor(@RequestBody NewContractorRequest request) {
        Contractor contractor = new Contractor();

        contractor.setContractorName(request.contractorName);
        contractor.setContractorStreet(request.contractorStreet);
        contractor.setContractorHouseNumber(request.contractorHouseNumber);
        contractor.setContractorZipCode(request.contractorZipCode);
        contractor.setContractorCity(request.contractorCity);
        contractor.setContractorBankAccount(request.contractorBankAccount);
    }


    // delete contractor from database
    @DeleteMapping("/delete/{contractorId}")
    public void deleteContractor(@PathVariable("contractorId") Integer contractorId) {
        contractorRepository.deleteById(contractorId);
    }


    // update the contractor
    // template
    record UpdateContractorRequest(
            String contractorName,
            String contractorStreet,
            String contractorHouseNumber,
            String contractorZipCode,
            String contractorCity,
            String contractorBankAccount
    ) {}

    // update data in database
    @PutMapping("/update/{contractorId}")
    public void updateContractor(@PathVariable("contractorId") Integer contractorId,
                                 @RequestBody UpdateContractorRequest request) {
        Contractor contractor = contractorRepository.getById(contractorId);

        contractor.setContractorName(request.contractorName);
        contractor.setContractorStreet(request.contractorStreet);
        contractor.setContractorHouseNumber(request.contractorHouseNumber);
        contractor.setContractorZipCode(request.contractorZipCode);
        contractor.setContractorCity(request.contractorCity);
        contractor.setContractorBankAccount(request.contractorBankAccount);
    }

}
