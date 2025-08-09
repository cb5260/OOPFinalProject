package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainCustomerGUI extends JFrame {

	private JFrame frame;
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtRoomType;
    private HotelController hotelController;
    private JList list;

	/**
	 * Create the application.
	 */
	public MainCustomerGUI(HotelController hotelController) {
		this.hotelController=hotelController;
		initialize();
		loadRooms();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtName = new JTextField();
        txtName.setBounds(120, 16, 130, 26);
        contentPane.add(txtName);
        txtName.setColumns(10);
        
        txtRoomType = new JTextField();
        txtRoomType.setColumns(10);
        txtRoomType.setBounds(120, 54, 130, 26);
        contentPane.add(txtRoomType);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(26, 21, 61, 16);
        contentPane.add(lblName);
        
        JLabel lblRoomType = new JLabel("Room Type");
        lblRoomType.setBounds(26, 59, 82, 16);
        contentPane.add(lblRoomType);
        
        JButton btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// TODO: BOOKING
        		
        		
        		
        	}
        });
        btnBook.setBounds(277, 34, 117, 29);
        contentPane.add(btnBook);
        
        
        list = new JList();
        list.setBounds(33, 92, 384, 119);
        contentPane.add(list);
        
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(33, 92, 384, 119); // Same bounds as your original list
        contentPane.add(scrollPane);
        
        JButton btnLogout = new JButton("LogOut");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //Open MainGUI
                
				MainGUI mainGUI = new MainGUI(hotelController);
                mainGUI.setVisible(true);
                dispose();
            }
        });
        btnLogout.setBounds(166, 223, 117, 29);
        contentPane.add(btnLogout);

	}
    private void loadRooms() {
        List<Room> rooms = hotelController.getAllRooms();
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (Room room : rooms) {
        	lm.addElement(room.toString());
        }
        list.setModel(lm);
    }

}
