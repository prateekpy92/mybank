package com.techlabs.mybank.Security;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Users;
import com.techlabs.mybank.Repository.UsersRepo;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.Entity;


@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	Optional<Users> users = usersRepo.findByUserName(userName);
    	System.out.println(users);
		return users.map(SecurityUsersDetails::new).get();
    }

}
