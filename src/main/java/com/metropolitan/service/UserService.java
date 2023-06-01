package com.metropolitan.service;

import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public List<User> getAllUser();

    public User updateUser(User user,Long id);

    public void deleteUser(Long id);

}
