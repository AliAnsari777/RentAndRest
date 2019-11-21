package Controllers;

import DAO.GuestDAO;
import Models.Guest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "guestList22", urlPatterns = "/guestList")

public class guestList extends HttpServlet {
    GuestDAO guestDAO;

    public guestList() {

        guestDAO = new GuestDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id=Integer.parseInt(req.getAttribute("editid").toString());
//        Guest g=guestDAO.getGuestById(id);
//        req.setAttribute("editedGuest",g);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("guestEdit.jsp");
//        dispatcher.forward(req,resp);
        List<Guest> guests = guestDAO.getAllGuests();
//        System.out.println("*************************hiii***************************");
//        guests.forEach(x -> System.out.println(x));
        // set it in requestScope
        req.setAttribute("guests", guests);
        // forward to View (jsp ui)
        RequestDispatcher rd = req.getRequestDispatcher("/guest-List.jsp");
        rd.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);


    }
}
