package general;

import general.user.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage accounts, reservations, and rooms
 * @author Sang To
 * @version 1.0
 */
public class Hotel {
    private Room[] room;
    private List<Account> list;

    public Hotel() {
        list = new ArrayList<>();
        room = new Room[20];
        for (int i = 0; i < room.length; i++) {
            room[i] = new Room(i, i < 10 ? RoomType.LUXURY:RoomType.ECONOMY);
        }
    }

    /**
     * Create new guest account
     * @param id
     * @param pass
     */
    public void signUp(String id, String pass) {
        Account a = new Account(id, pass);
        list.add(a);
    }
}
