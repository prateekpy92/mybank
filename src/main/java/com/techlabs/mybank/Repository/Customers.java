package com.techlabs.mybank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Customers extends JpaRepository<com.techlabs.mybank.Model.Customers,Integer> {

    Optional<com.techlabs.mybank.Model.Customers> findByAccNO(String acc);

    List<com.techlabs.mybank.Model.Customers> findByBranch_Id(int id);
}
