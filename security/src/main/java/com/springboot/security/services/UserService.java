package com.springboot.security.services;

import com.springboot.security.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    public List<User> userList = new ArrayList <>();

    public UserService()
    {
        userList.add(new User("arun", "kumar", "arun.kumar@gmail.com"));
        userList.add(new User("kawin", "prabhakaran", "kawin.prabhakaran@gmail.com"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(String username)
    {
        return this.userList.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }
    public User addUser (User user)
    {
        this.userList.add(user);
        return user;
    }
}
