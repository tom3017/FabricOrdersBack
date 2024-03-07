package com.javalec.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.util.ShareVar;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
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
        
        String query = "select * from student where sname = '"+name+"'";
        int count = 0;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
           Statement stmt_mysql = conn_mysql.createStatement();
           
           ResultSet rs = stmt_mysql.executeQuery(query);
           PrintWriter out = response.getWriter();
           
           while(rs.next()) {
              count++;
              out.print("결과: <br>"+
                    Integer.toString(count)+". "+
                    rs.getString("sname")+" : "+
                    rs.getString("sdept")+ "<br>");   
           }
        }catch(Exception e) {
           e.printStackTrace();
        }
     }
    
}
     