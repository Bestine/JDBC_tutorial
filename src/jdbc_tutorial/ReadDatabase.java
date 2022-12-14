package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadDatabase {
	
	ReadDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
			
			Statement stmt = con.createStatement();
			
			// This code read the first names from customers table
			ResultSet readNames = stmt.executeQuery("SELECT * FROM customers;");
			
			while(readNames.next()) {
				String name = readNames.getString("last_name");
				System.out.println(name);
			}
			
			System.out.println("CONNECTION ESTABLISHED!!!");	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
