package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRow{
	
	UpdateRow(){

		try {
			//Show the kind of RDMS needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Give the credentials to the RDMS
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
			PreparedStatement stmt = con.prepareStatement("UPDATE customers SET first_name = ?, last_name = ? WHERE customer_id = 7;");
			stmt.setString(1, "Mustafa");
			stmt.setString(2, "Okinda");
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("CONNECTION ESTABLISHED!!!");
	}

}
