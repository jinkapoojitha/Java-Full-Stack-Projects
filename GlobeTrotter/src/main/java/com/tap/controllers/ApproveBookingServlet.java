package com.tap.controllers;



import com.tap.daoimpl.BookingDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/approveBookingServlet")
public class ApproveBookingServlet extends HttpServlet {
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        BookingDaoImpl bookingDao = new BookingDaoImpl();

        // Approve the booking by changing its status to 'Confirmed'
        bookingDao.updateBookingStatus(bookingId, "Confirmed");

        // Redirect to the manage bookings page
        response.sendRedirect("manageBookings.jsp");
    }
}