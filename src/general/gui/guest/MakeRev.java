package general.gui.guest;

import general.Hotel;
import general.user.Guest;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * MakeRev.java - A class to let guest make a reservation
 * @author Sang To
 * @version 1.0
 */
public class MakeRev extends JPanel {

    public MakeRev(Hotel hotel, Guest guest, JFrame frame) {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel header = new JPanel();
        header.add(new JLabel("MAKE A RESERVATION"));
        add(header);

        GridLayout layout = new GridLayout(2,2);
        final  JPanel dateArea = new JPanel();
        dateArea.setLayout(layout);

        JLabel checkIn = new JLabel("Checkin date");
        JLabel checkOut = new JLabel("Checkout date");
        JTextField checkInText = new JTextField(10);
        JTextField checkOutText = new JPasswordField(10);

        // Add to GridLayout page
        dateArea.add(checkIn);
        dateArea.add(checkOut);
        dateArea.add(checkInText);
        dateArea.add(checkOutText);
        add(dateArea);


        JPanel roomTypeArea =  new JPanel();

        JLabel roomTyle = new JLabel("Room Type:");
        JButton btnLuxury = new JButton("$300");
        JButton btnEconomy = new JButton("$100");
        JButton btnShowAvai = new JButton("Show Me Available Rooms");

        roomTypeArea.add(roomTyle);
        roomTypeArea.add(btnLuxury);
        roomTypeArea.add(btnEconomy);
        roomTypeArea.add(btnShowAvai);
        add(roomTypeArea);

        btnLuxury.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set luxury type
            }
        });

        btnEconomy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set econmy type
            }
        });

        btnShowAvai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show repaint the list available rooms
            }
        });



        JPanel showListArea = new JPanel();

        showListArea.setLayout(new BoxLayout(showListArea, BoxLayout.PAGE_AXIS));

        JLabel durationChosen = new JLabel("Avalable Rooms " /* + cai duaration da chon*/);
        JLabel listAvaiRooms = new JLabel("List available rooms:");

        JList list = new JList(/*truyen vao danh sach phong trong*/);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);

        showListArea.add(durationChosen);
        showListArea.add(listAvaiRooms);
        showListArea.add(listScroller);

        JPanel chosenRoomArea =  new JPanel();
        chosenRoomArea.setLayout(new BoxLayout(chosenRoomArea, BoxLayout.PAGE_AXIS));

        JTextField inputChosenRoom = new JTextField();

        JPanel comfirmChosen = new JPanel();
        JButton btnConfirm = new JButton();
        JButton btnMoreRes = new JButton();
        JButton btnDone = new JButton();

        comfirmChosen.add(btnConfirm);
        comfirmChosen.add(btnMoreRes);
        comfirmChosen.add(btnDone);

        chosenRoomArea.add(inputChosenRoom);
        chosenRoomArea.add(comfirmChosen);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lay cai thoi tin text input tren kia roi tao reservation
            }
        });

        btnMoreRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tao cai reservation khac khi da confirm cai o tren con neu chua confirm thi thong bao cai kia chua confirm co muon confirm khong
            }
        });


        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hoi la muon confirm khong khi ma chua confirm con neu da confirm roi thi chi can thoat ra thoi
            }
        });


    }
}
