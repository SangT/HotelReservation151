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
        manager = new Manager(this);
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

    /**
     * To reserve a room and save in the system
     * @param room
     * @param s
     * @param guest
     */
    public void reserveRoom(Room room, StayDuration s, Guest guest) {
        Reservation r = new Reservation(guest, room, s, LocalDate.now());
        TreeMap<LocalDate, Reservation> m = roomMap.get(room);
        m.put(s.getCheckIn(), r);
        guest.addReservation(r);
        roomMap.put(room, m);
    }

    public void removeReservation(Room room, StayDuration s, Guest guest) {
        TreeMap<LocalDate, Reservation> m = roomMap.get(room);
        Reservation r = m.get(s.getCheckIn());
        m.remove(s.getCheckIn());
        guest.cancelReservation(r);
        roomMap.put(room, m);
    }

    /**
     * Checks all available rooms
     * @param in
     * @param out
     * @return
     */
    public List<Room> checkAvailableRoom(LocalDate in, LocalDate out) {
        List<Room> listDay = new ArrayList<>();
        /*
        retrieve startday from duration
        enhanced for loop through VALUES of map
        for every map you loop through...
        search floor entry using start day
        if nothing returns, add room to list
        otherwise if floor entry's duration and stay duration conflict...
            dont add event
        otherwise
            add event
         */
//        LocalDate in = s.getCheckIn();
        for (Map.Entry<Room, TreeMap<LocalDate, Reservation>> map : roomMap.entrySet()) {
            Room room = map.getKey();
            TreeMap<LocalDate, Reservation> m = roomMap.get(room);

            // Get the greatest but smaller than the "in" value
            LocalDate expected = m.floorKey(in);
            StayDuration s = new StayDuration(in, out);
            if (expected == null) {
                listDay.add(room);
            } else if (!m.get(expected).getDuration().isConflict(s)) {
                listDay.add(room);
            }
            // if checkout date = null, check for available/unavailable room on that check-in day
//            } else {
//                if (!m.containsKey(in) || in.isBefore(m.ceilingKey(in)) ) {
//                    listDay.add(room);
//                } else if (in.isAfter(m.floorKey(in)) && in.isBefore(m.get(m.floorKey(in)).getDuration().getCheckOut())) {
//                    listDay.add(room);
//                } else {
//
//                }
//            }
        }
        return listDay;
    }

    /**
     * Gets available rooms in a chosen day
     * @param chosenDay
     * @return
     */
    public Set<Room> getRoomInfoByDay(LocalDate chosenDay) {
        Set<Room> avaiList = new TreeSet<>((o1, o2) -> o1.getNumber()>o2.getNumber()?1:-1);

        for (Map.Entry<Room, TreeMap<LocalDate, Reservation>> map : roomMap.entrySet()) {
            Room room = map.getKey();
            TreeMap<LocalDate, Reservation> m = roomMap.get(room);
            LocalDate expected = m.floorKey(chosenDay);
//            LocalDate in = m.get(expected).getDuration().getCheckIn();
            LocalDate out = m.get(expected).getDuration().getCheckOut();
            if (expected == null) {
                avaiList.add(room);
            } else if (chosenDay.isEqual(out) || chosenDay.isAfter(out)) {
                avaiList.add(room);
            }
        }
        return avaiList;
    }

    /**
     * Get unavailable rooms in a chosen day
     * @param chosen
     * @param avaiR
     * @return
     */
    public Map<Room,String> getUnavaiRoombyDay(LocalDate chosen, Set<Room> avaiR) {
        Map<Room,String> unVmap = new HashMap<>();

        for (Map.Entry<Room, TreeMap<LocalDate, Reservation>> map : roomMap.entrySet()) {
            Room room = map.getKey();
            if (avaiR.contains(room)) {
                continue;
            }
            TreeMap<LocalDate, Reservation> m = roomMap.get(room);
            String g = m.get(chosen).getGuest().getUsername();
            unVmap.put(room,g);
        }

        return unVmap;
    }

    /**
     * Gets all stay durations of each room
     * @param room
     * @return
     */
    public List<StayDuration> getRoomDuration(Room room){
        List<StayDuration> roomDuration = new ArrayList<>();
        TreeMap<LocalDate, Reservation> m = roomMap.get(room);

        for (Reservation r : m.values()) {
            StayDuration s = r.getDuration();
            roomDuration.add(s);
        }
        return roomDuration;
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

    public Map<Room, TreeMap<LocalDate, Reservation>> getRoomMap() {
        return roomMap;
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
