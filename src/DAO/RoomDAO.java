package DAO;

import Models.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    DatabaseConnection connect;

    public RoomDAO() {
        this.connect = new DatabaseConnection();
    }

    public boolean addRoom(Room room){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into rooms " +
                    "(number , title, description, imageUrl, price, maxNumGuests ) values  (?,?,?,?,?, ?)");
            statement.setString(1,room.getNumber());
            statement.setString(2,room.getTitle());
            statement.setString(3,room.getDescription());
            statement.setString(4,room.getImageUrl());
            statement.setFloat(5,room.getPrice());
            statement.setInt(6, room.getMaxNumberOfGuest());
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Room> availableRooms(){
        List<Room> roomsList = new ArrayList<>();

        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT rooms.id, title FROM rooms LEFT JOIN bookings ON bookings.room_id = rooms.id AND" +
                            " bookings.checkOut_date < CURDATE() GROUP BY rooms.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String title = resultSet.getString("title");
                Room obj = new Room(id,title);
                roomsList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomsList;
    }

    public List<Room> getAllRooms() {
        List<Room> listOfRooms = new ArrayList<>();
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * From rooms");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String number = resultSet.getString("number");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Room obj = new Room(id, number, title, description);
                listOfRooms.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfRooms;

    }

    public Room editSpacificRoom(Room room) {
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE rooms SET  number=?,title=?,description=?,maxNumGuests=?,price=? WHERE id=?");
            statement.setString(1, room.getNumber());
            statement.setString(2, room.getTitle());
            statement.setString(3, room.getDescription());
            statement.setInt(4, room.getMaxNumberOfGuest());
            statement.setFloat(5,room.getPrice());
            statement.setInt(6,room.getId());
            statement.executeUpdate();
            return room;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Room getRoomByID(int id) {
        System.out.println("id: " + id);
        Room room = null;
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rooms WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String number = resultSet.getString("number");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int maxGuests = resultSet.getInt("maxNumGuests");
                room = new Room(id, number, title, description, price, maxGuests);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public boolean deleteRoomByID(int id) {
        boolean rowDeleted=false;
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rooms WHERE id = ?");
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }
}
