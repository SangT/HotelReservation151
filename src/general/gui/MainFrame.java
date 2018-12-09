package general.gui;

import general.Hotel;
import general.user.Manager;

import javax.swing.*;

/**
 * MainFrame.java - A class to complete GUI
 * @author Sang To
 * @version 1.0
 */
public class MainFrame extends JFrame {
    public static final int F_WIDTH = 600;
    public static final int F_HEIGHT = 700;

    public MainFrame(Hotel hotel, Manager manager, JFrame frame) {
        setTitle("Hotel Management System");
        setSize(F_WIDTH, F_HEIGHT);

        JPanel mainPanel = new InitialPanel(hotel, manager,frame);
        setContentPane(mainPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
