package com.abhi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.protocol.Resultset;

public class StudentMain {
	static Map<Integer, String> map;
	static List<String> list;
	static {
		map = new HashMap<>();
		list = new ArrayList<>();
		map.put(1, "Abhi");
		map.put(2, "Rock");
		map.put(3, "Goku");
		map.put(4, "Kevin");
		map.put(5, "Vegeta");
	}

	public static void main(String[] args) throws Exception{
		
		//writeFile(map);
//		readFile();
//		addDB();
//		for(String s: list) {
//			System.out.println(s);
//		}
			readDB();
	}
	
	
	private static void addDB() throws Exception{
		String query = "insert into student() values(?,?)";
		Connection con = StudentConnector.connectIt();
		PreparedStatement st = con.prepareStatement(query);
		for(int i=0;i<list.size() ; i++) {
			st.setInt(1, i+1);
			st.setString(2, list.get(i));
			st.executeUpdate();
		}

		System.out.println("---UPDATED---");
		
	}
	
	private static void readDB() throws Exception{
		String query="select * from student";
		Connection con = StudentConnector.connectIt();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
	}
	
	
	private static void writeFile(Map<Integer ,String> data) {
		File file = new File("E:\\Student.dat");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			for(Integer set : data.keySet()) {
				bw.write(data.get(set)+"\n");
			}
			
		}catch(IOException e) {
			System.out.println("----FILE ERROR----");
		}
	}
	
	private static void readFile() {
		File file = new File("E:\\Student.dat");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String s="";
			while((s=br.readLine())!=null) {
			list.add(s);
			}
			
			
		}catch(IOException e) {
			System.out.println("----FILE ERROR---");
		}
	}
	

}
