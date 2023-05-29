package com.metropolitan;


import com.metropolitan.model.Role;
import com.metropolitan.model.User;
import com.metropolitan.model.UserRole;
import com.metropolitan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class It3554410Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(It3554410Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START");
//
//        User user = new User();
//
//        user.setFirstName("Test");
//        user.setLastName("Testic");
//        user.setUsername("Testo");
//        user.setPassword("abc");
//        user.setEmail("test@gmail.com");
//        user.setProfile("defaul.png");
//
//        Role role1 = new Role();
//        role1.setRoleId(1L);
//        role1.setRoleName("user");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//        userRole.setRole(role1);
//        userRole.setUser(user);
//        userRoleSet.add(userRole);
//
//        User user1 = this.userService.createUser(user, userRoleSet);
//        System.out.println(user1.getUsername());

    }


}
