package DAO;

import Models.Booking;
import Models.BookingListData;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BookingListData> getDailyBookings() {
        List<BookingListData> bookingList = new ArrayList<>();

        try {
            Connection connection = connect.databaseConnection.getConnection();
            String queryStmnt;
            queryStmnt = "SELECT \n" +
                    "\tR.number as 'room_number', G.guestName as 'guest_name', \n" +
                    "    B.numberOfGuests as 'number_of_guests', \n" +
                    "    DATEDIFF(B.checkOut_date, B.checkIn_date) as 'stay_length',\n" +
                    "    C.name as 'procedence', L.name AS 'language',\n" +
                    "\tB.checkIn_date, B.checkIn_time, B.checkOut_date, B.checkOut_time\n" +
                    "FROM\n" +
                    "\t`cs472-201911-project-rentandrest-db`.bookings B\n" +
                    "INNER JOIN\n" +
                    "\trooms R\n" +
                    "\tON B.room_id = R.id\n" +
                    "INNER JOIN\n" +
                    "\tguests G\n" +
                    "\tON B.guest_id = G.id\n" +
                    "INNER JOIN\n" +
                    "\tlanguages L\n" +
                    "    ON G.language = L.alpha3_code\n" +
                    "INNER JOIN\n" +
                    "\tcountries C\n" +
                    "    ON G.procedence = C.alpha3_code\n" +
                    "WHERE\n" +
                    "\tcheckIn_date BETWEEN (DATE_SUB(CURDATE(), INTERVAL 2 DAY)) AND (DATE_ADD(CURDATE(), INTERVAL 5 DAY))\n" +
                    "    OR\n" +
                    "    checkOut_date BETWEEN (DATE_SUB(CURDATE(), INTERVAL 2 DAY)) AND (DATE_ADD(CURDATE(), INTERVAL 5 DAY))\n" +
                    "ORDER BY\n" +
                    "\tB.checkIn_date, B.checkIn_time, B.checkOut_date, B.checkOut_time;";
            PreparedStatement pstmt = connection.prepareStatement(queryStmnt);
//            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String room_number = rs.getString("room_number");
                String guest_name = rs.getString("guest_name");
                String number_of_guests = rs.getString("number_of_guests");
                String stay_length = rs.getString("stay_length");
                String procedence = rs.getString("procedence");
                String language = rs.getString("language");
                LocalDate checkIn_date = (rs.getDate("checkIn_date")).toLocalDate();
                LocalDate checkOut_date = (rs.getDate("checkOut_date")).toLocalDate();
                LocalTime checkIn_time = (rs.getTime("checkIn_time")).toLocalTime();
                LocalTime checkOut_time = (rs.getTime("checkOut_time")).toLocalTime();

                BookingListData bookingData = new BookingListData(room_number, guest_name, number_of_guests, stay_length,
                        procedence, language, checkIn_date, checkOut_date, checkIn_time, checkOut_time);
                bookingList.add(bookingData);
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return bookingList;
    }

    public Booking editBooking(Booking booking){
        try {

            Connection connection = connect.databaseConnection.getConnection();
            String sql = "update bookings set room_id=?,numberOfGuests=?,checkIn_date=?,checkIn_time=?,checkOut_date=?,checkOut_time=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, booking.getRoomId());
            statement.setInt(2, booking.getNumberOfGuests());
            statement.setDate(3, Date.valueOf(booking.getCheckinDate()));
            statement.setTime(4,Time.valueOf( booking.getCheckinTime()));
            statement.setDate(5, Date.valueOf(booking.getCheckoutDate()));
            statement.setTime(6,Time.valueOf( booking.getCheckoutTime()));
            statement.setInt(7,booking.getId());

            statement.executeUpdate();
            connection.close();
            return booking;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean deleteBooking(int id){
        try{
            Connection connection = connect.databaseConnection.getConnection();
            String sql = "DELETE FROM bookings WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            connection.close();
            if (rowsDeleted > 0) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();

        }
        return false;
    }


    //public
    public List<Booking> getAllBooking(){
        List<Booking>bookingList=new ArrayList<Booking>();
        try {
            Connection connection=connect.databaseConnection.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM bookings order by checkOut_date");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int bookingId=rs.getInt("id");
                int guestId=rs.getInt("guest_id");
                int roomId=rs.getInt("room_id");
                int numberOfGuests=rs.getInt("numberOfGuests");
                LocalDate checkinDate=rs.getDate("checkIn_date").toLocalDate();
                LocalTime checkIntime=rs.getTime("checkIn_time").toLocalTime();
                LocalDate checkOutdate=rs.getDate("checkOut_date").toLocalDate();
                LocalTime checkOuttime=rs.getTime("checkOut_time").toLocalTime();
                //Guest data=new Guest(guestId,guestName,rating, procedence, language,notes);
                Booking data=new Booking(bookingId,roomId,guestId,numberOfGuests,checkinDate,checkIntime,checkOutdate,checkOuttime);
                bookingList.add(data);


            }rs.close();
            connection.close();
        }catch(SQLException e) {
            System.err.println(e);
        }
        return bookingList;
    }
    public Booking getBookingById(int bookingId){


        try {
            Connection connection = connect.databaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `cs472-201911-project-rentandrest-db`.bookings where id=?");
            pstmt.setInt(1, bookingId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Booking b=new Booking(rs.getInt("id"),rs.getInt("room_id"),rs.getInt("guest_id"), rs.getInt("numberOfGuests"),rs.getDate("checkIn_date").toLocalDate(),rs.getTime("checkIn_time").toLocalTime(),rs.getDate("checkOut_date").toLocalDate(),rs.getTime("checkOut_time").toLocalTime());
            connection.close();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
