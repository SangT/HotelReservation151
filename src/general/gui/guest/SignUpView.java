package general.gui.guest;

import general.Hotel;

import javax.swing.*;
import java.awt.*;

/**
 * SignUpView.java - A class to have user sign up for first timer
 * @author Sang To and Yiyi Zhang
 * @version 1.0
 */
public class SignUpView extends JPanel {
    public SignUpView(Hotel hotel) {
        JPanel header = new JPanel();
        header.add(new JLabel("CREATE A NEW ACCOUNT"));

        GridLayout layout = new GridLayout(3,4);
        final  JPanel page = new JPanel();
        page.setLayout(layout);

        JLabel name = new JLabel("Username");
        JLabel id = new JLabel("User ID");
        JLabel pass = new JLabel("Password");
        JTextField nameField = new JTextField(20);
        JTextField idField = new JTextField(20);
        JTextField passField = new JPasswordField(20);

        // Add to GridLayout page
        page.add(name);
        page.add(nameField);
        page.add(id);
        page.add(idField);
        page.add(pass);
        page.add(passField);

        JButton btn = new JButton("Sign Up");
        btn.addActionListener(event -> {
            String nameInput = nameField.getText();
            String idInput = idField.getText();
            String passInput = passField.getText();

            if(hotel.signUp(nameInput,idInput,passInput))
            {
                header.setVisible(false);
                page.setVisible(false);
                btn.setVisible(false);
                RevOption option = new RevOption(hotel);
                add(option);
            } else {
                JLabel warning = new JLabel("This id already exists. Please choose another id!");
                add(warning);
            }

        });
        add(header);
        add(page);
        add(btn);
    }
}
