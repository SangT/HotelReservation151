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
    private Map<Room, TreeMap<LocalDate, Reservation>> roomMap;
    private Manager manager;
    private static final String TITLE = "reservations.txt";
    private static final int TOTAL_ROOMS = 20;

    public Hotel() {
        manager = new Manager();
        accMap = new HashMap<>();
        accMap.put(manager.getId(),manager);
        roomMap = new HashMap<>(TOTAL_ROOMS);
        for (int i = 1; i <= TOTAL_ROOMS / 2; i++) {
            Room roomLUX = new Room(i, RoomType.LUXURY);
            Room roomECO = new Room(i + TOTAL_ROOMS / 2, RoomType.ECONOMY);
            roomMap.put(roomLUX, new TreeMap<>());
            roomMap.put(roomECO, new TreeMap<>());
        }
    }

    public void reserveRoom(Room room, StayDuration s, Guest guest) {
        Reservation r = new Reservation(guest, room, s, LocalDate.now());
        TreeMap<LocalDate, Reservation> m = roomMap.get(room);
        m.put(s.getCheckIn(), r);
        guest.addReservation(r);
        roomMap.put(room, m);
    }

    /**
     * Checks all available rooms
     * @param s
     * @return
     */
    public List<Room> checkAvailableRoom(StayDuration s) {
        List<Room> listDay = new ArrayList<>();

        return listDay;
    }

    /**
     * Creates new guest account
     * @param id
     * @param pass
     */
    public boolean signUp(String username, String id, String pass) {
        Account a = accMap.get(id);
        if (a == null) {
            Guest guest = new Guest(username,this,id,pass);
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
        try (FileInputStream fis = new FileInputStream(TITLE))
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
        try (FileOutputStream fos = new FileOutputStream(TITLE))
        {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
