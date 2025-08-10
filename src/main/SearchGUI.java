package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class SearchGUI extends JFrame {

	private JFrame frame;
    private JPanel contentPane;
    private JTextField txtSearch;
    private JList list;
    private JButton btnCancel;
    private HotelController hotelController;
    private JRadioButton btnAvailability;
	/**
	 * Create the application.
	 */
	public SearchGUI(HotelController hotelController) {
		this.hotelController = hotelController;
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

		txtSearch = new JTextField();
		txtSearch.setBounds(22, 16, 130, 26);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search by Room Type");
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // TODO: SEARCH/FILTER
		    	List<Room> rooms = hotelController.searchRooms(txtSearch.getText().trim(),btnAvailability.isSelected());
		    	DefaultListModel<String> lm = new DefaultListModel<>();
		        for (Room room : rooms) {
		        	lm.addElement(room.toString()); 
		        }
		        list.setModel(lm);
		        if (rooms.isEmpty()) {
		        	JOptionPane.showMessageDialog (null, "no result for room type:"+ txtSearch.getText());
		            
		        }

		    }
		});
		btnSearch.setBounds(261, 16, 162, 29);
		contentPane.add(btnSearch);

		btnAvailability = new JRadioButton("Availability");
		btnAvailability.setBounds(152, 17, 141, 23);
		contentPane.add(btnAvailability);

		
		list = new JList<>();
		list.setBounds(22, 54, 401, 168);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane(list);
	    scrollPane.setBounds(22, 54, 401, 168); 
	    contentPane.add(scrollPane);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { //Open MainAdminGUI
		        MainAdminGUI adminGUI = new MainAdminGUI(hotelController);
		        adminGUI.setVisible(true);
		        dispose();
		    }
		});
		btnCancel.setBounds(164, 234, 117, 29);
		contentPane.add(btnCancel);
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
