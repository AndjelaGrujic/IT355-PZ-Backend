package com.metropolitan.controller;

import com.metropolitan.model.Role;
import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    //creating user

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2l);
        role.setRoleName("user");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //delete by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }
//update


}
