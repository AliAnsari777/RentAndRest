package Controllers;

import DAO.BookingDAO;
import DAO.GuestDAO;
import DAO.RoomDAO;
import Models.Booking;
import Models.BookingListData;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "Book", urlPatterns = {"/emptyRooms", "/book", "/daily-bookings"})
public class BookController extends HttpServlet {

    RoomDAO roomList;
    GuestDAO guestList;
    BookingDAO booking;
    public BookController(){
        roomList = new RoomDAO();
        guestList = new GuestDAO();
        booking = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = ((HttpServletRequest)req).getRequestURL().toString();
        String uri = ((HttpServletRequest)req).getRequestURI().toString();
//            String queryString = ((HttpServletRequest)req).getQueryString();
        System.out.println("uri " + uri);
        String page = uri.substring(uri.lastIndexOf('/'));
        System.out.println(page);

        switch (page){
            case ("/emptyRooms"):
                List<Room> rooms;
                List<Guest> guests;

                rooms = roomList.availableRooms();
                guests = guestList.guestList();

                req.setAttribute("roomList",rooms);
                req.setAttribute("guestList", guests);
                RequestDispatcher dispatcher = req.getRequestDispatcher("booking.jsp");
                dispatcher.forward(req,resp);
                break;
            case ("/daily-bookings"):
// Get time range shown
                String fromDate = (LocalDateTime.now().minusDays(2)).format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));
                String toDate = (LocalDateTime.now().plusDays(5)).format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));
                req.setAttribute("fromDate", fromDate);
                req.setAttribute("toDate", toDate);

                List<BookingListData> bookingList = booking.getDailyBookings();

                // set it in requestScope
                req.setAttribute("bookingsList", bookingList);
//                for (BookingListData temp : bookingList) {
//                    System.out.println(temp);
//                }
                // forward to View (jsp ui)
                RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
                rd.forward(req, resp);
                break;}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req instanceof HttpServletRequest) {
//            String url = ((HttpServletRequest)req).getRequestURL().toString();
            String uri = ((HttpServletRequest)req).getRequestURI().toString();
//            String queryString = ((HttpServletRequest)req).getQueryString();
            System.out.println("uri " + uri);
            String page = uri.substring(uri.lastIndexOf('/'));
            System.out.println(page);

            switch (page){
                case ("/book"):
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
                        resp.sendRedirect("emptyRooms");
                        //            RequestDispatcher dispatcher = req.getRequestDispatcher("/availableRooms");
                        //            dispatcher.forward(req,resp);
                    }else {
                        resp.sendRedirect("booking.jsp");
                    }
                    break;
            }
    }}
}
