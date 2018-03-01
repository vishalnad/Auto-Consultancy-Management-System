package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

class xyz extends Exception{
}

public class SaleVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JButton display;
	private JLabel lblNewLabel;
	private JTextField rno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleVehicle frame = new SaleVehicle();
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
	static String vehno;
	public SaleVehicle() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 929, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		//rno.setText("veh_no");
		table_1 = new JTable();
		
		String[] columnNames = {"Reg no","Vehicle","Model"/*,"Seller"*/,"Price"};
		DefaultTableModel model = new DefaultTableModel();
		 table_1.setModel(model);
		 
		 model.setColumnIdentifiers(columnNames);
		
		
		display = new JButton("DISPLAY");
		display.setBackground(new Color(135, 206, 250));
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num;
				String name;
				int year;
				int cost;
				
				try{  
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
					//JOptionPane.showMessageDialog(null,"Database Connection Successful");
					int i=0;
					PreparedStatement st=con.prepareStatement("select reg_no,v_name,model_year,cost from tempvehicle");
					//st.setString(1,datetxt.getText());
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						
						//dt = rs.getString(1);
						
						num = rs.getString(1);
						name = rs.getString(2);
						year = rs.getInt(3);
						cost = rs.getInt(4);
						model.addRow(new Object[]{num,name,year,cost});
						i++;
					}
					//JOptionPane.showMessageDialog(null,i +" Rows found");
				
			}catch(Exception c){
				JOptionPane.showMessageDialog(null,c);

			}

				
			}
		});
		//if(!rno.getText().equals(null)){
			//vehno = rno.getText();
		//}
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String vno;
				int row = table_1.getSelectedRow();
				//int column = table_1.getColumnCount();
				//for(int i = 0; i < column; i++) {
				    vno = (String) table_1.getValueAt(row, 0);
				    rno.setText(vno);
				    vehno = rno.getText();
					JOptionPane.showMessageDialog(null,vno);

				//}
			}
		});
		
		lblNewLabel = new JLabel("Selected Vehicle Registration number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton buy = new JButton("BUY THIS CAR");
		buy.setBackground(new Color(135, 206, 250));
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					
					if(rno.getText().equals(null)){
						throw new xyz();
						
						
					}
					
				}catch(xyz q){
					JOptionPane.showMessageDialog(null,"Select a vehicle");

				}
				new details().setVisible(true);

			}
		});
		
		JButton menu = new JButton("MENU");
		menu.setBackground(new Color(135, 206, 250));
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new Newmenu().setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.setRowCount(0);
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		
		rno = new JTextField();
		rno.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(display, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(109)
					.addComponent(rno, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(buy, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menu)
					.addGap(140)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(424, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(buy, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(rno, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(menu)
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(display, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
		);
		
		
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
