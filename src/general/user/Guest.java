package general.user;

import general.Room;
import general.RoomType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * A Guest class
 */
public class Guest extends Account{
    /*
    A user account information includes user id, password, username,
    and all reservations this user made excluding canceled ones.
     */
    private Map<LocalDate, Reservation> reservationList;
    private Map<LocalDate, Map<LocalDate, Reservation>> map;

    public Guest(String id, String password) {
        super(id,password);
        reservationList = new HashMap<>();
        map = new HashMap<>();
    }

    public Map<LocalDate, Reservation> getReservationList() {
        return reservationList;
    }

//    public void setReservationList(List<Reservation> reservationList) {
//        this.reservationList = reservationList;
//    }

    public void makeReservation(LocalDate in, LocalDate out, int number) {
        StayDuration s = new StayDuration(in, out);
        RoomType t;
        if (number<10) {
            t = RoomType.LUXURY;
        } else {
            t = RoomType.ECONOMY;
        }
        Room room = new Room(number, t);
        Reservation r = new Reservation(this, room, s);
        reservationList.put(LocalDate.now(), r);
    }

    // retrieve information from reservations.txt file
    public void viewReservation() {

    }

    // guest can cancel reservation here after viewing reservations
    public void cancelReservation(Reservation r) {
        reservationList.remove(r);
    }
}
