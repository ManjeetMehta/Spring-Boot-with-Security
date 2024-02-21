package com.springboot.security.controller;

import com.springboot.security.models.User;
import com.springboot.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> userList()
    {
        return this.userService.getUserList();
    }

    @PostMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return this.userService.getUser(username);
    }


    @PostMapping("/")
    public User addUser(@RequestBody User user)
    {
        return this.userService.addUser(user);
    }
}
