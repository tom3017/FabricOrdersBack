package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.util.ShareVar;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/InsertAction")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAction() {
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
		
		
		String query = "insert into student (scode, sname, sdept, sphone, saddress) values (?,?,?,?,?)";
		ps = conn_mysql.prepareStatement(query);
		ps.setString(1, code);
		ps.setString(2, name);
		ps.setString(3, dept);
		ps.setString(4, phone);
		ps.setString(5, address);
		
		ps.executeUpdate();
		conn_mysql.close();
		
		out.print("success");
		
		}catch(Exception e) {
			e.printStackTrace();
			out.print("failure");
		}
	
	}
	
	
	}


