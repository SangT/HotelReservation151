package general;

import general.user.StayDuration;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Room {
    private int number;
    private boolean isBooked;
    private RoomType type;
    private StayDuration duration;

    public Room(int number, RoomType type) {
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public StayDuration getDuration() {
        return duration;
    }

    public void setDuration(StayDuration duration) {
        this.duration = duration;
    }
}
