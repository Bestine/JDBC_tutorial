package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseTable {
	
	Connection con;
	
	CreateDatabaseTable(){
		// Create a connection to the database
		createConnection();
		
		//Statement to create the database
		String createTableStatement = "CREATE TABLE eclipseTable("
									+ "name varchar(100),"
									+ "age int,"
									+ "salary float"
									+ ");";
		
		try {
			
			Statement stmt =  con.createStatement();
			stmt.execute(createTableStatement);
			
			System.out.println("Database table successfull created!");
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void createConnection() {
		try {
			//Show the kind of RDMS needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Give the credentials to the RDMS
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
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
