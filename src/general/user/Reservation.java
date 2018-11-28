package general.user;

import general.Room;

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
    private Duration duration;

    public Reservation(Guest guest, Room room, Duration duration) {
        this.guest = guest;
        this.room = room;
        this.duration = duration;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
