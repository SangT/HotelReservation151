package strategypattern;

import general.user.Guest;
import general.user.Reservation;

import java.util.Collections;
import java.util.List;


public class SimpleFormatter implements ReceiptFormatter {
    private double total;

    public String formatHeader() {
        total = 0;
        return "   S   I   M   P   L   E       R   E   C   E   I   P   T\n";
    }

    public String formatReservation(Reservation r) {
        Guest myGuest = r.getGuest();

        String string = formatHeader();

        List<Reservation> reservationList = myGuest.getReservationList();

        Collections.sort(reservationList);

        total = 0;
        for (Reservation reservation : reservationList) {
            // only adds to reciept if *booked* on same day as passed-in reservation
            if (reservation.getBooked().equals(r.getBooked())) {
                string += reservation.toString() + "\n";
                total += reservation.getCost();
            }
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
