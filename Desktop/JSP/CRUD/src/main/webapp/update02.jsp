<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	String strUserid = null;
	String strName = null;
	String strTel = null;
	String strAddress = null;

	String url_mysql = "jdbc:mysql://localhost/customer?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "gkdldua12!@";
	
	String query = "SELECT userid, name, tel, address FROM purchaserinfo WHERE userid = ?";
	
		
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		PreparedStatement pstmt = conn_mysql.prepareStatement(query);
        pstmt.setString(1, userid);

        ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
            strUserid = rs.getString("userid");
            strName = rs.getString("name");
            strTel = rs.getString("tel");
            strAddress = rs.getString("address");
		}
		
		
		
		conn_mysql.close();
		session.setAttribute("ID", userid);
		session.setAttribute("OLDID", strUserid);
		session.setAttribute("NAME", name);
		session.setAttribute("OLDNAME", strName);
		session.setAttribute("PHONE", tel);
		session.setAttribute("OLDPHONE", strTel);
		session.setAttribute("ADDRESS", address);
		session.setAttribute("OLDADDRESS", strAddress);
		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수정후 확인버튼을 누르세요!</title>
	</head>
	<body>
		<form action="update03.jsp" method="post">
			사용자 ID : <input type="text" name="userid" size="10" value="<%=strUserid %>" readonly="readonly"> <br>
			성명 : <input type="text" name="name" size="10" value="<%=strName %>"><br>
			전화번호 : <input type="text" name="tel" size="15" value="<%=strTel %>"><br>
			주소 : <input type="text" name="address" size="30" value="<%=strAddress %>"><br>
			<input type="submit" value="확인">
		</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	</body>
</html>