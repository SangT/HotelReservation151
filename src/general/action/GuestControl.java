package general.action;

import general.RoomType;

import java.time.LocalDate;

/**
 * A class to perform Guest functions
 * @author Sang To
 * @version 1.0
 */
public class GuestControl extends LogIn {
    public GuestControl(String id, String pass) {
        super(id, pass);
    }

    public void makeReservation(LocalDate in, LocalDate out, RoomType type) {
        if (out.isEqual(in) && out.isBefore(in)) {
            System.out.println("Invalid dates. Please input again.");
            return;
        }
    }

    // retrieve information from reservations.txt file
    public void viewReservation() {

    }

    // guest can cancel reservation here after viewing reservations
    public void cancelReservation() {

    }

}
