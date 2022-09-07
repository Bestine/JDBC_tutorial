package jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayOnTable extends JFrame{
		
	DisplayOnTable(){
		
		String[] columnNames = {"shipper_id", "name"};
		ArrayList<Integer> idColumn = new ArrayList<Integer>();
		ArrayList<String> nameColumn = new ArrayList<String>();
		
		// read the database and display on table 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store",
					"root",
					"Mustafa123?");
			
			
			Statement stmt = con.createStatement();
			
			// This code read the first names from customers table
			ResultSet readData = stmt.executeQuery("SELECT * FROM shippers;");
			
			while(readData.next()) {
				int shipper_id = readData.getInt("shipper_id");
				idColumn.add(shipper_id);
				
				String name = readData.getString("name");
				nameColumn.add(name);
			}
			
			System.out.println(idColumn);	
			System.out.println(nameColumn);
			System.out.println("CONNECTION ESTABLISHED!!!");	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JTable dataTable = new JTable(1, 2);
		dataTable.setBounds(100, 150, 300, 140);
		
		//Set Column names to the table
		DefaultTableModel dataTableModel = (DefaultTableModel) dataTable.getModel();
		dataTableModel.addRow(new Object[] {"Shipper_id", "Name"});
		
		// Add data to the table
		for(int i=0; i<idColumn.size(); i++) {
			dataTableModel.addRow(new Object[] {idColumn.get(i), 
					nameColumn.get(i)});
		}
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(500, 500);
		this.add(dataTable);
	}
}
