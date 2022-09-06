package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {
	
	PrepareStatement(){
		
		System.out.println("Hello Mustafa");
		
		try {
			//Show the kind of RDMS needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Give the credentials to the RDMS
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO shippers VALUES(?, ?);");
			
			stmt.setInt(1, 6);			
			stmt.setString(2, "Rimh Services Ltd");
			
			stmt.execute();
			stmt.close();
			
			//Confirm the operation
			System.out.println("Insertion Complete");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
