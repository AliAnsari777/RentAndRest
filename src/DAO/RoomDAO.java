package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomDAO {
    DatabaseConnection connect;

    public RoomDAO() {
        this.connect = new DatabaseConnection();
    }


    public String addRoom(String number, String title, String description){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into rooms (number , title, description) values  (?,?,?)");
            statement.setString(1,number);
            statement.setString(2,title);
            statement.setString(3,description);
            System.out.println(number + " " + title + "  " + description);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Successfully saved the room";
    }
}
