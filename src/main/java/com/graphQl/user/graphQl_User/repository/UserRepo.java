package com.graphQl.user.graphQl_User.repository;

import com.graphQl.user.graphQl_User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
