package com.metropolitan.service.imp;

import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.repository.RoleRepository;
import com.metropolitan.repository.UserRepository;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User exist!!!");
            throw new Exception("User exist!!!");
        } else //creating
        {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //delete by id
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
