package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Admin;
import com.techlabs.mybank.Model.Branch;
import com.techlabs.mybank.Model.Customers;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private com.techlabs.mybank.Repository.Customers customersRepo;

    @Autowired
    private BranchService branchService;

    public List<Customers> getAllCustomers(){
        return customersRepo.findAll();
    }

    public Customers add(Customers admin) {
        return customersRepo.save(admin);
    }

    public void delete(int id) {
        customersRepo.deleteById(id);
    }

    public Optional<Customers> getCustomerById(int id) {
        // TODO Auto-generated method stub
        return customersRepo.findById(id);
    }

    public Optional<Customers> getCustomerByAccNo(String acc){
       return customersRepo.findByAccNO(acc);
    }


    public List<Customers> getCustomerByBranch(int id){
        return customersRepo.findByBranch_Id(id);
    }

    public Customers update(Customers customers) {
        // TODO Auto-generated method stub
        return customersRepo.save(customers);
    }

    public int noOfCustomers(){
        return getAllCustomers().size();
    }


}
