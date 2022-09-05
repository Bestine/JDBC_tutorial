package jdbc_tutorial;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Mustafa");
		Main establishConnection = new Main();
		establishConnection.createConnection();
		
	}
	void createConnection() {
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
			
			//this code inserts names into first_name column in the customers table
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the first name: ");
			String first_name = scan.nextLine();
			
			stmt.execute("INSERT INTO customers (first_name, last_name, address, city, state) VALUES ('"+first_name+"', 'Okinda', 'Mtopanga Posta', 'Mombasa', 'MS');");
			System.out.println("SuccessFully Inserted " + first_name);
			
			ResultSet updatedNames = stmt.executeQuery("SELECT * FROM customers;");
			
			while(updatedNames.next()) {
				String name = updatedNames.getString("last_name");
				System.out.println(name);
			}			
			
			stmt.close(); //closes the SQL statement
			
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
