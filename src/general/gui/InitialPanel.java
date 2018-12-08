package general.gui;

import general.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel extends JPanel
{
    public InitialPanel(Hotel hotel)
    {
        JButton gBtn = new JButton("Guest");
        JButton mBtn = new JButton("Manager");

        gBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoOption infoOption = new InfoOption(hotel);
                gBtn.setVisible(false);
                mBtn.setVisible(false);
                add(infoOption);
            }
        });

        mBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInView logInView = new LogInView(hotel);
                gBtn.setVisible(false);
                mBtn.setVisible(false);
                add(logInView);
            }
        });

        add(gBtn);
        add(mBtn);
    }
}
