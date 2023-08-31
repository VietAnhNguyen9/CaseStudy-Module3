package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.DAO.impl.LoginDAO;
import com.example.casestudymd3.model.Users;
import com.example.casestudymd3.service.ILogin;

public class LoginService implements ILogin {
    private static LoginService loginService;
    public static LoginService getInstance() {
        if (loginService == null) {
            loginService = new LoginService();
        }
        return loginService;
    }
    LoginDAO loginDAO = LoginDAO.getInstance();

    @Override
    public Users login(String userName, String password) {
        Users user = loginDAO.login(userName, password);
        if (user == null) {
            return null;
        }
        return user;
    }
}
