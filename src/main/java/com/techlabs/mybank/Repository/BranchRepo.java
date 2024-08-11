package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.mybank.Model.Branch;

import java.util.Optional;


public interface BranchRepo extends JpaRepository<Branch,Integer> {
    Optional<com.techlabs.mybank.Model.Branch> findByBranchIfscCode(String code);


    @Transactional
    @Modifying
    @Query("UPDATE Branch b SET b.activeState = :state where b.id =:idd")
    void updateBranchStatus(String state, int idd);
}
