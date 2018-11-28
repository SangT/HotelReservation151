package general.user;

import general.Room;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Reservation {
    /*
    Each reservation record knows who made this reservation, which room is assigned,
    and the period of the reservation*/
    private Guest guest;
    private Room room;
    private Duration duration;
    private double price;

    public Reservation(Guest guest, Room room, Duration duration) {
        this.guest = guest;
        this.room = room;
        this.duration = duration;
    }



}
