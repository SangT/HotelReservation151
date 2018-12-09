package general.gui.guest;

import general.Hotel;
import general.user.Guest;
import general.user.Manager;
import general.user.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCancelRev extends JPanel {

    public ViewCancelRev(Hotel hotel, Guest guest, JFrame frame) {

    JLabel title = new JLabel("VIEW/CANCEL RESERVATION");
    add(title);

    JTextArea textArea = new JTextArea();
    String text = null;
    List<Reservation> r = guest.getReservationList();
    for (int j = 0; j < r.size(); j++) {
        textArea.append(r.toString() + "\n");
    }
    add(textArea, BorderLayout.CENTER);

    JLabel offer = new JLabel("Which room do you want to cancel? Please type the order number to cancel that reservation");
    add(offer, BorderLayout.AFTER_LAST_LINE);

    JTextField input = new JTextField(20);
    add(input, BorderLayout.AFTER_LAST_LINE);

    JButton cancelBtn = new JButton("Cancel Reseervation");
    cancelBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = input.getText();

        }
    });





    }
}
