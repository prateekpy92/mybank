package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Exceptions.InvalidRequestException;
import com.techlabs.mybank.Model.Branch;
import com.techlabs.mybank.Model.Customers;
import com.techlabs.mybank.Model.Requests;

import java.util.List;
import java.util.Optional;


@Service
public class RequestService {

    @Autowired
    private com.techlabs.mybank.Repository.Requests requestsRepo;

    @Autowired
    private  CustomerService customerService;

    public List<Requests> getALlrequests(){
        return requestsRepo.findAll();
    }

    public Requests add(Requests requests){
        return requestsRepo.save(requests);
    }

    public List<Requests> getRequestsFromCustomer(int id){
        return  requestsRepo.findByCustomers_Id(id);

    }

    public void delete(int id) {
        requestsRepo.deleteById(id);
    }

    public Optional<Requests> getRequestById(int id) {
        // TODO Auto-generated method stub
        return requestsRepo.findById(id);
    }



}
