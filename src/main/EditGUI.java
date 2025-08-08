package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditGUI extends JFrame {

	private JFrame frame;
    private JPanel contentPane;
    private JTextField txtRoomId;
    private JTextField txtType;
    private JTextField txtCustomerName;
    private JTextField txtPricing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditGUI window = new EditGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditGUI() {
		initialize();
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
	    
	    JRadioButton btnAvailability = new JRadioButton("Availability");
	    btnAvailability.setBounds(172, 65, 141, 23);
	    contentPane.add(btnAvailability);
	    
	    JLabel lblRoomId = new JLabel("Room ID");
	    lblRoomId.setBounds(86, 32, 61, 16);
	    contentPane.add(lblRoomId);
	    
	    JLabel lblType = new JLabel("Type");
	    lblType.setBounds(86, 101, 61, 16);
	    contentPane.add(lblType);
	    
	    JLabel lblCustomerName = new JLabel("Customer name");
	    lblCustomerName.setBounds(41, 144, 124, 16);
	    contentPane.add(lblCustomerName);
	    
	    JLabel lblPricing = new JLabel("Pricing");
	    lblPricing.setBounds(86, 182, 43, 16);
	    contentPane.add(lblPricing);
	    
	    JButton btnSearch = new JButton("Search");
	    btnSearch.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) { 
	            // TODO: SEARCH 
	        	
	        }
	    });
	    btnSearch.setBounds(314, 27, 100, 29);
	    contentPane.add(btnSearch);
	    
	    JButton btnCancel = new JButton("Cancel");
	    btnCancel.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) { // open adminGUI
	        	MainAdminGUI adminGUI = new MainAdminGUI();
		        adminGUI.setVisible(true);
	            dispose();
	        }
	    });
	    btnCancel.setBounds(88, 225, 117, 29);
	    contentPane.add(btnCancel);
	    
	    JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) { // open adminGUI
	            // TODO: SAVE DATA
	        	MainAdminGUI adminGUI = new MainAdminGUI();
		        adminGUI.setVisible(true);
	            dispose();
	        }
	    });
	    btnSave.setBounds(246, 225, 117, 29);
	    contentPane.add(btnSave);

	}
}
