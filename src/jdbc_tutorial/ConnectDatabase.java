package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	ConnectDatabase(){
		System.out.println("CONNECTION ESTABLISHED!!!");
	}
	
	void createConnection() {
		try {
			//Show the kind of RDMS needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Give the credentials to the RDMS
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
