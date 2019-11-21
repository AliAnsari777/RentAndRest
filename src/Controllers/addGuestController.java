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

@WebServlet(name = "addGuestController22", urlPatterns = "/addGuestController")
public class addGuestController extends HttpServlet {
    GuestDAO guestDAO;

    public addGuestController(){
        guestDAO = new GuestDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String firstName=(String)req.getParameter("firstName");
    String lastName=(String)req.getParameter("lastName");
    String docType=(String)req.getParameter("docType");
    String docNumber=(String)req.getParameter("docNumber");
    float rating=Float.parseFloat(req.getParameter("rating"));
    String procedence=(String)req.getParameter("procedence");
    String language=(String)req.getParameter("language");
    String note=(String)req.getParameter("note");
    String guestName=(String)req.getParameter("guestName");
    Guest g =new Guest(firstName,lastName,docType,docNumber,rating,procedence,language,note,guestName);
    guestDAO.addPerson(g);
    guestDAO.lastPersonId();
    boolean result=guestDAO.addGuest(g);
        if (result){
            HttpSession session = req.getSession();
            session.setAttribute("msg", "yes");
            //.sendRedirect("guestList");
            RequestDispatcher dispatcher = req.getRequestDispatcher("addguest.jsp");
            dispatcher.forward(req,resp);
        }else {
            resp.sendRedirect("addguest.jsp");
        }

    }
}
