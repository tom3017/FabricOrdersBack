package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javalec.util.ShareVar;

/**
 * Servlet implementation class UpdateAction
 */
@WebServlet("/UpdateAction")
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("text/html;charset=UTF-8");
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		PreparedStatement ps = null;
		
		
		String query = "update student set sname=?, sdept=?, sphone=?, saddress=? where scode =?";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, dept);
		ps.setString(3, phone);
		ps.setString(4, address);
		ps.setString(5, code);
		
		ps.executeUpdate();
		conn_mysql.close();
		
		out.print("success");
		
		}catch(Exception e) {
			e.printStackTrace();
			out.print("failure");
		}
	
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

