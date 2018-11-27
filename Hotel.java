
public class Hotel {
    private Room[] room;
    public static final int LUX_PRICE = 300;
    public static final int ECON_PRICE = 100;

    public Hotel() {
        room = new Room[20];
        for (int i = 0; i < room.length; i++) {
            room[i] = new Room(i, i < 10?LUX_PRICE:ECON_PRICE, false);
        }
    }
}
