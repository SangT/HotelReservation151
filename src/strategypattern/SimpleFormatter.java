package strategypattern;

import general.user.Reservation;

public class SimpleFormatter implements ReceiptFormatter {
    private double total;

    public String formatHeader() {
        total = 0;
        return "\tR\tE\tC\tE\tI\tP\tT\n";
    }

    public String formatReservation(Reservation r) {
//        total += r.getPrice();
        return null;
    }

    public String formatFooter() {
        return null;
    }
}
