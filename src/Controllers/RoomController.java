package Controllers;

import DAO.RoomDAO;
import Models.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Room", urlPatterns = "/Room")
public class RoomController extends HttpServlet {
    RoomDAO room;

    public RoomController(){
        room = new RoomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = (String)req.getParameter("number");
        String title = (String)req.getParameter("title");
        String description = (String)req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("cost"));
        String imageUrl = (String)req.getParameter("fileupload");
        int maxNumber = Integer.parseInt(req.getParameter("maxNumberOfGuests"));
        Room roomObject = new Room(number,title,description,imageUrl,price, maxNumber);
        boolean result = room.addRoom(roomObject);

        if (result){
            req.setAttribute("msg", "yes");
            RequestDispatcher dispatcher = req.getRequestDispatcher("addroom.jsp");
            dispatcher.forward(req,resp);
        }else {
            resp.sendRedirect("addroom.jsp");
        }
    }
}
