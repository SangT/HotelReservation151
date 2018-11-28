package general.user;

import java.time.LocalDate;

/**
 * Duration.java - A class to define duration of stay
 */
public class Duration {
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Duration(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean isValid() {
        if (checkOut.isEqual(checkIn) || checkOut.isBefore(checkIn)) {
            return false;
        }

        // The length of stay cannot be longer than 60 nights
        if (checkOut.isAfter(checkIn.plusDays(60))) {
            return false;
        }
        return true;
    }

}
