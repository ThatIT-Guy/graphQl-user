package com.graphQl.user.graphQl_User.service;

import com.graphQl.user.graphQl_User.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getAllUsers();
}
