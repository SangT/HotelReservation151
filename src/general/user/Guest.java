package general.user;

import general.Hotel;
import general.Room;
import general.RoomType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * A Guest class
 */
public class Guest extends Account implements Serializable {
    /*
    A user account information includes user id, password, username,
    and all reservations this user made excluding canceled ones.
     */
    private String username;
    private List<Reservation> reservationList;
//    private Map<LocalDate, Reservation> map;

    public Guest(String username, String id, String password) {
        super(id,password);
        this.username = username;
        reservationList = new ArrayList<>();
//        map = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    /**
     * Checks room available based on types
     * @param s
     * @param type
     * @return
     */
    public List<Room> checkAvailableType(StayDuration s, RoomType type) {
        List<Room> listType = new ArrayList<>();
        Map<Room, TreeMap<LocalDate, Reservation>> m = Hotel.roomMap;
        LocalDate in = s.getCheckIn();
        LocalDate out = s.getCheckOut();


        return listType;
    }

    /**
     * Checks all available rooms
     * @param s
     * @return
     */
    public List<Room> checkAvailableDay(StayDuration s) {
        List<Room> listDay = new ArrayList<>();

        return listDay;
    }

    public void makeReservation(LocalDate in, LocalDate out, int number) {
        StayDuration s = new StayDuration(in, out);
        RoomType t;
        if (number<10) {
            t = RoomType.LUXURY;
        } else {
            t = RoomType.ECONOMY;
        }
        Room room = new Room(number, t);
        Reservation r = new Reservation(this, room, s, LocalDate.now());
        reservationList.add(r);

        Hotel.roomMap.get(room).put(in, r);

    }

    // retrieve information from reservations.txt file
    public void viewReservation() {

    }

    // guest can cancel reservation here after viewing reservations
    public void cancelReservation(Reservation r) {
        reservationList.remove(r);
    }

}
