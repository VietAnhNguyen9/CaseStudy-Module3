package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.DAO.impl.AlbumDAO;
import com.example.casestudymd3.DAO.impl.SongDAO;
import com.example.casestudymd3.DAO.impl.UserDAO;
import com.example.casestudymd3.model.Users;

import javax.servlet.http.HttpServletRequest;
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
    public void deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        SongDAO.getInstance().deleteByUser(id);
        UserDAO.getInstance().delete(id);
    }
}
