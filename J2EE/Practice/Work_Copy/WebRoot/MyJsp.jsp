<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 
  	Date date=new Date();
  	int day=date.getDay();
  	int hour=date.getHours();
  	String s="";
  	if(hour>0||hour>12)
  	{
  		s="上午好";
  	}
  	else
  	{
  		s="下午好";
  	}
  	out.println(s+"今天是星期:"+day);
  	
  
  %>
     <form name="myform" method=post  action="cal.jsp">
    	<p align="right">
    		计算
    		<input size="40" name="name" value="">
    	</p>
    	<p align="right">
    		<input class="button"  name="expr" type="submit" value="计算"  >
    		&nbsp;
    		<input type="reset" value="清除" >
    	</p>
    </form>
  </body>
</html>
