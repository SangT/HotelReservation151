package general;

import general.gui.MainFrame;
import general.user.Manager;

/**
 * System.java - the main class that has the methods to execute the program
 * @author Sang To
 * @version 1.0
 */
public class System {

    public static void main(String[] args) {
        Hotel hotel = Hotel.loadHotel();
        if (hotel==null) {
            hotel = new Hotel();
        }
        Manager manager = new Manager(hotel);

        MainFrame frame = new MainFrame(hotel, manager);



        hotel.saveHotel();
        java.lang.System.out.println("DANKMEMES");
    }
}
