package general.user;

import general.Hotel;
import general.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manager.java - A class to store manager information
 * @author Sang To
 * @version 1.0
 */
public class Manager extends Account {
    public Manager(Hotel h) {
        super(h, "manager", "managerpasscode");
    }
}
