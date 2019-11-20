package DAO;

import Models.Booking;
import java.sql.*;

public class BookingDAO {
    private DatabaseConnection connect;

    public BookingDAO() {
        this.connect = new DatabaseConnection();
    }

    public boolean addBooking(Booking value){
        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert  into bookings " +
                    "(room_id, guest_id, numberOfGuests, checkin_date, checkin_time, checkout_date, checkout_time)" +
                    "values (?,?,?,?,?,?,?)");
            statement.setInt(1, value.getRoomId());
            statement.setInt(2,value.getGuestId());
            statement.setInt(3,value.getNumberOfGuests());
            statement.setDate(4, Date.valueOf(value.getCheckinDate()));
            statement.setTime(5, Time.valueOf(value.getCheckinTime()));
            statement.setDate(6, Date.valueOf(value.getCheckoutDate()));
            statement.setTime(7, Time.valueOf(value.getCheckoutTime()));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
