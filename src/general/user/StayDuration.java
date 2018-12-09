package general.user;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * StayDuration.java - A class to define duration of stay
 * @author Sang To
 * @version 1.0
 */
public class StayDuration implements Serializable {
    private LocalDate checkIn;
    private LocalDate checkOut;

    /**
     * Constructor takes in checkIn and checkOut date
     * @param checkIn
     * @param checkOut
     */
    public StayDuration(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // The length of stay cannot be longer than 60 nights
    public boolean isValid() {
        if (checkOut.isEqual(checkIn) || checkOut.isBefore(checkIn)) {
            return false;
        }
        return !checkOut.isAfter(checkIn.plusDays(60));
    }

    public boolean isConflict(StayDuration other) {

        return !checkOut.isBefore(other.checkIn) && !checkIn.isAfter(other.checkOut);
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
