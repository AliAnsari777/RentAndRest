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

@WebServlet(name = "UpdateGuestController22", urlPatterns = "/UpdateGuestController")
public class UpdateGuestController extends HttpServlet {
    GuestDAO guestDAO;

    public UpdateGuestController(){
        guestDAO = new GuestDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("updateid"));
        float rating=Float.parseFloat(req.getParameter("rating").toString());
        String procedence=(String)req.getParameter("procedence");
        String language=(String)req.getParameter("language");
        String note=(String)req.getParameter("note");
        String guestName=(String)req.getParameter("guestName");
        Guest ges=guestDAO.getGuestById(id);

        Guest g =new Guest(ges.getId(),guestName,rating,procedence,language,note);
        Guest result=guestDAO.editGuest(g);
        //boolean result=guestDAO.addGuest(g);
        if (result!=null){
            HttpSession session = req.getSession();
            session.setAttribute("msg", "yes");
           resp.sendRedirect("/RentAndRest/guestList");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("guestList");
//           dispatcher.forward(req,resp);
        }else {
            resp.sendRedirect("guestEdit.jsp");
        }

    }
}
