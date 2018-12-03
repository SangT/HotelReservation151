package general.gui;

import javax.swing.*;

public class InitialPanel extends JPanel {
    public InitialPanel() {
        JButton mBtn = new JButton("Manager");
        JButton gBtn = new JButton("Guest");
        add(mBtn);
        add(gBtn);
    }
}
