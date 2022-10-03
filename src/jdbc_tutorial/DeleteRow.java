package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRow {
	
	DeleteRow(){
		
		try {
			//Show the kind of RDMS needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Give the credentials to the RDMS
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
			System.out.println("CONNECTION ESTABLISHED");
			
			PreparedStatement stmt = con.prepareStatement("DELETE FROM customers WHERE last_name = ?;");
			//stmt.setString(1, "Bestine");
			stmt.setString(1, "Okinda");
			
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("RECORD DELETED");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
