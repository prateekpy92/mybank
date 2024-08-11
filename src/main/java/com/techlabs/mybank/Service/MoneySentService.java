package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.MoneySentReceived;
import com.techlabs.mybank.Repository.MoneySentReceivedRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MoneySentService {

    @Autowired
    private MoneySentReceivedRepo moneySentReceivedRepo;

    public List<MoneySentReceived> getAllMoneySentReceived(){
        return moneySentReceivedRepo.findAll();
    }

    public MoneySentReceived add(MoneySentReceived moneySentReceived) {
        return moneySentReceivedRepo.save(moneySentReceived);
    }

    public void delete(int id) {
        moneySentReceivedRepo.deleteById(id);
    }

    public Optional<MoneySentReceived> getMoneySentReceivedById(int id) {
        // TODO Auto-generated method stub
        return moneySentReceivedRepo.findById(id);
    }

    public List<MoneySentReceived> getMoneySentByAccNo(String accNo){
        return moneySentReceivedRepo.moneySent(accNo);
    }
    public List<MoneySentReceived> getMoneyReceivedByAccNo(String accNo){
        return moneySentReceivedRepo.moneyReceived(accNo);
    }
}
