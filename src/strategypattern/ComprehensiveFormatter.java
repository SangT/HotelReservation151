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

    public ComprehensiveFormatter() {

    }

    public String formatHeader() {
        total = 0;
        return "\tR\tE\tC\tE\tI\tP\tT\n";
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