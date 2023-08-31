package com.example.casestudymd3.service;

import com.example.casestudymd3.model.Users;

public interface ILogin {
    Users login(String userName, String password);
}
