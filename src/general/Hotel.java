package general;

import general.user.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * A class to manage accounts, reservations, and rooms
 * @author Sang To
 * @version 1.0
 */
public class Hotel implements Serializable {
//    private Room[] room;
    private Map<String,Account> accMap;
    private Manager manager;
//    private Guest guest;
    private static Map<Room, SortedMap<LocalDate, Reservation>> roomMap;
    private static SortedMap<LocalDate,Reservation> sortedMap;
    public static String title = "reservations.txt";

    public Hotel() {
        manager = new Manager();
        loadHotel();
        accMap = new HashMap<>();
        roomMap = new HashMap<>();
        sortedMap = new TreeMap<>();
//        room = new Room[20];
//        // The first 10 rooms are LUXURY, the rest 10 rooms are ECONOMY
//        for (int i = 0; i < room.length; i++) {
//            room[i] = new Room(i, i < 10 ? RoomType.LUXURY:RoomType.ECONOMY);
//        }
    }

    /**
     * Creates new guest account
     * @param id
     * @param pass
     */
    public boolean signUp(String username, String id, String pass) {
        Account a = accMap.get(id);
        if (a == null) {
            Guest guest = new Guest(username,id,pass);
            accMap.put(id,guest);
            return true;
        }

        return false;
    }

    /**
     * Logs in user, checks if account exists
     * @param id
     * @param pass
     * @return
     */
    public boolean logIn(String id, String pass) {
        return accMap.containsKey(id) && accMap.get(id).getPassword().equals(pass);
    }

    /**
     * Deserializing
     * @return Hotel
     */
    public static Hotel loadHotel()
    {
        try (FileInputStream fis = new FileInputStream(title))
        {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
//            Hotel h = (Hotel)o;
            return (Hotel)o;
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Serializing
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
