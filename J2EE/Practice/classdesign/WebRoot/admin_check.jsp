<%@page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>


<%
    request.setCharacterEncoding("GBK");
    
    String name=request.getParameter("name");
    String pwd=request.getParameter("password");
	
	if(null==name || null==pwd)
	{
	    response.sendRedirect("admin_login.html");
		return;
	}
	
	
	if(name.equals("") || pwd.equals(""))
	{
		out.println("用户名和密码不能为空，请重新<a href=admin_login.html>登录</a>");
		return;
	}
	
	if(name.equals("aa123") && pwd.equals("aa123"))
	{
	    session.setAttribute("admin","true");
		response.sendRedirect("admin_index.jsp");
	}
	else
	{
	    out.println("用户名或密码错误，请重新<a href=admin_login.html>登录</a>");
	}
%>