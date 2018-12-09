package general;


import java.io.Serializable;

/**
 *
 * @author Sang To
 * @version 1.0
 */
public class Room implements Serializable {
    private int number;
    private RoomType type;
//    private StayDuration duration;

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

}
