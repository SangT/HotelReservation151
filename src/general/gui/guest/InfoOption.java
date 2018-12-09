package general.gui.guest;

import general.Hotel;
import general.gui.LogInView;
import general.gui.guest.SignUpView;
import general.user.Guest;
import general.user.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InfoOption.java - A class to show two option buttons- Sign Up and Log In
 * @author Sang To
 * @version 1.0
 */
public class InfoOption extends JPanel {
    public InfoOption(Hotel hotel, Manager manager, Guest guest, JFrame frame) {
        JButton signUpBtn = new JButton("Sign Up");
        JButton logInBtn = new JButton("Log In");

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpView createAccount = new SignUpView(hotel,guest,frame);
                signUpBtn.setVisible(false);
                logInBtn.setVisible(false);
                frame.setContentPane(createAccount);
            }
        });

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInView logPage = new LogInView(hotel, manager,guest,frame);
                signUpBtn.setVisible(false);
                logInBtn.setVisible(false);
                frame.setContentPane(logPage);
            }
        });

        add(signUpBtn);
        add(logInBtn);
    }
}
