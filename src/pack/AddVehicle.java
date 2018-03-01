package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
class xy extends Exception{
}
public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField regno;
	private JTextField chassisno;
	private JTextField engineno;
	private JTextField vehname;
	private JTextField vehmodel;
	private JTextField vehprice;
	private JTextField sellerfn;
	private JTextField sellerln;
	private JTextField sellerphno;
	private JTextField selleraddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicle frame = new AddVehicle();
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
	public AddVehicle() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 912, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVehicleDetails = new JLabel("Vehicle Details");
		lblVehicleDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVehicleDetails.setBounds(143, 13, 138, 29);
		contentPane.add(lblVehicleDetails);
		
		JLabel reg = new JLabel("Reg No");
		reg.setFont(new Font("Tahoma", Font.BOLD, 14));
		reg.setBounds(42, 71, 116, 29);
		contentPane.add(reg);
		
		regno = new JTextField();
		regno.setBounds(186, 74, 116, 22);
		contentPane.add(regno);
		regno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chassis No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 141, 101, 29);
		contentPane.add(lblNewLabel_1);
		
		chassisno = new JTextField();
		chassisno.setBounds(186, 144, 116, 22);
		contentPane.add(chassisno);
		chassisno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Engine No");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(42, 225, 101, 29);
		contentPane.add(lblNewLabel_2);
		
		engineno = new JTextField();
		engineno.setBounds(186, 228, 116, 22);
		contentPane.add(engineno);
		engineno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vehicle Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(42, 304, 101, 29);
		contentPane.add(lblNewLabel_3);
		
		vehname = new JTextField();
		vehname.setBounds(186, 307, 116, 22);
		contentPane.add(vehname);
		vehname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Model");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(42, 375, 101, 29);
		contentPane.add(lblNewLabel_4);
		
		vehmodel = new JTextField();
		vehmodel.setBounds(186, 378, 116, 22);
		contentPane.add(vehmodel);
		vehmodel.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(42, 450, 89, 29);
		contentPane.add(lblNewLabel_5);
		
		vehprice = new JTextField();
		vehprice.setBounds(186, 453, 116, 22);
		contentPane.add(vehprice);
		vehprice.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Seller Details");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(579, 13, 116, 29);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("First Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(487, 85, 95, 29);
		contentPane.add(lblNewLabel_7);
		
		sellerfn = new JTextField();
		sellerfn.setBounds(629, 88, 116, 22);
		contentPane.add(sellerfn);
		sellerfn.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Last Name");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(487, 175, 95, 29);
		contentPane.add(lblNewLabel_8);
		
		sellerln = new JTextField();
		sellerln.setBounds(629, 172, 116, 22);
		contentPane.add(sellerln);
		sellerln.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contact No");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(487, 268, 95, 29);
		contentPane.add(lblNewLabel_9);
		
		sellerphno = new JTextField();
		sellerphno.setBounds(629, 271, 116, 22);
		contentPane.add(sellerphno);
		sellerphno.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Address");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(487, 358, 95, 29);
		contentPane.add(lblNewLabel_10);
		
		selleraddr = new JTextField();
		selleraddr.setBounds(629, 358, 187, 46);
		contentPane.add(selleraddr);
		selleraddr.setColumns(10);
		
		JButton Save = new JButton("SAVE");
		Save.setBackground(new Color(135, 206, 250));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					if(sellerfn.getText().equals("")||sellerln.getText().equals("")||sellerphno.getText().equals("")||selleraddr.getText().equals("")||engineno.getText().equals("")||chassisno.getText().equals("")||vehname.getText().equals("")||vehmodel.getText().equals("")||vehprice.getText().equals("")){
						
						throw new xy();
					}
					
					
						//int m = Integer.parseInt(vehmodel.getText());
						//step1 load the driver class  
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						  
						//step2 create  the connection object  
						Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","vishal"); 
						
						
						PreparedStatement st=con.prepareStatement("insert into tempvehicle values(?,?,?,?,?,?)");
						
						st.setString(1,regno.getText());
						st.setString(2,chassisno.getText());
						st.setString(3,engineno.getText());
						st.setString(4,vehname.getText());
						st.setInt(5,Integer.parseInt(vehmodel.getText()));
						st.setInt(6,Integer.parseInt(vehprice.getText()));
						
						ResultSet rs=st.executeQuery();
						if(rs.next()){}
						//JOptionPane.showMessageDialog(null,"Inserted into tempvehicle");
						
						 st=con.prepareStatement("select max(seller_id) from tempseller");
						rs=st.executeQuery();
						if(rs.next()){}
						int id = rs.getInt(1);
							id = id + 1;
							
							st=con.prepareStatement("insert into tempseller values(?,?,?,?,?,?)");
							st.setInt(1,id);
							st.setString(2,sellerfn.getText());
							st.setString(3,sellerln.getText());
							st.setString(4,sellerphno.getText());
							st.setString(5,selleraddr.getText());
							st.setString(6,regno.getText());
							rs=st.executeQuery();
							if(rs.next()){}
						//	JOptionPane.showMessageDialog(null,"Inserted into tempseller");	
							
							
							
							con.close();
				}catch(Exception q){
					JOptionPane.showMessageDialog(null,q);
				}
				
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(388, 478, 116, 38);
		contentPane.add(Save);
		
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
	}
}
