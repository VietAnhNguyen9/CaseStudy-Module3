package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.DAO.impl.AlbumDAO;
import com.example.casestudymd3.DAO.impl.UserDAO;
import com.example.casestudymd3.model.Users;

import java.util.List;

public class SingerService {
    private static SingerService singerservice;

    public static SingerService getInstance() {
        if (singerservice == null) {
            singerservice = new SingerService();
        }
        return singerservice;
    }
    public List<Users> findSinger(){
        return UserDAO.getInstance().findSinger();
    }
}
