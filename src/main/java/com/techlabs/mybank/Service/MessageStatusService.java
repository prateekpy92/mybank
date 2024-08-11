package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.MessageStatus;
import com.techlabs.mybank.Model.StatusOptions;

import java.util.List;
import java.util.Optional;


@Service
public class MessageStatusService {

    @Autowired
    private com.techlabs.mybank.Repository.MessageStatusRepo messageStatusRepo;

    public List<MessageStatus> getAllStatus(){
        return messageStatusRepo.findAll();
    }

    public List<MessageStatus> getAllStatusUnderReview(){
        return messageStatusRepo.search(String.valueOf(StatusOptions.UNDER_REVIEW));
    }
    public List<MessageStatus> getAllStatusUnderProcessing(){
        return messageStatusRepo.search(String.valueOf(StatusOptions.UNDER_PROCESSING));
    }


    public void add(MessageStatus messageStatus) {
         messageStatusRepo.save(messageStatus);
    }

    public void delete(int id) {
        messageStatusRepo.deleteById(id);
    }

    public Optional<MessageStatus> getApplicationStatusById(int id) {
        return messageStatusRepo.findById(id);
    }
    public MessageStatus update(MessageStatus messageStatus) {
        return messageStatusRepo.save(messageStatus);

    }

    public MessageStatus getMessageStatusByCusId(int id){
       return  messageStatusRepo.findMessageStatusByRequests_Id(id);
    }




}
