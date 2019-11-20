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
}
