package DAO;

import Models.Admin;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    DatabaseConnection connect;
    private final int logRounds;

    public AdminDAO(int logRounds){
        connect = new DatabaseConnection();
        this.logRounds = logRounds;
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
    }

    public boolean addAdmin(Admin admin){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into admin " +
                    "(email, password, person_id) values (?, ?, ?)" );
            statement.setString(1, admin.getEmail());
            statement.setString(2,hash(admin.getPassword()));
            statement.setString(3, String.valueOf(admin.getPersonId()));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(Admin admin){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select email, password from admin where email = ?");
            statement.setString(1,admin.getEmail());

            ResultSet result = statement.executeQuery();
            result.next();

            if(result != null){
               boolean validate = BCrypt.checkpw(admin.getPassword(), result.getString("password"));
               if (validate){
                   return true;
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
