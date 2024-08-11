package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.SelfTransactions;

import java.util.List;
import java.util.Optional;

@Service
public class SelfTransactionService {

    @Autowired
    private com.techlabs.mybank.Repository.SelfTransactions selfTransactionsRepo;

    public List<SelfTransactions> getALlTransactions(){
        return selfTransactionsRepo.findAll();
    }


    public SelfTransactions add(SelfTransactions selfTransactions) {
        return selfTransactionsRepo.save(selfTransactions);
    }


    public Optional<SelfTransactions> getTransactionsById(int id) {
        // TODO Auto-generated method stub
        return selfTransactionsRepo.findById(id);
    }

    public List<SelfTransactions> depositedMoney(String accNo){
        return selfTransactionsRepo.depositedMoney(accNo,"deposit");
    }
    public List<SelfTransactions> withdrawalMoney(String accNo){
        return selfTransactionsRepo.depositedMoney(accNo,"withdrawal");
    }
}
