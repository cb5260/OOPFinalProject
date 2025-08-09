package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainAdminGUI extends JFrame {
    private JPanel contentPane;
    private JList<String> roomList;
    private HotelController hotelController;


    public MainAdminGUI(HotelController hotelController) {
        this.hotelController = hotelController; 
        initialize();
        loadRooms(); 
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        roomList = new JList<>();
        roomList.setBounds(18, 30, 278, 209);
        contentPane.add(roomList);
        
        JScrollPane scrollPane = new JScrollPane(roomList);
        scrollPane.setBounds(18, 30, 278, 209); // Same bounds as your original list
        contentPane.add(scrollPane);
        // Go to EDIT
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = roomList.getSelectedIndex();
                if (i != -1) {
                    EditGUI editGUI = new EditGUI(hotelController.getAllRooms().get(i), hotelController);
                    editGUI.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "select a room to edit");
                }
            }
        });
        btnEdit.setBounds(308, 49, 117, 29);
        contentPane.add(btnEdit);
        // END EDIT
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchGUI searchGUI = new SearchGUI(hotelController);
                searchGUI.setVisible(true);
                dispose();
            }
        });
        btnSearch.setBounds(308, 112, 117, 29);
        contentPane.add(btnSearch);
        
        JButton btnLogout = new JButton("LogOut");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainGUI mainGUI = new MainGUI(hotelController);
                mainGUI.setVisible(true);
                dispose();
            }
        });
        btnLogout.setBounds(308, 178, 117, 29);
        contentPane.add(btnLogout);
    }

    private void loadRooms() {
        List<Room> rooms = hotelController.getAllRooms();
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (Room room : rooms) {
        	lm.addElement(room.toString());
        }
        roomList.setModel(lm);
    }
}