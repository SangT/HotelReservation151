package general;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Room {
    private int number;
    private boolean isBooked;
    private RoomType type;

    public Room(int number, RoomType type) {
        this.number = number;
        this.type = type;
    }
}
