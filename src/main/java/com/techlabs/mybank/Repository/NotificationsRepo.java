package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.mybank.Model.Notifications;

import java.util.List;

public interface NotificationsRepo extends JpaRepository<Notifications,Integer> {
    @Transactional
    @Modifying
    @Query("SELECT n FROM Notifications n WHERE  n.customers.accNO=:accNo")
    List<com.techlabs.mybank.Model.Notifications> getNotificationByAccNo (String accNo);

    @Transactional
    @Modifying
    @Query("SELECT n FROM Notifications n WHERE  n.customers.accNO=:accNo and  n.status=:state")
    List<com.techlabs.mybank.Model.Notifications> getNotificationByAccNoAndUnseen (String accNo,String state);

    @Transactional
    @Modifying
    @Query("UPDATE Notifications n SET n.status = :state where n.id =:idd")
    int seen (int idd,String state) ;
}
