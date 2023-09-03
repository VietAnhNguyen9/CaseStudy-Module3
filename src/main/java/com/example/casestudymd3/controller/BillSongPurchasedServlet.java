package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.BillSongsPurchasedDAO;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BillSongPurchasedServlet", value = "/BillSongPurchasedServlet")
public class BillSongPurchasedServlet extends HttpServlet {

    BillSongsPurchasedDAO billSongsPurchasedDAO = new BillSongsPurchasedDAO();

    public void init() {
        billSongsPurchasedDAO = new BillSongsPurchasedDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUserId();

        try {
            List<Map<String, Object>> billSongs = billSongsPurchasedDAO.getBillSongPurchasedByUserId(userId);
            double totalAmount = billSongsPurchasedDAO.getTotalAmountPurchasedByUserId(userId);

            request.setAttribute("billSongs", billSongs);
            request.setAttribute("totalAmount", totalAmount);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/billSongPurchased.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}