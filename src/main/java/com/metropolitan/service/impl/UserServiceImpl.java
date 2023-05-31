package com.metropolitan.service.impl;

import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.repository.RoleRepository;
import com.metropolitan.repository.UserRepository;
import com.metropolitan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User local = userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User exist!!!");
            throw new RuntimeException("User exist!!!");
        } else //creating
        {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

//            user.getUserRoles().addAll(userRoles);
            userRepository.save(user);
        }

        return user;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    //delete by id
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
