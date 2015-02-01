<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8" 
	contentType="text/html; charset=UTF-8" import="oc.DataBaseBeanTest" %>
	

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
 
  <body>
    <form name=myform method=get action="usepass">
    	<p align="right">
    		姓名：
    		<input size="40" name="sname" value="">
    	</p>
    	<p align="right">
    		密码：
    		<input size=40 type="password" name=ssex value="">
    	</p>
    	<p align="right">
    		<input class=buttonf type="submit" value="登陆"  >
    		&nbsp;
    		<input type="reset" value="清除" >
    	</p>
    </form>
  </body>
</html>
