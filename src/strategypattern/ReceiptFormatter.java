package strategypattern;

import mvc.Reservation;

public interface ReceiptFormatter {
    String formatHeader();
    String formatReservation(Reservation r);
    String formatFooter();
}
