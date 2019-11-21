package Controllers;

import DAO.BookingDAO;
import DAO.GuestDAO;
import Models.Booking;
import Models.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "UpdateGuestController22", urlPatterns = "/UpdateGuestController")

public class UpdateBookingController extends HttpServlet {
   BookingDAO bookingDAO;
    public UpdateBookingController(){
        bookingDAO = new BookingDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("updateid"));
        int roomId=Integer.parseInt(req.getParameter("roomId"));
        int numberOfGuests=Integer.parseInt(req.getParameter("numberOfGuests"));
        LocalDate checkinDate=LocalDate.parse(req.getParameter("checkinDate"));
        LocalTime checkIntime=LocalTime.parse(req.getParameter("checkinTime"));
        LocalDate checkOutdate=LocalDate.parse(req.getParameter("checkoutDate"));
        LocalTime checkOuttime=LocalTime.parse(req.getParameter("checkoutTime"));
        Booking booking=bookingDAO.getBookingById(id);
        Booking b =new Booking(booking.getId(),roomId,booking.getGuestId(),numberOfGuests,checkinDate,checkIntime,checkOutdate,checkOuttime);
        Booking result=bookingDAO.editBooking(b);
        //boolean result=guestDAO.addGuest(g);
        if (result!=null){
            HttpSession session = req.getSession();
            session.setAttribute("msg", "yes");
            resp.sendRedirect("/RentAndRest/getAllBookingController");
        }else {
            resp.sendRedirect("BookingEdit.jsp");
        }





    }
}
