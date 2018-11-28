package strategypattern;

import general.user.Reservation;

public interface ReceiptFormatter {
    String formatHeader();
    String formatReservation(Reservation r);
    String formatFooter();
}
