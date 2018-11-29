package general.user;

import java.time.LocalDate;

/**
 * StayDuration.java - A class to define duration of stay
 * @author Sang To
 * @version 1.0
 */
public class StayDuration {
    private LocalDate checkIn;
    private LocalDate checkOut;

    /**
     * Contructor takes in checkIn and checkOut date
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
        return checkOut.isAfter(checkIn.plusDays(60));
    }

}
