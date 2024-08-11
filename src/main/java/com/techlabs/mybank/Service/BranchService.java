package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Branch;
import com.techlabs.mybank.Model.Customers;
import com.techlabs.mybank.Repository.BranchRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private com.techlabs.mybank.Repository.Customers customers;

    public List<Branch> getAllBranch(){
        return branchRepo.findAll();
    }

    public Branch add(Branch admin) {
        return  branchRepo.save(admin);
    }

    public void delete(int id) {
        branchRepo.deleteById(id);
    }

    public Optional<Branch> getBranchById(int id) {
        // TODO Auto-generated method stub
        return branchRepo.findById(id);
    }
    public Branch update(Branch branch) {
        // TODO Auto-generated method stub
        return branchRepo.save(branch);
    }

    public Optional<Branch> getBranchByIfscCode(String code){
       return branchRepo.findByBranchIfscCode(code);
    }

    public List<Customers> getCustomerFromBranchId(int id){
        return customers.findByBranch_Id(id);
    }

    public void deactivate(int id){
        branchRepo.updateBranchStatus("deactivated",id);
    }

    public void activate(int id){
        branchRepo.updateBranchStatus("active",id);
    }
}
