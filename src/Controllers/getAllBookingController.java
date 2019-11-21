package Controllers;

import DAO.BookingDAO;
import Models.Booking;
import Models.Guest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAllBookingController22", urlPatterns = "/getAllBookingController")

public class getAllBookingController  extends HttpServlet {
    BookingDAO bookingDAO;

    public getAllBookingController() {

        bookingDAO = new BookingDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Booking> bookings = bookingDAO.getAllBooking();
        req.setAttribute("bookings", bookings);
        RequestDispatcher rd = req.getRequestDispatcher("/booking-List.jsp");
        rd.forward(req, resp);


    }

}
