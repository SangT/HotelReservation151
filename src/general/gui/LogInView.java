package general.gui;

import general.Hotel;
import general.gui.guest.RevOption;
import general.gui.manager.ManagerGUI;
import general.user.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LogInView.java - A class to have user log in
 * @author Sang To and Yiyi Zhang
 * @version 1.0
 */
public class LogInView extends JPanel {
    public LogInView(Hotel hotel, Manager manager, JFrame frame) {
        JPanel header = new JPanel();
        header.add(new JLabel("LOG IN"));
        add(header);

        GridLayout layout = new GridLayout(2,2);
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
        add(page);

        JButton btn = new JButton("Sign In");
        add(btn);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String idInput = textField.getText();
                String passInput = passT.getText();

                if(hotel.logIn(idInput, passInput))
                {
                    header.setVisible(false);
                    page.setVisible(false);
                    btn.setVisible(false);
                    if (idInput.equals(manager.getId()))
                    {
                        ManagerGUI managerGUI = new ManagerGUI(hotel);
//                        add(managerGUI);
                        frame.setContentPane(managerGUI);
                        managerGUI.setVisible(true);
                    } else {
                        RevOption option = new RevOption(hotel);
//                        add(option);
                        frame.setContentPane(option);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid id or password.");
                }
            }
        });

    }
}
