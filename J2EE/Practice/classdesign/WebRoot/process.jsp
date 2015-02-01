<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%
	request.setCharacterEncoding("GBK");
	
	String name=request.getParameter("name");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	if(null==name || null==title || null==content)
	{
	    response.sendRedirect("index.jsp");
		return;
	}
	
	if(name.equals("") || title.equals(""))
	{
		response.sendRedirect("say.html");
		return;
	}
	
	String fromIP=request.getRemoteAddr();
	
		Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","123");
	
	PreparedStatement pstmt=conn.prepareStatement(
		"insert into guestbook(gst_user,gst_title,gst_content,gst_time,gst_ip) values(?,?,?,?,?)");
	pstmt.setString(1,name);
	pstmt.setString(2,title);
	pstmt.setString(3,content);
	pstmt.setString(4,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	pstmt.setString(5,fromIP);
	
	pstmt.executeUpdate();
	pstmt.close();
	conn.close();
	response.sendRedirect("index.jsp");
%>