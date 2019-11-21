package Controllers;

import DAO.BookingDAO;
import DAO.GuestDAO;
import Models.Booking;
import Models.Guest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editBookingFormController22", urlPatterns = "/editBookingFormController")

public class editBookingFormController extends HttpServlet {
    BookingDAO bookingDAO;

    public editBookingFormController(){
        bookingDAO = new BookingDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param=req.getQueryString().split("=")[1];
        int id=Integer.parseInt(param);
        Booking editedbooking=bookingDAO.getBookingById(id);
        req.setAttribute("editedbooking",editedbooking);
        RequestDispatcher dispatcher = req.getRequestDispatcher("BookingEdit.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);


    }
}
