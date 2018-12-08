package general.user;

import general.Room;

import java.time.LocalDate;


/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Reservation{
    /*
    Each reservation record knows who made this reservation, which room is assigned,
    and the period of the reservation
    */
    private Guest guest;
    private Room room;
    private StayDuration duration;
    private LocalDate booked;

    public Reservation(Guest guest, Room room, StayDuration duration, LocalDate booked) {
        this.guest = guest;
        this.room = room;
        this.duration = duration;
        this.booked = booked;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public StayDuration getDuration() {
        return duration;
    }

    public LocalDate getBooked() {
        return booked;
    }
}
