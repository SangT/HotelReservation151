package general.user;

import general.Hotel;
import general.Room;
import general.RoomType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Guest.java - A class to instantiate guest object
 * @author Sang To
 * @version 1.0
 */
public class Guest extends Account implements Serializable {
    /*
    A user account information includes user id, password, username,
    and all reservations this user made excluding canceled ones.
     */
    private String username;
    private List<Reservation> reservationList;

    public Guest(String username, Hotel h, String id, String password) {
        super(h,id,password);
        this.username = username;
        reservationList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void addReservation(Reservation r) {
        reservationList.add(r);
    }

    // retrieve information from reservations.txt file
    public void viewReservation() {

    }

    // guest can cancel reservation here after viewing reservations
    public void cancelReservation(Reservation r) {
        reservationList.remove(r);
    }

}
