package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Notifications;
import com.techlabs.mybank.Model.StatusOptions;
import com.techlabs.mybank.Repository.NotificationsRepo;

import java.util.List;
import java.util.Optional;


@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepo notificationsRepo;

    public List<Notifications> getNotificationByAcc(String accNo){
        return notificationsRepo.getNotificationByAccNo(accNo);
    }

    public List<Notifications> getNotificationByAccAndUnseen(String accNo){
        return notificationsRepo.getNotificationByAccNoAndUnseen(accNo, String.valueOf(StatusOptions.UNSEEN));
    }


    public List<Notifications> getALlNotifications(){
        return notificationsRepo.findAll();
    }

    public Notifications add(Notifications notifications){
        return notificationsRepo.save(notifications);
    }

    public void delete(int id) {
        notificationsRepo.deleteById(id);
    }

    public Optional<Notifications> getNotificationById(int id) {
        // TODO Auto-generated method stub
        return notificationsRepo.findById(id);
    }

    public void seen(int id){
        notificationsRepo.seen(id, String.valueOf(StatusOptions.SEEN));
    }

}
