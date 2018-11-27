public class Hotel {
    private Room[] room;
    public static final int LUX_PRICE = 300;
    public static final int ECON_PRICE = 100;

    public Hotel() {
        room = new Room[20];
        for (int i = 0; i < room.length; i++) {
            if ( i < 10) {
                room[i] = new Room(i, LUX_PRICE);
            } else {
                room[i] = new Room(i, ECON_PRICE);
            }
        }
    }
}
