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
                    "(number , title, description, imageUrl, price) values  (?,?,?,?,?)");
            statement.setString(1,room.getNumber());
            statement.setString(2,room.getTitle());
            statement.setString(3,room.getDescription());
            statement.setString(4,room.getImageUrl());
            statement.setFloat(5,room.getPrice());
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List availableRooms(){
        List<String> roomsList = new ArrayList<>();

        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT number, title FROM rooms LEFT JOIN bookings ON bookings.room_id = rooms.id AND" +
                            " bookings.checkOut_date < CURDATE()\n");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int number = resultSet.getInt("number");
                String title = resultSet.getString("title");
                roomsList.add(number + "   " + title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(roomsList);
        return roomsList;
    }
}
