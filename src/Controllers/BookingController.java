package Controllers;

import DAO.BookingDAO;
import DAO.GuestDAO;
import DAO.RoomDAO;
import Models.Booking;
import Models.Guest;
import Models.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "booking", urlPatterns = {"/availableRooms","/Booking"})
public class BookingController extends HttpServlet {

    private BookingDAO booking;
    private RoomDAO roomList;
    private GuestDAO guestList;
    public BookingController(){
        booking = new BookingDAO();
        roomList = new RoomDAO();
        guestList = new GuestDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> rooms;
        List<Guest> guests;

        rooms = roomList.availableRooms();
        guests = guestList.guestList();

        req.setAttribute("roomList",rooms);
        req.setAttribute("guestList", guests);
        RequestDispatcher dispatcher = req.getRequestDispatcher("booking.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        int guestId = Integer.parseInt(req.getParameter("guestId"));
        int numberOfGuest = Integer.parseInt(req.getParameter("numberOfGuests"));
        LocalDate checkinDate = LocalDate.parse(req.getParameter("checkinDate"));
        LocalTime checkinTime = LocalTime.parse(req.getParameter("checkinTime"));
        LocalDate checkoutDate = LocalDate.parse(req.getParameter("checkoutDate"));
        LocalTime checkoutTime = LocalTime.parse(req.getParameter("checkoutTime"));
        Booking book = new Booking(roomId,guestId,numberOfGuest,checkinDate,checkinTime,checkoutDate,checkoutTime);
        boolean result = booking.addBooking(book);
        if (result){
            HttpSession session = req.getSession();
            session.setAttribute("msg", "yes");
            resp.sendRedirect("availableRooms");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/availableRooms");
//            dispatcher.forward(req,resp);
        }else {
            resp.sendRedirect("booking.jsp");
        }
    }
}