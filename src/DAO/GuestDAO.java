package DAO;

import Models.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDAO {
    DatabaseConnection connect;
    int personId;

    public GuestDAO(){
        connect = new DatabaseConnection();
    }

    public boolean addPerson(Guest guest){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into person " +
                    "(lastName, firstName, docType, docNumber) values (?, ?, ?, ?)");
            statement.setString(1,guest.getLastName());
            statement.setString(2,guest.getFirstName());
            statement.setString(3,guest.getDocType());
            statement.setString(4,guest.getDocNumber());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void lastPersonId(){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM person ORDER BY id DESC LIMIT 1");
            ResultSet person = statement.executeQuery();
            personId = person.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addGuest(Guest guest){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into guests " +
                    "(guestName, peston_id, procedence, language , notes) values (?, ?, ?, ?,?)");
            statement.setString(1, guest.getFirstName() + "  " + guest.getLastName());
            statement.setInt(2, personId);
            statement.setString(3,guest.getProcedence());
            statement.setString(4,guest.getLanguage());
            statement.setString(5,guest.getNote());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
