package com.graphQl.user.graphQl_User.service;

import com.graphQl.user.graphQl_User.entity.User;
import com.graphQl.user.graphQl_User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
