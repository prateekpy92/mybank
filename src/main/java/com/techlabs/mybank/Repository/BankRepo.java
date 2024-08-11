package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.mybank.Model.Bank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BankRepo extends JpaRepository<com.techlabs.mybank.Model.Bank,Integer> {

}
