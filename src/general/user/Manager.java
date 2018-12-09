package general.user;

import general.Hotel;
import general.Room;

import java.io.Serializable;
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
public class Manager extends Account implements Serializable {
    public Manager(Hotel hotel) {
        super( hotel,"manager", "managerpasscode");
    }
}
