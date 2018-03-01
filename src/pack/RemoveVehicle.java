package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

class qwert extends Exception{
}
public class RemoveVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField regno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveVehicle frame = new RemoveVehicle();
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
	public RemoveVehicle() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setForeground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterVehicleRegistration = new JLabel("Enter Vehicle Registration Number to delete");
		lblEnterVehicleRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterVehicleRegistration.setBounds(160, 61, 351, 35);
		contentPane.add(lblEnterVehicleRegistration);
		
		JButton delete = new JButton("DELETE");
		delete.setBackground(new Color(135, 206, 250));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					if(regno.getText().equals(null)){
						throw new qwert();
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement( "delete from tempseller where sr_no = ?");
					st.setString(1,regno.getText());
					ResultSet rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Del seller");
					
					
					st=con.prepareStatement("delete from tempvehicle where reg_no = ?");
					st.setString(1,regno.getText());
					rs=st.executeQuery();
					if(rs.next()){}
					JOptionPane.showMessageDialog(null,"SUCCESSFUL");
					
					con.close();  
					
				}
				catch(qwert a){
					JOptionPane.showMessageDialog(null,"Field can't be null");
				}
				catch(Exception q){
					JOptionPane.showMessageDialog(null,"Enter correct registration no");
				}
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setBounds(253, 223, 126, 35);
		contentPane.add(delete);
		
		regno = new JTextField();
		regno.setBounds(247, 124, 137, 35);
		contentPane.add(regno);
		regno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(Use uppercase only)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(412, 126, 162, 35);
		contentPane.add(lblNewLabel);
		
		JButton menu = new JButton("MENU");
		menu.setBackground(new Color(135, 206, 250));
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Newmenu().setVisible(true);
				
			}
		});
		menu.setBounds(12, 13, 97, 25);
		contentPane.add(menu);
		
		JLabel lblDoNotInclude = new JLabel("(Do not include spaces)");
		lblDoNotInclude.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoNotInclude.setBounds(61, 127, 162, 26);
		contentPane.add(lblDoNotInclude);
	}

}
