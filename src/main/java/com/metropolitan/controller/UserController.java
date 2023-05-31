package com.metropolitan.controller;

import com.metropolitan.model.Role;
import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //creating user

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2l);
        role.setRoleName("user");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);

        return ResponseEntity.ok(userService.createUser(user, roles));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    //delete by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
//update


}
