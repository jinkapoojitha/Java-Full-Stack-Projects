package com.tap.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.tap.daoimpl.UserDaoImpl;

@WebServlet("/toggleUserStatusServlet")
public class ToggleUserStatusServlet extends HttpServlet {
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.toggleUserStatus(userId);
        response.sendRedirect("manageUsers.jsp");
    }
}