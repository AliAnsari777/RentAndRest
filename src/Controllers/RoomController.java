package Controllers;

import DAO.RoomDAO;
import Models.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "Room", urlPatterns = {"/AddRoom", "/AllRooms", "/DeleteRoom", "/EditRoom", "/EditSpacificRoom"})
@MultipartConfig(fileSizeThreshold = 6291456, // 6 MB
        maxFileSize = 10485760L, // 10 MB
        maxRequestSize = 20971520L // 20 MB
)
public class RoomController extends HttpServlet {
    RoomDAO room;

    public RoomController(){
        room = new RoomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = ((HttpServletRequest) req).getRequestURI().toString();
        System.out.println("uri " + uri);
        String page = uri.substring(uri.lastIndexOf('/'));
        System.out.println(page);
        RequestDispatcher rd;
        String param;
        Room roomObj;
        int id;
        boolean result;
        switch (page) {
            case ("/AllRooms"):
                List<Room> rooms = room.getAllRooms();
                req.setAttribute("rooms", rooms);
                rd = req.getRequestDispatcher("showallrooms.jsp");
                rd.forward(req, resp);
                break;
            case ("/EditRoom"):
                param = req.getQueryString().split("=")[1];
                System.out.println("hiii: " + param);
                id = Integer.parseInt(param);
                roomObj = room.getRoomByID(id);
                req.setAttribute("id", roomObj.getId());
                req.setAttribute("number", roomObj.getNumber());
                req.setAttribute("title", roomObj.getTitle());
                req.setAttribute("description", roomObj.getDescription());
                req.setAttribute("maxguests", roomObj.getMaxNumberOfGuest());
                req.setAttribute("price", roomObj.getPrice());
                rd = req.getRequestDispatcher("editroom.jsp");
                rd.forward(req, resp);
                break;

            case ("/DeleteRoom"):
                param = req.getQueryString().split("=")[1];
                System.out.println("hiii: " + param);
                id = Integer.parseInt(param);
                result = room.deleteRoomByID(id);
                req.setAttribute("deleteroom", result);
                rd = req.getRequestDispatcher("/AllRooms");
                rd.forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = ((HttpServletRequest) req).getRequestURI().toString();
        System.out.println("uri " + uri);
        String page = uri.substring(uri.lastIndexOf('/'));
        System.out.println(page);
        RequestDispatcher rd;
        String param;
        RoomDAO roomDAo = new RoomDAO();
        int id;
        boolean result;
        switch (page) {
            case ("/AddRoom"):
                String number = (String) req.getParameter("number");
                String title = (String) req.getParameter("title");
                String description = (String) req.getParameter("description");
                float price = Float.parseFloat(req.getParameter("cost"));
                int maxNumber = Integer.parseInt(req.getParameter("maxNumberOfGuests"));

                String imagesDir = "Photos";

                // gets absolute path of the web application
                String applicationPath = "D:\\";
                // constructs path of the directory to save uploaded file
                String uploadFilePath = applicationPath + File.separator + imagesDir;
                // creates upload folder if it does not exists
                File uploadFolder = new File(uploadFilePath);
                if (!uploadFolder.exists()) {
                    uploadFolder.mkdirs();
                }
                PrintWriter writer = resp.getWriter();
                // write all files in upload folder
                String pathOfImage = null;
                for (Part part : req.getParts()) {
                    if (part != null && part.getSize() > 0) {
                        String fileName = part.getSubmittedFileName();
                        String contentType = part.getContentType();

                        part.write(uploadFilePath + File.separator + fileName);

                        pathOfImage = uploadFolder.getAbsolutePath() + File.separator + fileName;
                    }
                }

                    Room roomObject = new Room(number, title, description, pathOfImage, price, maxNumber);
                    result = room.addRoom(roomObject);

                    if (result) {
                        req.setAttribute("msg", "yes");
                        RequestDispatcher dispatcher = req.getRequestDispatcher("addroom.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        resp.sendRedirect("addroom.jsp");
                    }
                break;
            case ("/EditSpacificRoom"):
                param = req.getQueryString().split("=")[1];
                System.out.println("EditSpacificRoom param: " + param);
                id = Integer.parseInt(param);
                Room roomObj = roomDAo.getRoomByID(id);
                Room room = new Room(id, req.getParameter("number"), req.getParameter("title"), req.getParameter("description"), Float.parseFloat(req.getParameter("cost").toString()), Integer.parseInt(req.getParameter("maxNumberOfGuests").toString()));
                Room newObj = roomDAo.editSpacificRoom(room);
                resp.sendRedirect("/RentAndRest/AllRooms");
                break;
        }
    }
}
