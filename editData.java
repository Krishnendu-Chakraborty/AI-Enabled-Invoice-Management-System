package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class editData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2hbabba2668";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Netid#1001";
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double inv_amtt = Double.parseDouble(request.getParameter("Invoice Amount"));
		String invNo = request.getParameter("inamt");
		String notes = request.getParameter("Notes");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
			String sql = "Update mytable1 set total_open_amount = (?) , notes = (?) where doc_id = (?);";
			
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setDouble(1, inv_amtt);
			prep.setString(2, notes);
			prep.setString(3, invNo);
			int y=prep.executeUpdate();
			response.sendRedirect("http://localhost:8080/H2HBABBA2668/");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
