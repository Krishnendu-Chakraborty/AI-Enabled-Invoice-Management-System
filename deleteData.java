package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class deleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2hbabba2668";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Netid#1001";   
    
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String invNo = request.getParameter("inamt1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
			String sql = "Delete from mytable1 where doc_id =(?);";
			
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, invNo);
			int z=prep.executeUpdate();
			response.sendRedirect("http://localhost:8080/H2HBABBA2668/");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
