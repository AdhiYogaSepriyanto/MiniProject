package com.example.MiniProject;

import com.example.MiniProject.User;
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
