package pack;
import java.sql.*;

import javax.swing.JOptionPane;
//import javax.sql.*;
class Main{  
public static void main(String args[]){  
	
	Main obj = new Main();
	
	obj.dbconnection();
	
	new gui().setVisible(true);

}


public void dbconnection(){
	
	try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","vishal");  
		JOptionPane.showMessageDialog(null,"Database Connection Successful");

		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		//ResultSet rs=stmt.executeQuery("select bfirst_name,blast_name from buyer");  
		//while(rs.next())  
		//System.out.println(rs.getString(1) +"  "+rs.getString(2));//+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)+""+rs.getInt(5));  
		  
		//step5 close the connection object  
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);} 
}
}