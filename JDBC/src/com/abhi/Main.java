package com.abhi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		String query ="select * from books order by book_id";
		Connection con = ConnectorClass.connectIt();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		String data="";
		while(rs.next()) {
			data = rs.getString(1) + " " + rs.getString(2);	
			System.out.println(data);
		}
		

	}

}
