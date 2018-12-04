package general.gui;

import javax.swing.*;
import java.awt.*;

public class LogInGUI extends JPanel {
    public LogInGUI() {
        JPanel header = new JPanel();
        header.add(new JLabel("LOG IN"));

        GridLayout layout = new GridLayout(2,4);
        final  JPanel page = new JPanel();
        page.setLayout(layout);
        JLabel id = new JLabel("User ID");
        JLabel pass = new JLabel("Password");
        JTextField textField = new JTextField(20);
        JTextField passT = new JPasswordField(20);
        // Add to GridLayout page
        page.add(id);
        page.add(textField);
        page.add(pass);
        page.add(passT);

        add(header);
        add(page);
    }
}
