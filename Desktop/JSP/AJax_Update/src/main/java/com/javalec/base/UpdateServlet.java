package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javalec.util.ShareVar;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// AJAX에서 전달한 데이터 받기
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=UTF-8");
		
		//박스에 여러개의 데이터 담기
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		
		String query = "select scode,sname,sdept,sphone,saddress from student where sname like '%" + name + "%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				Student student = new Student();
				student.setScode(rs.getString("scode"));
				student.setSname(rs.getString("sname"));
				student.setSdept(rs.getString("sdept"));
				student.setSphone(rs.getString("sphone"));
				student.setSaddress(rs.getString("saddress"));
				
				studentList.add(student); // 이거하나면 하나씩 한줄로 계단식이됨.
				
			}
			
			//ArrayList에 담겨잇는 데이터를 json으로 변경하여 넘김'
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(studentList));
			out.flush();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}