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

@WebServlet(name = "deleteGuestController", urlPatterns = "/deleteGuest")

public class deleteGuestController extends HttpServlet {
    GuestDAO guestDAO;

    public deleteGuestController(){
        guestDAO = new GuestDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int guestid=Integer.parseInt(req.getAttribute("id").toString());
//        System.out.println("in deleteguest id="+guestid);

        String param=req.getQueryString().split("=")[1];
        int guestid=Integer.parseInt(param);

        //int guestid=Integer.parseInt(req.getAttribute("deletedId").toString());
        //Guest g =new Guest(firstName,lastName,docType,docNumber,procedence,language,note);
        boolean result= guestDAO.deleteGuest(guestid);
        //guestDAO.lastPersonId();
        //boolean result=guestDAO.addGuest(g);
        HttpSession session = req.getSession();

        if (result){

            //     resp.sendRedirect("guest-List");
            resp.sendRedirect("/RentAndRest/guestList");

        }else {
            session.setAttribute("msg", "no");
            //   resp.sendRedirect("guestList.jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/RentAndRest/guestList");
            dispatcher.forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

doGet(req,resp);
    }

}
