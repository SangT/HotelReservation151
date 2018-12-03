package general.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static final int WIDHT = 600;
    public static final int HEIGHT = 700;

    public MainFrame() {
        setTitle("Hotel Management System");
        setSize(WIDTH, HEIGHT);

        InitialPanel mainPanel = new InitialPanel();
        add(mainPanel);

    }
}
