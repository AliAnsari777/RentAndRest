package Controllers;

import DAO.GuestDAO;
import Models.Guest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "editGuestformData22", urlPatterns = "/editGuestformData")

public class editGuestformData extends HttpServlet {
    GuestDAO guestDAO;

    public editGuestformData(){
        guestDAO = new GuestDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param=req.getQueryString().split("=")[1];
        int id=Integer.parseInt(param);
        Guest editedGuest=guestDAO.getGuestById(id);
        req.setAttribute("editedGuest",editedGuest);
        RequestDispatcher dispatcher = req.getRequestDispatcher("guestEdit.jsp");
          dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);


    }
}
