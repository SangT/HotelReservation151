package general.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoOption extends JPanel {
    public InfoOption() {
        JButton signUpBtn = new JButton("Sign Up");
        JButton logInBtn = new JButton("Log In");

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(signUpBtn);
        add(logInBtn);
    }
}
