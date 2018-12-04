package general.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static final int F_WIDTH = 600;
    public static final int F_HEIGHT = 700;

    public MainFrame() {
        setTitle("Hotel Management System");
        setSize(F_WIDTH, F_HEIGHT);

        InitialPanel mainPanel = new InitialPanel();
        add(mainPanel);

    }
}
