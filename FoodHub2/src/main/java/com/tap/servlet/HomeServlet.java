package com.tap.servlet;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

@WebServlet("/CallHomeServlet")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOImpl resDAOImpl = new RestaurantDAOImpl();
		List<Restaurant> ls = resDAOImpl.getAllRestaurants();

		req.setAttribute("restaurants", ls);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}

}
