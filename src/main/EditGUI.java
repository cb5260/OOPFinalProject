package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditGUI extends JFrame {
	
    private Room currentRoom;
	private JFrame frame;
    private JPanel contentPane;
    private JTextField txtRoomId;
    private JTextField txtType;
    private JTextField txtCustomerName;
    private JTextField txtPricing;
    private JRadioButton btnAvailability;
    private HotelController hotelController;
    private JButton btnSave;
    private JLabel lblRoomId;
    private JLabel lblType;
    private JLabel lblCustomerName;
    private JLabel lblPricing;
    private JButton btnCancel;




	/**
	 * Create the application.
	 */
	public EditGUI(Room currentRoom, HotelController hotelController){
		this.hotelController = hotelController;
		this.currentRoom = currentRoom;
		initialize();
		addData();
	}

	private void addData() {
		// TODO Auto-generated method stub
        txtRoomId.setText(String.valueOf(currentRoom.getRoomId()));
        txtType.setText(currentRoom.getType().toString());
        txtCustomerName.setText(currentRoom.getCustomerName() != null ? 
            currentRoom.getCustomerName() : "");
        txtPricing.setText(String.valueOf(currentRoom.getPrice()));
        btnAvailability.setSelected(currentRoom.isAvailable());

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
	    
	    txtRoomId = new JTextField();
	    txtRoomId.setEditable(false);
	    txtRoomId.setBounds(172, 27, 130, 26);
	    contentPane.add(txtRoomId);
	    txtRoomId.setColumns(10);
	    
	    txtType = new JTextField();
	    txtType.setColumns(10);
	    txtType.setBounds(172, 100, 130, 26);
	    contentPane.add(txtType);
	    
	    txtCustomerName = new JTextField();
	    txtCustomerName.setColumns(10);
	    txtCustomerName.setBounds(172, 139, 130, 26);
	    contentPane.add(txtCustomerName);
	    
	    txtPricing = new JTextField();
	    txtPricing.setColumns(10);
	    txtPricing.setBounds(172, 177, 130, 26);
	    contentPane.add(txtPricing);
	    
	    btnAvailability = new JRadioButton("Availability");
	    btnAvailability.setBounds(172, 65, 141, 23);
	    contentPane.add(btnAvailability);
	    
	    lblRoomId = new JLabel("Room ID");
	    lblRoomId.setBounds(86, 32, 61, 16);
	    contentPane.add(lblRoomId);
	    
	    lblType = new JLabel("Type");
	    lblType.setBounds(86, 101, 61, 16);
	    contentPane.add(lblType);
	    
	    lblCustomerName = new JLabel("Customer name");
	    lblCustomerName.setBounds(41, 144, 124, 16);
	    contentPane.add(lblCustomerName);
	    
	    lblPricing = new JLabel("Pricing");
	    lblPricing.setBounds(86, 182, 43, 16);
	    contentPane.add(lblPricing);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) { // open adminGUI
	        	MainAdminGUI adminGUI = new MainAdminGUI(hotelController);
		        adminGUI.setVisible(true);
	            dispose();
	        }
	    });
	    btnCancel.setBounds(88, 225, 117, 29);
	    contentPane.add(btnCancel);
	    
	    btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) { // open adminGUI
	        	try{
	        	hotelController.editRoom(
	        			Integer.parseInt(txtRoomId.getText()),
	        			txtType.getText(),
	        			Double.parseDouble(txtPricing.getText()),
	        			btnAvailability.isSelected(),
	        			txtCustomerName.getText()
	        			);
	        	JOptionPane.showMessageDialog(null, "saved");
	        	}
	        	catch (Exception e1){
	        		JOptionPane.showMessageDialog(null, "error: numbers only for price");
	        	}
	        	MainAdminGUI adminGUI = new MainAdminGUI(hotelController);
		        adminGUI.setVisible(true);
	            dispose();
	        }
	    });
	    btnSave.setBounds(246, 225, 117, 29);
	    contentPane.add(btnSave);

	}
}
