package general.gui;

import general.Hotel;
import general.gui.guest.InfoOption;
import general.user.Manager;

import javax.swing.*;

public class InitialPanel extends JPanel
{
    public InitialPanel(Hotel hotel, Manager manager, JFrame frame)
    {
        JButton gBtn = new JButton("Guest");
        JButton mBtn = new JButton("Manager");

        gBtn.addActionListener(e -> {
            InfoOption infoOption = new InfoOption(hotel, manager,frame);
            gBtn.setVisible(false);
            mBtn.setVisible(false);
//            add(infoOption);
            frame.setContentPane(infoOption);
        });

        mBtn.addActionListener(e -> {
            LogInView logInView = new LogInView(hotel, manager,frame);
            gBtn.setVisible(false);
            mBtn.setVisible(false);
//            add(logInView);
            frame.setContentPane(logInView);
        });

        add(gBtn);
        add(mBtn);
    }
}
