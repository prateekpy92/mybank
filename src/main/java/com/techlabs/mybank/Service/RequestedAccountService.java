package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Admin;
import com.techlabs.mybank.Model.RequestedAccounts;

import java.util.List;
import java.util.Optional;

@Service
public class RequestedAccountService {

    @Autowired
    private com.techlabs.mybank.Repository.RequestedAccounts customersRepo;

    public List<RequestedAccounts> getAllCustomers(){
        return customersRepo.findAll();
    }

    public RequestedAccounts add(RequestedAccounts requestedAccounts) {
        customersRepo.save(requestedAccounts);
        return requestedAccounts;
    }

    public void delete(int id) {
        customersRepo.deleteById(id);
    }

    public Optional<RequestedAccounts> getRequestedAccountsById(int id) {
        // TODO Auto-generated method stub
        return customersRepo.findById(id);
    }

    public Optional<RequestedAccounts> getRequestedAccountsByAdharNo(long adhar) {
        // TODO Auto-generated method stub
        return  customersRepo.findRequestedAccountsByAdhaarNo(adhar);
    }
    public Optional<RequestedAccounts> getRequestedAccountsByPanNo(String pan) {
        return customersRepo.findRequestedAccountsByPanNo(pan);
    }

    public RequestedAccounts update(RequestedAccounts req) {
        // TODO Auto-generated method stub
        return customersRepo.save(req);
    }
}
