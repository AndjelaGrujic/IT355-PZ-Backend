package com.metropolitan.service;

import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;

import java.util.Set;

public interface UserService {


    //creating user
    public User createUser(User user, Set<UserRole>userRoles) throws Exception;
    //get user by username
    public User getUser(String username);

    //delete by id
    public void deleteUser(Long userId);
}
