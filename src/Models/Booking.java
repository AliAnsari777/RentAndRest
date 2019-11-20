package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int roomId;
    private int guestId;
    private int numberOfGuests;
    private LocalDate checkinDate;
    private LocalTime checkinTime;
    private LocalDate checkoutDate;
    private LocalTime checkoutTime;

    public Booking(){

    }

    public Booking(int roomId, int guestId, int numberOfGuests, LocalDate checkinDate, LocalTime checkinTime,
                   LocalDate checkoutDate, LocalTime checkoutTime) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.numberOfGuests = numberOfGuests;
        this.checkinDate = checkinDate;
        this.checkinTime = checkinTime;
        this.checkoutDate = checkoutDate;
        this.checkoutTime = checkoutTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }
}
