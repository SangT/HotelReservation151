/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general.gui.manager;

import general.Hotel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Matt Ruben
 */
public class ManagerGUI extends JFrame {
    
    private BorderLayout borderLayout;
    private JLabel frameTitleLabel;

    // Calendar Panel:
    private JPanel calendarPanel;
    private JLabel currentMonthLabel;
    private JScrollPane calendarScrollPane;
    private JTable calendarTable;
    
    // Room Info Panel:
    private JPanel roomInfoPanel;
    private JLabel roomReservationsTitle;
    private JScrollPane allRoomInfoScrollPane;
    private JTextArea allRoomInfoTextArea;
    
    // Room View Panel:
    private JPanel roomView;
    private JScrollPane roomSelectionScrollPane;
    private JList<String> roomSelectionList;
    
    // Selected Room Info Panel:
    private JPanel selectedRoomInfoPanel;
    private JScrollPane selectedRoomScrollPane;
    private JTextArea selectedRoomTextArea;
    
    
    // Save & Quit Button Panel:
    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton quitButton;
    
//    public static void main(String args[]) {
//        /* Set the System look and feel */
//        try {
//           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException |
//                InstantiationException |
//                IllegalAccessException |
//                UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new ManagerGUI().setVisible(true);
//            }
//        });
//    }
    
    public ManagerGUI(Hotel hotel) {
        borderLayout = new BorderLayout(15, 15);
        
        createComponents();
        setVisible(true);
        setBounds(0, 0, 770, 770);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(borderLayout);
    }
    
    /**
     * Handles initialization of components
     */
    private void createComponents() {
        // Calendar Panel:
        calendarPanel = new JPanel();
        currentMonthLabel = new JLabel();
        calendarScrollPane = new JScrollPane();
        calendarTable = new JTable();

        // Room Info Panel:
        roomInfoPanel = new JPanel();
        roomReservationsTitle = new JLabel();
        allRoomInfoScrollPane = new JScrollPane();
        allRoomInfoTextArea = new JTextArea();

        // Room View Panel:
        roomView = new JPanel();
        roomSelectionScrollPane = new JScrollPane();
        roomSelectionList = new JList<>();

        // Selected Room Info Panel:
        selectedRoomInfoPanel = new JPanel();
        selectedRoomScrollPane = new JScrollPane();
        selectedRoomTextArea = new JTextArea();


        // Save & Quit Button Panel:
        buttonPanel = new JPanel();
        saveButton = new JButton();
        quitButton = new JButton();
        setupComponents();
    }
    
    /**
     * Handles Save Button Presses
     * @param event 
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }
    
    /**
     * Handles Quit Button Presses
     * @param event 
     */
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.dispose();
    }  
    
    /**
     * Handles placement of all Swing components
     */
    private void setupComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Specify Calendar
        currentMonthLabel.setText("December 2018");
        currentMonthLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        calendarTable.setModel(new DefaultTableModel(
            new Object [][] {
                {"", "1", "2", "3", "4", "5", "6"},
                {"7", "8", "9", "10", "11", "12", "13"},
                {"14", "15", "16", "17", "18", "19", "20"},
                {"21", "22", "23", "24", "25", "26", "27"},
                {"28", "29", "30", "", "", "", ""}
            },
            new String [] {
                "Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"
            }
        ));
                
        calendarScrollPane.setViewportView(calendarTable);
        calendarTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        // Adds Calendar items to their respective layouts
        GroupLayout calendarPanelLayout = new GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(currentMonthLabel)
            .addComponent(calendarScrollPane, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addComponent(currentMonthLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendarScrollPane, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
            )
        );
        
        // Specifies Room Reservations items
        roomReservationsTitle.setText("Today's Room Reservations");

        allRoomInfoTextArea.setColumns(20);
        allRoomInfoTextArea.setRows(5);
        allRoomInfoTextArea.setText("Room information\n\nAvailable Rooms:\nRoom 1\nRoom 2\n\nReserved Rooms:\nRoom 12\nRoom 15");
        allRoomInfoScrollPane.setViewportView(allRoomInfoTextArea);
        
        // Adds Room Reservations items to their respective layouts
        GroupLayout roomInfoPanelLayout = new GroupLayout(roomInfoPanel);
        roomInfoPanel.setLayout(roomInfoPanelLayout);
        roomInfoPanelLayout.setHorizontalGroup(
            roomInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(roomInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(roomReservationsTitle)
                    .addComponent(allRoomInfoScrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomInfoPanelLayout.setVerticalGroup(
            roomInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(roomInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomReservationsTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allRoomInfoScrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // Configures Save & Quit Buttons
        saveButton.setText("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                saveButtonActionPerformed(event);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                quitButtonActionPerformed(event);
            }
        });
        
        // Adds Save & Quit Buttons to their respective panel and layouts
        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addComponent(saveButton)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(quitButton)
            )
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(quitButton)
                )
            )
        );
        
        // Specifies Room Selection List Items
        roomSelectionList.setModel(new AbstractListModel<String>() {
            String[] strings = { "Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6", "Room 7", "Room 8", "Room 9", "Room 10", "Room 11", "Room 12", "Room 13", "Room 14", "Room 15", "Room 16", "Room 17", "Room 18", "Room 19", "Room 20", " " };
            public int getSize() {
                return strings.length;
            }
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        roomSelectionScrollPane.setViewportView(roomSelectionList);
        
        // Adds Room Selection List items to their respective layouts
        GroupLayout roomViewLayout = new GroupLayout(roomView);
        roomViewLayout.addLayoutComponent(rootPane, SOMEBITS);
        roomView.setLayout(roomViewLayout);
        roomViewLayout.setHorizontalGroup(
            roomViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(roomViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomSelectionScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomViewLayout.setVerticalGroup(
            roomViewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(roomViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomSelectionScrollPane, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        // Specifies Manager Label
        frameTitleLabel.setFont(new Font("Dialog", 0, 24));
        frameTitleLabel.setText("Manager");
        frameTitleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        
        // Specifies Selected Room Area Items
        selectedRoomTextArea.setColumns(20);
        selectedRoomTextArea.setLineWrap(true);
        selectedRoomTextArea.setRows(5);
        selectedRoomTextArea.setText("Information of the selected room goes here.");
        selectedRoomScrollPane.setViewportView(selectedRoomTextArea);
        
        // Add Selected Room Items to their respective layouts
        GroupLayout selectedRoomInfoPanelLayout = new GroupLayout(selectedRoomInfoPanel);
        selectedRoomInfoPanel.setLayout(selectedRoomInfoPanelLayout);
        selectedRoomInfoPanelLayout.setHorizontalGroup(
            selectedRoomInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(selectedRoomInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedRoomScrollPane, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        selectedRoomInfoPanelLayout.setVerticalGroup(
            selectedRoomInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(selectedRoomInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedRoomScrollPane, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        // Create all-encompassing layout and add all previous panels to it
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(calendarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(roomView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                        .addComponent(selectedRoomInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frameTitleLabel)
                .addGap(321, 321, 321))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameTitleLabel)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(calendarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(selectedRoomInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
}
