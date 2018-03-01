package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Newmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newmenu frame = new Newmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Newmenu() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 976, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton sale = new JButton("SHOW SALE VEHICLES");
		sale.setBackground(new Color(135, 206, 250));
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SaleVehicle().setVisible(true);
				
			}
		});
		sale.setFont(new Font("Tahoma", Font.BOLD, 14));
		sale.setBounds(204, 182, 205, 49);
		contentPane.add(sale);
		
		JButton search = new JButton("SEARCH");
		search.setBackground(new Color(135, 206, 250));
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Searching().setVisible(true);
			}
		});
		search.setBounds(518, 182, 183, 49);
		contentPane.add(search);
		
		JButton addveh = new JButton("ADD VEHICLE");
		addveh.setBackground(new Color(135, 206, 250));
		addveh.setFont(new Font("Tahoma", Font.BOLD, 14));
		addveh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddVehicle().setVisible(true);
			}
		});
		addveh.setBounds(204, 324, 205, 49);
		contentPane.add(addveh);
		
		JButton update = new JButton("UPDATE");
		update.setBackground(new Color(135, 206, 250));
		update.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Update().setVisible(true);
			}
		});
		update.setBounds(518, 324, 183, 49);
		contentPane.add(update);
		
		JLabel lblNewLabel = new JLabel("Select any of the choices from below");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(275, 83, 340, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REMOVE VEHICLE");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new RemoveVehicle().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(370, 449, 175, 49);
		contentPane.add(btnNewButton);
	}
}
