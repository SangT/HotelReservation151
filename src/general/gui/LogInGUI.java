package general.gui;

import general.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LogInGUI.java - A class to have user log in
 * @author Sang To and Yiyi Zhang
 * @version 1.0
 */
public class LogInGUI extends JPanel {
    public LogInGUI(Hotel hotel) {
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

        JButton btn = new JButton("Sign In");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String idInput = textField.getText();
                String passInput = passT.getText();

                if(hotel.logIn(idInput, passInput))
                {
                    header.setVisible(false);
                    page.setVisible(false);
                    btn.setVisible(false);
                    RevOption option = new RevOption(hotel);
                    add(option);
                } else {
                    JLabel warning = new JLabel("Please input correct id and password!");
                    add(warning);
                }

            }
        });
        add(header);
        add(page);
        add(btn);
    }
}
