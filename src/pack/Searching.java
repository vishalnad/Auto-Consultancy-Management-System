package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Searching extends JFrame {

	private JPanel contentPane;
	private JTextField searchtxt;
	private JTable table;
	private JTable table_1;
	private JTextField datetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searching frame = new Searching();
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
	public Searching() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1239, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBackground(new Color(204, 204, 255));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new Newmenu().setVisible(true);
			}
		});
		
		searchtxt = new JTextField();
		searchtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		searchtxt.setColumns(10);
		
		JLabel lblEnterVehicleRegistration = new JLabel("Enter vehicle registration number and click search button below");
		lblEnterVehicleRegistration.setBackground(Color.RED);
		lblEnterVehicleRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		String[] columnNames = {"Date","Reg no","Vehicle","Seller","Buyer","Price"};
		DefaultTableModel model = new DefaultTableModel();
		 table_1.setModel(model);
		 
		 model.setColumnIdentifiers(columnNames);
		/*table_1.setModel(new DefaultTableModel(
					new Object[][] {
						},
					new String[] {
						"Date", "Vehicle", "Seller", "Buyer", "Price"
					}
		));*/
		 JScrollPane scrollPane = new JScrollPane();
			
		 
		scrollPane.setViewportView(table_1);
		
		JLabel lblDoNotInclude = new JLabel("Do not include any spaces and use uppercase only");
		lblDoNotInclude.setBackground(Color.RED);
		lblDoNotInclude.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(204, 204, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 240));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "On Date", "Before Date", "After Date", "Price equal to", "Price more than", "Price less than"}));
		
		datetxt = new JTextField();
		datetxt.setColumns(10);
		
		JLabel lblDdmmyyyyy = new JLabel("dd-mm-yyyy");
		lblDdmmyyyyy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton search2 = new JButton("SEARCH");
		search2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String regisno = searchtxt.getText();
				String num  = "";
				String dt = "";
				String name = "";
				String slrname = "";
				String bname = "";
				int cost;
				if(comboBox.getSelectedItem().equals("On Date")){
					
					try{  
						
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						  
						//step2 create  the connection object  
						Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
						//JOptionPane.showMessageDialog(null,"Database Connection Successful");
						int i=0;
						PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and receipt.rdate = ?");
						st.setString(1,datetxt.getText());
						ResultSet rs=st.executeQuery();
						while(rs.next()){
							
							dt = rs.getString(1);
							num = rs.getString(2);
							name = rs.getString(3);
							slrname = rs.getString(4);
							bname = rs.getString(5);
							cost = rs.getInt(6);
							model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
							i++;
						}
						JOptionPane.showMessageDialog(null,i +" Rows found");
					
				}catch(Exception c){
					JOptionPane.showMessageDialog(null,"Enter correct date");

				}
				
			}
			else if(comboBox.getSelectedItem().equals("Before Date")){
				
				try{  
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					int i=0;
					PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and receipt.rdate <= ?");
					st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						
						dt = rs.getString(1);
						num = rs.getString(2);
						name = rs.getString(3);
						slrname = rs.getString(4);
						bname = rs.getString(5);
						cost = rs.getInt(6);
						model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
						i++;
					}
					JOptionPane.showMessageDialog(null,i +" Rows found");
					
			}catch(Exception c){
				JOptionPane.showMessageDialog(null,"Enter correct date");

			}
				
			}
			else if(comboBox.getSelectedItem().equals("After Date")){
				
				try{  
					int i=0;
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and receipt.rdate >= ?");
					st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						
						dt = rs.getString(1);
						num = rs.getString(2);
						name = rs.getString(3);
						slrname = rs.getString(4);
						bname = rs.getString(5);
						cost = rs.getInt(6);
						model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
						i++;
					}
					JOptionPane.showMessageDialog(null,i +" Rows found");
					
			}catch(Exception c){
				JOptionPane.showMessageDialog(null,"Enter correct date ");

			}
				
			}
			else if(comboBox.getSelectedItem().equals("Price equal to")){
				
					try{  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and vehicle.price = ?");
					st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					int i=0;
					while(rs.next()){
						
						dt = rs.getString(1);
						num = rs.getString(2);
						name = rs.getString(3);
						slrname = rs.getString(4);
						bname = rs.getString(5);
						cost = rs.getInt(6);
						model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
						i++;
					}
					JOptionPane.showMessageDialog(null,i +" Rows found");

			}catch(Exception c){
				JOptionPane.showMessageDialog(null,"Enter correct price");

			}
			}
			else if(comboBox.getSelectedItem().equals("Price more than")){
				
				try{  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and vehicle.price >= ?");
					st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					int i=0;
					while(rs.next()){
						
						dt = rs.getString(1);
						num = rs.getString(2);
						name = rs.getString(3);
						slrname = rs.getString(4);
						bname = rs.getString(5);
						cost = rs.getInt(6);
						model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
						i++;
					}
					JOptionPane.showMessageDialog(null,i +" Rows found");

			}catch(Exception c){
				JOptionPane.showMessageDialog(null,"Enter correct price");

			}
				
			}
				
			else if(comboBox.getSelectedItem().equals("Price less than")){
				
				try{  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement("select receipt.rdate,vehicle.reg_no,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and vehicle.price <= ?");
					st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					int i=0;
					while(rs.next()){
						
						dt = rs.getString(1);
						num = rs.getString(2);
						name = rs.getString(3);
						slrname = rs.getString(4);
						bname = rs.getString(5);
						cost = rs.getInt(6);
						model.addRow(new Object[]{dt,num,name,slrname,bname,cost});
						i++;
					}
					JOptionPane.showMessageDialog(null,i +" Rows found");

			}catch(Exception c){
				JOptionPane.showMessageDialog(null,"Enter correct price");

			}
				
			}	
			else if(comboBox.getSelectedItem().equals("")){
				
				JOptionPane.showMessageDialog(null,"Select something");
			}	
			}
		});
		search2.setFont(new Font("Tahoma", Font.BOLD, 16));
		search2.setBackground(new Color(204, 204, 255));
		
		JLabel lblEnterDate = new JLabel("Enter Date/Price Below");
		lblEnterDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Choose below");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton reset = new JButton("Reset Table");
		reset.setBackground(new Color(204, 204, 255));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  model.setRowCount(0);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterVehicleRegistration)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(773, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblDoNotInclude, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
							.addComponent(lblDdmmyyyyy, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(152)
							.addComponent(lblOr)
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterDate)
								.addComponent(datetxt, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
					.addGap(62)
					.addComponent(search2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(reset))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMenu)
							.addGap(13)
							.addComponent(lblEnterVehicleRegistration, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchtxt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblDoNotInclude, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOr)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(datetxt, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
								.addComponent(search2, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDdmmyyyyy, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(14)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reset)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//String[] columnheaders = {"Date","Vehicle","Seller","Buyer","Price"};
		//Object[] data = {"22-01-2017","Polo","Vishal","Vishaal","720000"};
		
		
	
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//String header = "Search result";
				//String footer  = "page";
				String regisno = searchtxt.getText();
				String dt = "";
				String name = "";
				String slrname = "";
				String bname = "";
				int cost;
				
				try{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");
					PreparedStatement st=con.prepareStatement( "select receipt.rdate,vehicle.v_name,seller.sfirst_name,buyer.bfirst_name,vehicle.price from receipt,seller,buyer,vehicle where receipt.s_id=seller.SELLER_ID and receipt.B_ID = buyer.BUYER_ID and vehicle.REG_NO = receipt.RNO and vehicle.reg_no = ?");
					st.setString(1,regisno);
					ResultSet rs=st.executeQuery();
					if(rs.next()){
						//table_1.setModel(DbUtils.resultSetToTableModel(rs));
						//((DefaultTableModel)table_1.getModel().addRow(rs));
						dt = rs.getString(1);
						name = rs.getString(2);
						slrname = rs.getString(3);
						bname = rs.getString(4);
						cost = rs.getInt(5);
						model.addRow(new Object[]{dt,regisno,name,slrname,bname,cost});
						
					}
					
					//table.print(JTable.PrintMode.FIT_WIDTH);
				}
				catch(Exception e1){
					
					JOptionPane.showMessageDialog(null,"Error occured");

				}
			}
		});
		
	}
}
