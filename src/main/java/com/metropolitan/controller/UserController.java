package com.metropolitan.controller;

import com.metropolitan.model.Role;
import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("normal");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}

