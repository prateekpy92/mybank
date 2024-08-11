package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Requests extends JpaRepository<com.techlabs.mybank.Model.Requests,Integer> {

    List<com.techlabs.mybank.Model.Requests> findByCustomers_Id(int id);
}
