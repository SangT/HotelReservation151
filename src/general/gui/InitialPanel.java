package general.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel extends JPanel
{
    public InitialPanel()
    {
        JButton gBtn = new JButton("Guest");
        JButton mBtn = new JButton("Manager");

        gBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(gBtn);
        add(mBtn);
    }
}
