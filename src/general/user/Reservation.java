package general.user;

import general.Room;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author Sang To and Matt Ruben
 * @version 1.0
 */
public class Reservation implements Comparable<Reservation> {
    /*
    Each reservation record knows who made this reservation, which room is assigned,
    and the period of the reservation
    */
    private Guest guest;
    private Room room;
    private StayDuration duration;
    private LocalDate booked;
    private double cost;

    public Reservation(Guest guest, Room room, StayDuration duration, LocalDate booked) {
        this.guest = guest;
        this.room = room;
        this.duration = duration;
        this.booked = booked;
        calcCost();
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public StayDuration getDuration() {
        return duration;
    }

    public LocalDate getBooked() {
        return booked;
    }

    public double getCost() {
        return cost;
    }

    private void calcCost() {
        LocalDate startDate = duration.getCheckIn();
        LocalDate endDate = duration.getCheckOut();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        cost = daysBetween * room.getType().getPrice();
    }



    /**
     * Compares reservations by their 1) Check In Date, 2) Check Out Date, and 3) Date of Booking
     * @param b
     * @return
     */
    @Override
    public int compareTo(Reservation b) {
        // Compare Start Dates
        if (this.getDuration().getCheckIn().compareTo(b.getDuration().getCheckIn()) > 0) {
            return 1;
        } else if (this.getDuration().getCheckIn().compareTo(b.getDuration().getCheckIn()) < 0) {
            return -1;
        }

        // Compare End Dates - if reservations share start dates, the earliest end date would be earlier in array
        if (this.getDuration().getCheckOut().compareTo(b.getDuration().getCheckOut()) > 0) {
            return 1;
        } else if (this.getDuration().getCheckOut().compareTo(b.getDuration().getCheckOut()) < 0) {
            return -1;
        }

        return this.getBooked().compareTo(b.getBooked());
    }

    @Override
    public String toString() {

        String s = room.toString() +
                " " +
                duration.getCheckIn().format(DateTimeFormatter.ofPattern("M/d/u")) +
                " - " +
                duration.getCheckOut().format(DateTimeFormatter.ofPattern("M/d/u")) +
                " Price: $" +
                getCost() + '0';
        return s;
    }
}
