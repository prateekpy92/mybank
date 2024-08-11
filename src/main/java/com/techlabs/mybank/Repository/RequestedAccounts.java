package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.mybank.Model.Customers;

import java.util.List;
import java.util.Optional;

public interface RequestedAccounts extends JpaRepository<com.techlabs.mybank.Model.RequestedAccounts,Integer> {
    Optional<com.techlabs.mybank.Model.RequestedAccounts> findRequestedAccountsByAdhaarNo(long adhar);
    Optional<com.techlabs.mybank.Model.RequestedAccounts> findRequestedAccountsByPanNo(String panNo);


}
