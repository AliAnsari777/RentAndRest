package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingListData {
    private String room_number;
    private String guest_name;
    private String number_of_guests;
    private String stay_length;
    private String procedence;
    private String language;
    private LocalDate checkIn_date;
    private LocalDate checkOut_date;
    private LocalTime checkIn_time;
    private LocalTime checkOut_time;

    public BookingListData() {
    }

    public BookingListData(String room_number, String guest_name, String number_of_guests, String stay_length, String procedence, String language, LocalDate checkIn_date, LocalDate checkOut_date, LocalTime checkIn_time, LocalTime checkOut_time) {
        this.room_number = room_number;
        this.guest_name = guest_name;
        this.number_of_guests = number_of_guests;
        this.stay_length = stay_length;
        this.procedence = procedence;
        this.language = language;
        this.checkIn_date = checkIn_date;
        this.checkOut_date = checkOut_date;
        this.checkIn_time = checkIn_time;
        this.checkOut_time = checkOut_time;
    }

    public String getRoom_number() {
        return room_number;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public String getNumber_of_guests() {
        return number_of_guests;
    }

    public String getStay_length() {
        return stay_length;
    }

    public String getProcedence() {
        return procedence;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDate getCheckIn_date() {
        return checkIn_date;
    }

    public LocalDate getCheckOut_date() {
        return checkOut_date;
    }

    public LocalTime getCheckIn_time() {
        return checkIn_time;
    }

    public LocalTime getCheckOut_time() {
        return checkOut_time;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public void setNumber_of_guests(String number_of_guests) {
        this.number_of_guests = number_of_guests;
    }

    public void setStay_length(String stay_length) {
        this.stay_length = stay_length;
    }

    public void setProcedence(String procedence) {
        this.procedence = procedence;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCheckIn_date(LocalDate checkIn_date) {
        this.checkIn_date = checkIn_date;
    }

    public void setCheckOut_date(LocalDate checkOut_date) {
        this.checkOut_date = checkOut_date;
    }

    public void setCheckIn_time(LocalTime checkIn_time) {
        this.checkIn_time = checkIn_time;
    }

    public void setCheckOut_time(LocalTime checkOut_time) {
        this.checkOut_time = checkOut_time;
    }

    @Override
    public String toString() {
        return "BookingListData{" +
                  "room_number = " + room_number+ '\'' +
                ", guest_name = " + guest_name+ '\'' +
                ", number_of_guests =' " + number_of_guests+ '\'' +
                ", stay_length = " + stay_length+ '\'' +
                ", procedence = " + procedence+ '\'' +
                ", language = " + language+ '\'' +
                ", checkIn_date = " + checkIn_date+ '\'' +
                ", checkOut_date = " + checkOut_date+ '\'' +
                ", checkIn_Time = " + checkIn_time+ '\'' +
                ", checkOut_Time  = " + checkOut_time + '\'' +
                '}';   }}