package Controllers;

import DAO.RoomDAO;
import Models.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Room", urlPatterns = "/room/addRoom")
public class RoomController extends HttpServlet {
    RoomDAO room;

    public RoomController(){
        room = new RoomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is working");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = (String)req.getParameter("number");
        String title = (String)req.getParameter("title");
        String description = (String)req.getParameter("description");
        Room roomObject = new Room(number,title,description);
        room.addRoom(number,title,description);
        req.setAttribute("roomInfo", roomObject);
        System.out.println("This is working in post");
    }
}
