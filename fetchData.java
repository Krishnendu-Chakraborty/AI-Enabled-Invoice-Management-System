package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.Statement;
import com.sun.tools.javac.util.List;

public class fetchData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2hbabba2668";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Netid#1001";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// TODO Auto-generated method stub
			ArrayList<com.higradius.pojo> pojolst = new ArrayList<>();
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			    String sql = "Select * from mytable1 order by due_in_Date desc limit 9;";
			    java.sql.Statement prep = con.createStatement();
			    ResultSet rs = prep.executeQuery(sql);
			    while(rs.next()) {
			    	pojo pojoObj= new pojo();
			    	pojoObj.setCus_name(rs.getString("name_customer"));
			    	pojoObj.setCus_no(rs.getString("cust_number"));
			    	pojoObj.setInvoice_id(rs.getDouble("doc_id"));
			    	pojoObj.setInvoice_amt(rs.getDouble("total_open_amount"));
			    	pojoObj.setDue_date(rs.getDate("due_in_date"));
			    	pojoObj.setPredict_date(rs.getDate("Predicted_payment_date"));
			    	pojoObj.setNotes(rs.getString("notes"));
			    	pojolst.add(pojoObj);
			    	}
			    Gson gson = new Gson();
			    String userJson = gson.toJson(pojolst);
			    
			    PrintWriter printWriter = response.getWriter();
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    printWriter.write(userJson);
			    printWriter.close();
   
			}
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	


