package general;

import general.user.Duration;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Room {
    private int number;
    private boolean isBooked;
    private RoomType type;
    private Duration duration;

    public Room(int number, RoomType type, Duration duration) {
        this.number = number;
        this.type = type;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

}
