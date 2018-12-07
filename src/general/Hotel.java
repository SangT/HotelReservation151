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
    private Map<String,Account> accMap;
    private Manager manager;
    public static Map<Room, TreeMap<LocalDate, Reservation>> roomMap;
    public static String title = "reservations.txt";

    public Hotel() {
        manager = new Manager();
        loadHotel();
        accMap = new HashMap<>();
        roomMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            Room room = new Room(i, RoomType.LUXURY);
            roomMap.put(room, new TreeMap<>());
        }
        for (int i = 11; i <= 20; i++) {
            Room room = new Room(i, RoomType.ECONOMY);
            roomMap.put(room, new TreeMap<>());
        }
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
