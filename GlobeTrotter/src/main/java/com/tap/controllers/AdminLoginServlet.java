package com.tap.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.tap.daoimpl.AdminDaoImpl;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDaoImpl adminDao = new AdminDaoImpl();
        boolean isValidAdmin = adminDao.validateAdmin(username, password);

        if (isValidAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);  // Store admin in session
            response.sendRedirect("admindashboard.jsp"); // Redirect to admin dashboard
        } else {
            request.setAttribute("error", "Invalid Admin Credentials!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}