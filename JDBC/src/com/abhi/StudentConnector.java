package com.abhi;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentConnector {
		private static final String url="jdbc:mysql://localhost:3306/javadb";
		private static final String username = "root";
		private static final String password="11101996@Singh";
		
		public static Connection connectIt() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("---DB CONNECTED---");
			return con;
			
		}
	
	
}
