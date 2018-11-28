package general.user;

import general.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * A Guest class
 */
public class Guest extends Account{
    private String id;
    private String password;
    private List<Reservation> reservationList;

    public Guest(String id, String password) {
        super(id,password);
        reservationList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
