package pack;
//package auto_consultancy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField sellerfn;
	private JTextField sellerln;
	private JTextField sellerphno;
	private JTextField buyerfn;
	private JTextField buyerln;
	private JTextField buyerphno;
	private JTextField regno;
	private JTextField chassisno;
	private JTextField engineno;
	private JTextField vehname;
	private JTextField vehmodel;
	private JTextField vehprice;
	
	Main m = new Main();
	private JTextField selleraddr;
	private JTextField buyeraddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
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
	public Update() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seller details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(294, 13, 130, 25);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		sellerfn = new JTextField();
		sellerfn.setBounds(339, 87, 189, 25);
		contentPane.add(sellerfn);
		sellerfn.setColumns(10);
		sellerfn.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(148, 90, 119, 22);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(148, 152, 105, 22);
		contentPane.add(lblLastName);
		lblLastName.setVisible(false);
		
		sellerln = new JTextField();
		sellerln.setBounds(339, 149, 189, 25);
		contentPane.add(sellerln);
		sellerln.setColumns(10);
		sellerln.setVisible(false);
		
		JLabel lblContactNo = new JLabel("Contact no");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactNo.setBounds(148, 224, 105, 22);
		contentPane.add(lblContactNo);
		lblContactNo.setVisible(false);
		
		
		sellerphno = new JTextField();
		sellerphno.setBounds(339, 221, 189, 25);
		contentPane.add(sellerphno);
		sellerphno.setColumns(10);
		sellerphno.setVisible(false);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(148, 292, 105, 19);
		contentPane.add(lblAddress);
		lblAddress.setVisible(false);
		
		JLabel lblBuyerDetails = new JLabel("Buyer Details");
		lblBuyerDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuyerDetails.setBounds(745, 13, 154, 25);
		contentPane.add(lblBuyerDetails);
		lblBuyerDetails.setVisible(false);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setBounds(767, 91, 105, 14);
		contentPane.add(lblFirstName);
		lblFirstName.setVisible(false);
		
		JLabel lblLastName_1 = new JLabel("Last name");
		lblLastName_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName_1.setBounds(767, 153, 90, 14);
		contentPane.add(lblLastName_1);
		lblLastName_1.setVisible(false);
		
		JLabel lblContactNo_1 = new JLabel("Contact no");
		lblContactNo_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactNo_1.setBounds(767, 225, 105, 22);
		contentPane.add(lblContactNo_1);
		lblContactNo_1.setVisible(false);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress_1.setBounds(767, 294, 90, 17);
		contentPane.add(lblAddress_1);
		lblAddress_1.setVisible(false);
		
		buyerfn = new JTextField();
		buyerfn.setBounds(939, 87, 170, 25);
		contentPane.add(buyerfn);
		buyerfn.setColumns(10);
		buyerfn.setVisible(false);
		
		buyerln = new JTextField();
		buyerln.setBounds(939, 149, 170, 25);
		contentPane.add(buyerln);
		buyerln.setColumns(10);
		buyerln.setVisible(false);
		
		buyerphno = new JTextField();
		buyerphno.setBounds(939, 221, 170, 25);
		contentPane.add(buyerphno);
		buyerphno.setColumns(10);
		buyerphno.setVisible(false);
		
		JLabel lblVehicleDetails = new JLabel("Vehicle details");
		lblVehicleDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVehicleDetails.setBounds(522, 378, 137, 25);
		contentPane.add(lblVehicleDetails);
		lblVehicleDetails.setVisible(false);
		
		JLabel lblRegistrationNo = new JLabel("Reg No");
		lblRegistrationNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrationNo.setBounds(69, 438, 84, 25);
		contentPane.add(lblRegistrationNo);
		lblRegistrationNo.setVisible(false);
		
		regno = new JTextField();
		regno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		regno.setBounds(165, 435, 179, 32);
		contentPane.add(regno);
		regno.setColumns(10);
		//regno.setEditable(false);
		
		JLabel lblChassisNo = new JLabel("Chassis No");
		lblChassisNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChassisNo.setBounds(389, 438, 94, 25);
		contentPane.add(lblChassisNo);
		lblChassisNo.setVisible(false);
		
		chassisno = new JTextField();
		chassisno.setBounds(497, 437, 185, 37);
		contentPane.add(chassisno);
		chassisno.setColumns(10);
		//chassisno.setEditable(false);
		chassisno.setVisible(false);
		
		JLabel lblEngineNo = new JLabel("Engine No");
		lblEngineNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEngineNo.setBounds(786, 440, 94, 21);
		contentPane.add(lblEngineNo);
		lblEngineNo.setVisible(false);
		
		
		engineno = new JTextField();
		engineno.setBounds(920, 433, 189, 37);
		contentPane.add(engineno);
		engineno.setColumns(10);
		//engineno.setEditable(false);
		engineno.setVisible(false);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(69, 551, 58, 21);
		contentPane.add(lblName);
		lblName.setVisible(false);
		
		vehname = new JTextField();
		vehname.setBounds(165, 543, 179, 32);
		contentPane.add(vehname);
		vehname.setColumns(10);
		vehname.setVisible(false);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModel.setBounds(389, 542, 79, 32);
		contentPane.add(lblModel);
		lblModel.setVisible(false);
		
		vehmodel = new JTextField();
		vehmodel.setBounds(497, 546, 185, 32);
		contentPane.add(vehmodel);
		vehmodel.setColumns(10);
		vehmodel.setVisible(false);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(786, 545, 94, 32);
		contentPane.add(lblPrice);
		lblPrice.setVisible(false);
		
		vehprice = new JTextField();
		vehprice.setBounds(920, 543, 189, 37);
		contentPane.add(vehprice);
		vehprice.setColumns(10);
		vehprice.setVisible(false);
		
		JButton update = new JButton("UPDATE");
		update.setBackground(new Color(204, 204, 255));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement( "update seller set seller.sfirst_name=?,seller.slast_name=?,seller.cell_no=?,seller.saddress=? where seller.seller_id=(select vehicle.s_id from vehicle where vehicle.reg_no=?)");
					st.setString(1,sellerfn.getText());
					st.setString(2,sellerln.getText());
					st.setString(3,sellerphno.getText());
					st.setString(4,selleraddr.getText());
					st.setString(5,regno.getText());
					ResultSet rs=st.executeQuery();
					if(rs.next()){}
				//	JOptionPane.showMessageDialog(null,"Updated seller details");
					
					st=con.prepareStatement( "update buyer set buyer.bfirst_name=?,buyer.blast_name=?,buyer.bcell_no=?,buyer.baddress=? where buyer.buyer_id=(select vehicle.b_id from vehicle where vehicle.reg_no=?)");
					st.setString(1,buyerfn.getText());
					st.setString(2,buyerln.getText());
					st.setString(3,buyerphno.getText());
					st.setString(4,buyeraddr.getText());
					st.setString(5,regno.getText());
					rs=st.executeQuery();
					if(rs.next()){}
				//	JOptionPane.showMessageDialog(null,"Updated buyer details");
					
					int myear = Integer.parseInt(vehmodel.getText());
					
					int vcost = Integer.parseInt(vehprice.getText());
					
					st=con.prepareStatement( "update vehicle set vehicle.v_name=?,vehicle.model_year=?,vehicle.price=? where vehicle.reg_no=?");
					st.setString(1,vehname.getText());
					st.setInt(2,myear);
					st.setInt(3,vcost);
					st.setString(4,regno.getText());
					
					rs=st.executeQuery();
					if(rs.next()){}
					JOptionPane.showMessageDialog(null,"SUCCESSFUL");
					
				}
				
				catch(Exception e2){
					
					//System.out.println(e2);
					JOptionPane.showMessageDialog(null," Oops! Error occured during updation!");
				}
								
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 16));
		update.setBounds(486, 620, 209, 44);
		contentPane.add(update);
		
		JButton btnBack = new JButton("Menu");
		btnBack.setBackground(new Color(204, 204, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Newmenu().setVisible(true);
			}
		});
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblDoNotInclude = new JLabel("Do not include any spaces and use uppercase");
		lblDoNotInclude.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoNotInclude.setBounds(12, 399, 332, 22);
		contentPane.add(lblDoNotInclude);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(204, 204, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String regisno = regno.getText();
				try{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
				//JOptionPane.showMessageDialog(null,"Database Connection Successful");
				
				PreparedStatement st=con.prepareStatement( "select seller.*,buyer.*, vehicle.reg_no,vehicle.chassis_no,vehicle.engine_no,vehicle.v_name,vehicle.model_year,vehicle.price from seller,buyer,vehicle where seller.seller_id = vehicle.s_id and vehicle.B_ID = buyer.buyer_id and vehicle.reg_no = ?");
				st.setString(1,regisno);
				ResultSet rs=st.executeQuery();
				if(rs.next()){}
				
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblLastName.setVisible(true);
				lblContactNo.setVisible(true);
				lblAddress.setVisible(true);
				lblBuyerDetails.setVisible(true);
				lblFirstName.setVisible(true);
				lblLastName_1.setVisible(true);
				lblContactNo_1.setVisible(true);
				lblAddress_1.setVisible(true);
				lblVehicleDetails.setVisible(true);
				lblRegistrationNo.setVisible(true);
				lblChassisNo.setVisible(true);
				lblEngineNo.setVisible(true);
				lblName.setVisible(true);
				lblModel.setVisible(true);
				lblPrice.setVisible(true);

				lblDoNotInclude.setVisible(false);
				
				sellerfn.setText(rs.getString(2));
				sellerfn.setVisible(true);
				
				sellerln.setText(rs.getString(3));
				sellerln.setVisible(true);
				
				sellerphno.setText(rs.getString(4));
				sellerphno.setVisible(true);
				
				selleraddr.setText(rs.getString(5));
				selleraddr.setVisible(true);
				
				buyerfn.setText(rs.getString(7));
				buyerfn.setVisible(true);
				
				buyerln.setText(rs.getString(8));
				buyerln.setVisible(true);
				
				buyerphno.setText(rs.getString(9));
				buyerphno.setVisible(true);
				
				buyeraddr.setText(rs.getString(10));
				buyeraddr.setVisible(true);
				
				regno.setText(rs.getString(11));
				regno.setVisible(true);
				regno.setEditable(false);

				chassisno.setText(rs.getString(12));
				chassisno.setVisible(true);
				chassisno.setEditable(false);
				
				engineno.setText(rs.getString(13));
				engineno.setVisible(true);
				engineno.setEditable(false);
				
				vehname.setText(rs.getString(14));
				vehname.setVisible(true);
				
				vehmodel.setText(rs.getString(15));
				vehmodel.setVisible(true);
				
				vehprice.setText(rs.getString(16));
				vehprice.setVisible(true);
				
				//System.out.println(rs.getString(2));
				con.close();
				}catch(Exception e){ 
					JOptionPane.showMessageDialog(null,"Error Occured");
				} 
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(186, 480, 111, 25);
		contentPane.add(btnSearch);
		
		selleraddr = new JTextField();
		selleraddr.setBounds(339, 279, 189, 44);
		contentPane.add(selleraddr);
		selleraddr.setColumns(10);
		selleraddr.setVisible(false);
		
		buyeraddr = new JTextField();
		buyeraddr.setBounds(939, 279, 170, 44);
		contentPane.add(buyeraddr);
		buyeraddr.setColumns(10);
		buyeraddr.setVisible(false);
	}
}
