package com.metropolitan.service.impl;

import com.metropolitan.exception.UserFoundException;
import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.repository.RoleRepository;
import com.metropolitan.repository.UserRepository;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User already exists");
            throw new UserFoundException();

        } else {

            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }


    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> data = userRepository.findById(id);
        User _user = data.get();
        _user.setUsername(user.getUsername());
        return userRepository.save(_user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

