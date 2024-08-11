package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Admin;
import com.techlabs.mybank.Model.Users;
import com.techlabs.mybank.Repository.UsersRepo;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;
    public Users add(Users users) {
        return usersRepo.save(users);
    }


}
