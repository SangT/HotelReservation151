package strategypattern;

import general.user.Guest;
import general.user.Reservation;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Matt Ruben
 */
public class ComprehensiveFormatter implements ReceiptFormatter {
    private double total;

    public String formatHeader() {
        total = 0;
        return " C  O  M  P  R  E  H  E  N  S  I  V  E    R  E  C  E  I  P  T\n";
    }

    public String formatReservation(Reservation r) {
        Guest myGuest = r.getGuest();

        String string = formatHeader();

        List<Reservation> reservationList = myGuest.getReservationList();

        Collections.sort(reservationList);

        total = 0;
        for (Reservation reservation : reservationList) {
            string += reservation.toString() + "\n";
            total += reservation.getCost();
        }

        string += formatFooter();


        return string;
    }

    public String formatFooter() {
        return "\n"
                + "\n"
                + "Total Cost: $" + total + "0.";
    }
}