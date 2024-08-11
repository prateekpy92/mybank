package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Admin;
import com.techlabs.mybank.Model.Bank;
import com.techlabs.mybank.Repository.BankRepo;
import com.techlabs.mybank.Repository.Customers;

import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private BankRepo bankRepo ;

    @Autowired
    private BranchService branchService ;
    @Autowired
    private  CustomerService customerService;

    @Autowired
    Customers customers;

    public Bank add(Bank bank){
            return bankRepo.save(bank);
    }
    public Optional<Bank> getBankById(int id) {
        return bankRepo.findById(id);
    }
    public Bank update(Bank bank) {
        return bankRepo.save(bank);
    }
    public int noOfBranches(){
        return branchService.getAllBranch().size();
    }
    public int noOfCustomersforDisplay(){
        return customers.findAll().size();
    }

}
