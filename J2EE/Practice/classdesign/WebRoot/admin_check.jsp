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
		out.println("�û��������벻��Ϊ�գ�������<a href=admin_login.html>��¼</a>");
		return;
	}
	
	if(name.equals("aa123") && pwd.equals("aa123"))
	{
	    session.setAttribute("admin","true");
		response.sendRedirect("admin_index.jsp");
	}
	else
	{
	    out.println("�û������������������<a href=admin_login.html>��¼</a>");
	}
%>