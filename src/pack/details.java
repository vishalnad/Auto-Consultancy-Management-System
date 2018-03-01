package pack;

import java.sql.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
class xyzq extends Exception{
}

public class details extends JFrame {

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
	
	private JTextField selleraddr;
	private JTextField buyeraddr;
	private JTextField date;

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
	public details() {
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//System.out.println(v.vehno);
		JLabel lblNewLabel = new JLabel("Seller details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(294, 13, 130, 25);
		contentPane.add(lblNewLabel);
		
		sellerfn = new JTextField();
		sellerfn.setBounds(339, 87, 189, 25);
		contentPane.add(sellerfn);
		sellerfn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(182, 87, 119, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(148, 152, 105, 22);
		contentPane.add(lblLastName);
		
		sellerln = new JTextField();
		sellerln.setBounds(339, 149, 189, 25);
		contentPane.add(sellerln);
		sellerln.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact no");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactNo.setBounds(148, 224, 105, 22);
		contentPane.add(lblContactNo);
		
		sellerphno = new JTextField();
		sellerphno.setBounds(339, 221, 189, 25);
		contentPane.add(sellerphno);
		sellerphno.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(148, 292, 105, 19);
		contentPane.add(lblAddress);
		
		JLabel lblBuyerDetails = new JLabel("Buyer Details");
		lblBuyerDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuyerDetails.setBounds(745, 13, 154, 25);
		contentPane.add(lblBuyerDetails);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setBounds(767, 91, 105, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName_1 = new JLabel("Last name");
		lblLastName_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName_1.setBounds(767, 153, 90, 14);
		contentPane.add(lblLastName_1);
		
		JLabel lblContactNo_1 = new JLabel("Contact no");
		lblContactNo_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactNo_1.setBounds(767, 225, 105, 22);
		contentPane.add(lblContactNo_1);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress_1.setBounds(767, 294, 90, 17);
		contentPane.add(lblAddress_1);
		
		buyerfn = new JTextField();
		buyerfn.setBounds(939, 87, 170, 25);
		contentPane.add(buyerfn);
		buyerfn.setColumns(10);
		
		buyerln = new JTextField();
		buyerln.setBounds(939, 149, 170, 25);
		contentPane.add(buyerln);
		buyerln.setColumns(10);
		
		buyerphno = new JTextField();
		buyerphno.setBounds(939, 221, 170, 25);
		contentPane.add(buyerphno);
		buyerphno.setColumns(10);
		
		JLabel lblVehicleDetails = new JLabel("Vehicle details");
		lblVehicleDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVehicleDetails.setBounds(522, 378, 137, 25);
		contentPane.add(lblVehicleDetails);
		
		JLabel lblRegistrationNo = new JLabel("Reg No");
		lblRegistrationNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrationNo.setBounds(69, 438, 84, 25);
		contentPane.add(lblRegistrationNo);
		
		regno = new JTextField();
		regno.setBounds(165, 435, 179, 32);
		contentPane.add(regno);
		regno.setColumns(10);
		
		JLabel lblChassisNo = new JLabel("Chassis No");
		lblChassisNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChassisNo.setBounds(389, 438, 94, 25);
		contentPane.add(lblChassisNo);
		
		chassisno = new JTextField();
		chassisno.setBounds(497, 437, 185, 37);
		contentPane.add(chassisno);
		chassisno.setColumns(10);
		
		JLabel lblEngineNo = new JLabel("Engine No");
		lblEngineNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEngineNo.setBounds(786, 440, 94, 21);
		contentPane.add(lblEngineNo);
		
		engineno = new JTextField();
		engineno.setBounds(920, 433, 189, 37);
		contentPane.add(engineno);
		engineno.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(69, 551, 58, 21);
		contentPane.add(lblName);
		
		vehname = new JTextField();
		vehname.setBounds(165, 543, 179, 32);
		contentPane.add(vehname);
		vehname.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModel.setBounds(389, 542, 79, 32);
		contentPane.add(lblModel);
		
		vehmodel = new JTextField();
		vehmodel.setBounds(497, 546, 185, 32);
		contentPane.add(vehmodel);
		vehmodel.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(786, 545, 94, 32);
		contentPane.add(lblPrice);
		
		vehprice = new JTextField();
		vehprice.setBounds(920, 543, 189, 37);
		contentPane.add(vehprice);
		vehprice.setColumns(10);
		
		
		
		
		
		JButton bill = new JButton("SAVE & PRINT");
		bill.setBackground(new Color(135, 206, 250));
		bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//long n1,n2;
				//n1 = Integer.parseInt(sellerphno.getText());
				//n2 = Integer.parseInt(buyerphno.getText());
				try{
				if(sellerfn.getText().equals("")||sellerln.getText().equals("")||sellerphno.getText().equals("")||selleraddr.getText().equals("")||buyerfn.getText().equals("")||buyerln.getText().equals("")||buyerphno.getText().equals("")||buyeraddr.getText().equals("")||engineno.getText().equals("")||chassisno.getText().equals("")||vehname.getText().equals("")||vehmodel.getText().equals("")||vehprice.getText().equals("")){
					
					throw new xyzq();
				}
				
				/*try{
				boolean complete = sellerfn.print();
				if(complete)
					JOptionPane.showMessageDialog(null, "Done Print");
				else
					JOptionPane.showMessageDialog(null, "Error Printing");

			
				}catch(PrinterException  ae){
					JOptionPane.showMessageDialog(null, ae);
				}*/
				
				
				
					//step1 load the driver class  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					
					PreparedStatement st=con.prepareStatement("select max(seller_id) from seller");
					ResultSet rs=st.executeQuery();
					if(rs.next()){}
					int id = rs.getInt(1);
				
						id = id + 1;
						//System.out.println(id);
						st=con.prepareStatement("insert into seller values(?,?,?,?,?)");
					st.setInt(1,id);
					st.setString(2,sellerfn.getText());
					st.setString(3,sellerln.getText());
					st.setString(4,sellerphno.getText());
					st.setString(5,selleraddr.getText());
					
					rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Inserted into seller");
					
					st=con.prepareStatement("insert into buyer values(?,?,?,?,?)");
					st.setInt(1,id);
					st.setString(2,buyerfn.getText());
					st.setString(3,buyerln.getText());
					st.setString(4,buyerphno.getText());
					st.setString(5,buyeraddr.getText());
					
					rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Inserted into buyer");
					
					
					
					
					st=con.prepareStatement("insert into vehicle values(?,?,?,?,?,?,?,?)");
					
					st.setString(1,regno.getText());
					st.setString(2,chassisno.getText());
					st.setString(3,engineno.getText());
					st.setString(4,vehname.getText());
					st.setString(5,vehmodel.getText());
					st.setInt(6,Integer.parseInt(vehprice.getText()));
					st.setInt(7,id);
					st.setInt(8,id);
					
					rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Inserted into vehicle");
					
					st=con.prepareStatement("insert into receipt values(?,?,?,?,?)");
					st.setInt(1,id);
					st.setString(2,date.getText());
					st.setString(3,regno.getText());
					st.setInt(4,id);
					st.setInt(5,id);
					
					rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Inserted into receipt");
					
					st=con.prepareStatement("delete from tempseller where sr_no = ?");
					st.setString(1,regno.getText());
					rs=st.executeQuery();
					if(rs.next()){}
					//JOptionPane.showMessageDialog(null,"Del seller");
					
					
					st=con.prepareStatement("delete from tempvehicle where reg_no = ?");
					st.setString(1,regno.getText());
					rs=st.executeQuery();
					if(rs.next()){}
					JOptionPane.showMessageDialog(null,"SUCCESSFUL");
					
					con.close();  
					
					
					
					
					try{
					    BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\bill\\bill.txt")); 
					  
					    writer.write("DATE : "+date.getText());
					    writer.newLine();
					    writer.newLine();
					    
					    writer.write("SELLER NAME : "+sellerfn.getText());
					    writer.newLine();
					    writer.write("SELLER PHno:"+sellerphno.getText());
					    writer.newLine();
					    
					    writer.write("SELLER ADDRESS : "+selleraddr.getText());
					    writer.newLine();
					    
					    writer.write("BUYER NAME : "+buyerfn.getText());
					    writer.newLine();
					    
					    writer.write("BUYER PHno : "+buyerphno.getText());
					    writer.newLine();
					    
					    writer.write("BUYER ADDRESS : "+buyeraddr.getText());
					    writer.newLine();
					    
					    writer.write("REGISTRATION NO : "+regno.getText());
					    writer.newLine();
					    
					    writer.write("CHASSIS NO : "+chassisno.getText());
					    writer.newLine();
					    
					    writer.write("ENGINE NO : "+engineno.getText());
					    writer.newLine();
					    
					    writer.write("VEHICLE NAME : "+vehname.getText());
					    writer.newLine();
					    
					    writer.write("MODEL : "+vehmodel.getText());
					    writer.newLine();
					    
					    writer.write("PRICE : "+vehprice.getText());
					    writer.newLine();
					    
					   // writer.write("HAPPY Journey");
					    //writer.newLine();
					     
					    writer.close();
					    
					    
					    JTextPane textPane = new JTextPane();

				        textPane.setText("\tHI-TECH AUTO CUNsULTANCY HUBLI\n\n"+"DATE : "+date.getText()+"\n"+"PLACE : UNKAL, HUBLI"+"SELLER NAME : "+sellerfn.getText()+"\t\t"+"BUYER NAME : "+buyerfn.getText()+"\n\n"+
				        				"SELLEER PHNO : "+sellerphno.getText()+"\t\t"+"BUYER PHNO : "+buyerphno.getText()+"\n\n"+
				        				"SELLER ADDRESS : "+selleraddr.getText()+""+"BUYER ADDRESS : "+buyeraddr.getText()+"\n\n"+
				        				"REGISTRATION NO : "+regno.getText()+"\t\t"+"CHASSIS NO : "+chassisno.getText()+"\n\n"+
				        				"ENGINE NO : "+engineno.getText()+"\t\t"+"\tVEHICLE NAME : "+vehname.getText()+"\n\n\n"+
				        				"PRICE : "+vehprice.getText()+"\n\n"+"\tSELLER SIGNATURE \t\t BUYER SIGNATURE \n\n\n\t\tTHANK YOU");

				        textPane.print();
					} catch (IOException ae) {
					 System.out.println("Error");
					 try
					 {
					 BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\bill\\bill.txt")); 
					  
					 writer.write("DATE : "+date.getText());
					    writer.newLine();
					    
					    writer.write("SELLER NAME : "+sellerfn.getText());
					    writer.newLine();
					    writer.write("SELLER PHno:"+sellerphno.getText());
					    writer.newLine();
					    
					    writer.write("SELLER ADDRESS : "+selleraddr.getText());
					    writer.newLine();
					    
					    writer.write("BUYER NAME : "+buyerfn.getText());
					    writer.newLine();
					    
					    writer.write("BUYER PHno : "+buyerphno.getText());
					    writer.newLine();
					    
					    writer.write("BUYER ADDRESS : "+buyeraddr.getText());
					    writer.newLine();
					    
					    writer.write("REGISTRATION NO : "+regno.getText());
					    writer.newLine();
					    
					    writer.write("CHASSIS NO : "+chassisno.getText());
					    writer.newLine();
					    
					    writer.write("ENGINE NO : "+engineno.getText());
					    writer.newLine();
					    
					    writer.write("VEHICLE NAME : "+vehname.getText());
					    writer.newLine();
					    
					    writer.write("MODEL : "+vehmodel.getText());
					    writer.newLine();
					    
					    writer.write("PRICE : "+vehprice.getText());
					    writer.newLine();
					  
					    writer.close(); 
					    
					    JEditorPane text = new JEditorPane("C:\\Users\\Admin\\Desktop\\bill\\bill.txt");
					    text.print(null, null, true, null, null, false);
					    //writer.write("HAPPY Journey");
					    //writer.newLine();
					    
					    
					} catch (IOException e) {
					 System.out.println("Error");
					 
					}
					 
					}
					
					
					
					
					
					//JOptionPane.showMessageDialog(null,"Inserted");
					
					}
				catch(xyzq e){
					JOptionPane.showMessageDialog(null,"Fill all the details");
				}
				
				catch(Exception e){ //System.out.println(e);
					JOptionPane.showMessageDialog(null,"Error occured");
					}
				
				
				
				
				
				
				
			}
		});
		bill.setFont(new Font("Tahoma", Font.BOLD, 16));
		bill.setBounds(553, 640, 179, 40);
		contentPane.add(bill);
		
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
		
		selleraddr = new JTextField();
		selleraddr.setBounds(339, 292, 189, 36);
		contentPane.add(selleraddr);
		selleraddr.setColumns(10);
		
		buyeraddr = new JTextField();
		buyeraddr.setBounds(939, 292, 170, 36);
		contentPane.add(buyeraddr);
		buyeraddr.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(69, 640, 84, 25);
		contentPane.add(lblDate);
		
		date = new JTextField();
		date.setBounds(165, 637, 116, 22);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("dd-mm-yyyy");
		lblDdmmyyyy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDdmmyyyy.setBounds(175, 659, 137, 30);
		contentPane.add(lblDdmmyyyy);
		
		JLabel lblDoNotInclude = new JLabel("Do not include spaces and use uppercase only");
		lblDoNotInclude.setBounds(79, 480, 292, 25);
		contentPane.add(lblDoNotInclude);
		
		JButton click = new JButton("CLICK TO PROCEED");
		click.setBackground(new Color(135, 206, 250));
		SaleVehicle v = new SaleVehicle();
		
		
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String chass = "";
				String eng = "";
				String vname = "";
				int yr=0;
				int cst=0;
				String vno = v.vehno;
				//String sfn,sln,sph,saddr;
				try{
					
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					
					PreparedStatement st=con.prepareStatement("select chassis_no,engine_no,v_name,model_year,cost from tempvehicle where reg_no = ?");
					st.setString(1, vno);
					
					//st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					if(rs.next()){
						
						chass = rs.getString(1);
						eng = rs.getString(2);
						vname = rs.getString(3);
						yr = rs.getInt(4);
						cst = rs.getInt(5);
						
						chassisno.setText(chass);
						engineno.setText(eng);
						vehname.setText(vname);
						vehmodel.setText(Integer.toString(yr));
						vehprice.setText(Integer.toString(cst));
						regno.setText(vno);
						
						st=con.prepareStatement("select sfirst_name,slast_name,cell_no,saddress from tempseller where sr_no = ?");
						st.setString(1, vno);
						rs=st.executeQuery();
						if(rs.next()){
							sellerfn.setText(rs.getString(1));
							sellerln.setText(rs.getString(2));
							sellerphno.setText(rs.getString(3));
							selleraddr.setText(rs.getString(4));
						}
						
					}
					
					
					//JOptionPane.showMessageDialog(null,chass);
				
			}catch(Exception x){
				JOptionPane.showMessageDialog(null,x);
			}
				
			}
		});
		click.setBounds(12, 87, 158, 25);
		contentPane.add(click);
	}
}

