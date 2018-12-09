package general.gui.guest;

import general.Hotel;
import general.gui.MakeRev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RevOption.java - A class to show two option buttons to make a reservation or vew/cancel one
 * @author Sang To
 * @version 1.0
 */
public class RevOption extends JPanel {
    public RevOption(Hotel hotel) {
        JButton makeBtn = new JButton("Make a Reservation");
        JButton vcBtn = new JButton("View/Cancel a Reservation");

        makeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MakeRev mr = new MakeRev();
                makeBtn.setVisible(false);
                vcBtn.setVisible(false);
                add(mr);
            }
        });

        vcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCancelRev vcr = new ViewCancelRev();
                makeBtn.setVisible(false);
                vcBtn.setVisible(false);
                add(vcr);
            }
        });

        add(makeBtn);
        add(vcBtn);
    }
}
