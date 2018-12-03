package general.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Manager.java - A class to store manager information
 * 
 * The hotel manager can load existing reservations, view information, save reservations, and quit the system
 * 
 * @author Sang To & Matt Ruben
 * @version 1.0
 */
public class Manager extends Account {
	
	private List<Reservation> reservationList;
	private Map<LocalDate, Reservation> map;
	
	public Manager() {
		super("manager", "managerpasscode");
		reservationList = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public void loadReservations() {
		File reservationsFile = new File("reservations.txt");
		Scanner fScanner;
		ArrayList<String> fileLines = new ArrayList<>();
		try {
			fScanner = new Scanner(reservationsFile);
			fScanner.useDelimiter("\r"); // separate by line
			while(fScanner.hasNext()) { // read all lines into fileLines
				String next = fScanner.next();
				fileLines.add(next);
			}
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		// Parse incoming data
		for (int i = 0; i < fileLines.size(); i++) {
			String temp = fileLines.get(i);
			String[] substrings = temp.split(":");
			
			String date, guestName, startMonth, startDay, endMonth, endDay= "";
			
			// If true, line is date in MM/DD/YYYY format
			if (substrings.length == 1 && !substrings[1].endsWith(":")) {
				date = substrings[0];
			}
			// If true, line is Guest Name
			else if (substrings.length == 1 && substrings[1].endsWith(":")) {
				guestName = substrings[0];
			}
			else if (substrings[0].startsWith("Room ")) {
				startMonth = substrings[1].substring(1, 3);
				startDay = substrings[1].substring(4, 6);
				endMonth = substrings[1].substring(9, 11);
				endDay = substrings[1].substring(12, 14);
				
			}
			System.out.println(date);
		}
	}
	
	public void viewInformation() {
		
	}
	
	public void saveReservations() {
		
	}
	
	public void quit() {
		
	}
	
	/**
	 * Manager.class tester
	 * @param args
	 */
	public static void main(String[] args) {
		Manager m = new Manager();
		m.loadReservations();
	}
}
