package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class addData
 */
//@WebServlet("/addData")
public class addData extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2hbabba2668";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Netid#1001";
	
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cus_name = request.getParameter("Customer Name");
		String cust_no = request.getParameter("Customer No.");
		double invoice_no = Double.parseDouble(request.getParameter("Invoice No."));
		double inv_amt = Double.parseDouble(request.getParameter("Invoice Amount"));
		String due_date = request.getParameter("Due Date");
		String notes = request.getParameter("Notes");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
			String sql = "Insert into mytable1(name_customer,cust_number,doc_id,total_open_amount,due_in_date,notes) values (?,?,?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, cus_name);
			prep.setString(2, cust_no);
			prep.setDouble(3, invoice_no);
			prep.setDouble(4, inv_amt);
			prep.setDate(5, java.sql.Date.valueOf(due_date));
			prep.setString(6, notes);
			
			int x=prep.executeUpdate();
			response.sendRedirect("http://localhost:8080/H2HBABBA2668/");
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
