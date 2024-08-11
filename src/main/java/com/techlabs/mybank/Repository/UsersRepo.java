package com.techlabs.mybank.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techlabs.mybank.Model.Users;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
    Optional<Users> findByUserName(String userName);
}
