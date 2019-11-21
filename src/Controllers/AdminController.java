package Controllers;

import DAO.AdminDAO;
import Models.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "booking", urlPatterns = {"/signup", "/login"})
public class AdminController extends HttpServlet {
    AdminDAO adminDAO;
    public AdminController(){
        adminDAO = new AdminDAO(7);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req instanceof HttpServletRequest) {
            String uri = ((HttpServletRequest)req).getRequestURI().toString();
            String page = uri.substring(uri.lastIndexOf('/'));

            switch (page){
                case ("/signup"):
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    int personId   = Integer.parseInt(req.getParameter("personId"));
                    Admin admin = new Admin(email,password,personId);
                    boolean result = adminDAO.addAdmin(admin);
                    if (result){
                        resp.sendRedirect("login.html");
                    }else {
                        resp.sendRedirect("signUp.jsp");
                    }
                    break;

                case ("/login"):
                     email = req.getParameter("username");
                     password = req.getParameter("password");
                    Admin admin1 = new Admin(email,password);
                    boolean result2 = adminDAO.login(admin1);
                    if (result2){
                        //get the old session and invalidate
                        HttpSession oldSession = req.getSession(false);
                        if (oldSession != null) {
                            oldSession.invalidate();
                        }
                        //generate a new session
                        HttpSession newSession = req.getSession(true);

                        newSession.setAttribute("logged", "OK");
                        //setting session to expiry in 5 mins
                        newSession.setMaxInactiveInterval(5*60);
                        System.out.println(newSession);
                        resp.sendRedirect("daily-bookings");
                    }else {
                        resp.sendRedirect("login.html");
                    }
                    break;
            }
        }
    }
}
