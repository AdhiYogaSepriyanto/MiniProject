package com.example.MiniProject;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}