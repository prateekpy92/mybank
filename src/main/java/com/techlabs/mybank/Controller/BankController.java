package com.techlabs.mybank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.techlabs.mybank.Exceptions.InvalidRequestException;
import com.techlabs.mybank.Model.Bank;
import com.techlabs.mybank.Service.BankService;
import com.techlabs.mybank.Service.CustomerService;


@RestController
public class BankController{

    @Autowired
    private BankService bankService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/noOfbranches")
    public int noOfBranches(){
        return bankService.noOfBranches();
    }

    @GetMapping("/mybank")
    public Bank getBank() {
        if (!bankService.getBankById(1).isPresent()) {
            throw new InvalidRequestException("Bank not exists");
        }
        return bankService.getBankById(1).get();
    }

    @PostMapping("/add/bank")
    public Bank add(@RequestBody Bank bank){
        bank.setNoOfBranches(noOfBranches());
        bank.setNoOfCustomers(customerService.noOfCustomers());
        return bankService.add(bank);
    }

    @PutMapping("/update/bank")
    public Bank updateInfo(@RequestBody Bank bank ) {
        if(bankService.getBankById(1).isPresent()) {
            bank.setId(1);
            return bankService.update(bank);
        }
        else {
            throw new InvalidRequestException("Bank not exists");
        }
    }

}
