package general;

import general.user.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage accounts, reservations, and rooms
 * @author Sang To
 * @version 1.0
 */
public class Hotel implements Serializable {
    private Room[] room;
    private List<Account> list;
    public static String title = "revervations.txt";

    public Hotel() {
        list = new ArrayList<>();
        room = new Room[20];
        // The first 10 rooms are LUXURY, the rest 10 rooms are ECONOMY
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
        //check if this id already exists in the system
        list.add(a);
    }

    /**
     * Logs in user, checks if account exists
     * @param id
     * @param pass
     * @return
     */
    public boolean logIn(String id, String pass) {
//        if (account.getId().equals(id) && account.getPassword().equals(pass)) {
//            return true;
//        }
        return false;
    }

    /**
     *
     * @return Hotel
     */
    public static Hotel loadHotel()
    {
        try (FileInputStream fis = new FileInputStream(title))
        {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            Hotel h = (Hotel)o;
            return h;
        } catch (IOException e)
        {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     */
    public void saveHotel() {
        try (FileOutputStream fos = new FileOutputStream(title))
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
