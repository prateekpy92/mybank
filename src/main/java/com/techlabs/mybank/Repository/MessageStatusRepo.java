package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.mybank.Model.ApplicationStatus;
import com.techlabs.mybank.Model.MessageStatus;

import java.util.List;

public interface MessageStatusRepo extends JpaRepository<MessageStatus,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE MessageStatus m SET m.status = :state where m.id =:idd")
    int updateMessageStatus(String state , int idd);

    MessageStatus findMessageStatusByRequests_Id(int id);

    @Transactional
    @Modifying
    @Query("SELECT m FROM MessageStatus m WHERE  m.status=:state")
    List<MessageStatus> search(String state);
}
