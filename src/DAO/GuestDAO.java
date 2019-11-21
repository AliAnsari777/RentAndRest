package DAO;

import Models.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            person.next();
            personId = person.getInt("id");
            person.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addGuest(Guest guest){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into guests " +
                    "(guestName, person_id, procedence, language, rating , notes) values (?, ?, ?, ?, ?,?)");
            statement.setString(1, guest.getGuestName());
            statement.setInt(2, personId);
            statement.setString(3,guest.getProcedence());
            statement.setString(4,guest.getLanguage());
            statement.setFloat(5,guest.getRating());
            statement.setString(6,guest.getNote());
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Guest> guestList(){
        List<Guest> guestList = new ArrayList<>();

        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, guestName from guests");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String guestName = result.getString("guestName");
                Guest obj = new Guest(id, guestName);
                guestList.add(obj);
            }
            result.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }

    public List<Guest> getAllGuests(){
        List<Guest>guestList=new ArrayList<Guest>();
        try {
            Connection connection=connect.databaseConnection.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM guests order by guestName");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int guestId=rs.getInt("id");
                String guestName=rs.getString("guestName");
                int rating = rs.getInt("rating");
                String procedence=rs.getString("procedence");
                String language = rs.getString("language");
                String notes=rs.getString("notes");
                Guest data=new Guest(guestId,guestName,rating, procedence, language,notes);
                guestList.add(data);


            }rs.close();
            connection.close();
        }catch(SQLException e) {
            System.err.println(e);
        }
        return guestList;
    }
    public Guest editGuest(Guest guest){
        try {

            Connection connection = connect.databaseConnection.getConnection();
            String sql = "update guests set rating=?,procedence=?,language=?,notes=?,guestName=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, guest.getRating());
            statement.setString(2, guest.getProcedence());
            statement.setString(3, guest.getLanguage());
            statement.setString(4, guest.getNote());
            statement.setInt(6,guest.getId());
            statement.setString(5,guest.getGuestName());
            statement.executeUpdate();
            connection.close();
            return guest;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public boolean deleteGuest(int id){
        try{
            Connection connection = connect.databaseConnection.getConnection();
            String sql = "DELETE FROM guests WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
            connection.close();

        }catch(SQLException e){
            e.printStackTrace();

        }
        return false;
    }
    public Guest getGuestById(int guestId){


        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `cs472-201911-project-rentandrest-db`.guests where id=?");
            pstmt.setInt(1, guestId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Guest g=new Guest(rs.getInt("id"),rs.getString("guestName"),rs.getInt("rating"),rs.getString("procedence"),rs.getString("language"),rs.getString("notes"));
            //  Guest g=new Guest(rs.getInt("id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("docType"),rs.getInt("rating"),rs.getString("procedence"),rs.getString("language"),rs.getString("notes"));
rs.close();
            connection.close();
            return g;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
