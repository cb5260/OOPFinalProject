package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JFrame frame;
    private JPanel contentPane;
    private HotelController hotelController;


	/**
	 * Create the application.
	 */
	public MainGUI(HotelController hotelController) {
		this.hotelController =hotelController;
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
        
        JButton btnAdmin = new JButton("ADMIN");
        btnAdmin.addActionListener(new ActionListener() { // Open MainAdminGUI
            public void actionPerformed(ActionEvent e) {
                MainAdminGUI adminGUI = new MainAdminGUI(hotelController);
                adminGUI.setVisible(true);
                dispose();
            }
        });
        btnAdmin.setBounds(166, 61, 117, 29);
        contentPane.add(btnAdmin);
        
        JButton btnCustomer = new JButton("CUSTOMER");
        btnCustomer.addActionListener(new ActionListener() { // MainCustomerGUI
            public void actionPerformed(ActionEvent e) {
            	MainCustomerGUI customerGUI = new MainCustomerGUI(hotelController);
                customerGUI.setVisible(true);
                dispose();
            }
        });
        btnCustomer.setBounds(166, 123, 117, 29);
        contentPane.add(btnCustomer);
    }
}
