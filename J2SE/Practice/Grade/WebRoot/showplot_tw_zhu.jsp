<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.grade.bean.Save_twice_data"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html>
  <head>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <base href="<%=basePath%>">
    <link rel="icon" href="http://172.16.142.98:8080/Grade/images/favicon.gif" type="image/x-icon"/>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="毕业设计">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="http://172.16.142.98:8080/Grade/images/favicon.gif" type="image/x-icon"/> 
	<link rel="stylesheet" type="http://172.16.142.98:8080/Grade/text/css" href="css/styles.css"/>
	<link type="text/css" href="http://172.16.142.98:8080/Grade/css/css3.css" rel="stylesheet" />
	<script type="text/javascript" src=" http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.js"></script>
	<script type="text/javascript" src="http://172.16.142.98:8080/Grade/js/jquery.pikachoose.js"></script>
	<script language="javascript">
			$(document).ready(
				function (){
					$("#pikame").PikaChoose();
				});
		</script>
		<%@ taglib prefix="s" uri="/struts-tags" %>
  </head>

  <body>
   	
    <!--start container-->
    <div id="container">

    <!--start header-->

    <header>
 
    <!--start logo-->
    <a href="#" id="logo"><img src="http://172.16.142.98:8080/Grade/images/logo.png" width="221" height="100" alt="logo"/></a>    

	<!--end logo-->
	
   <!--start menu-->

	<nav>
    <ul>
    <li><a href="#">Home</a>

	</li>
	<li><a href="#">帮助</a></li>
    </ul>
    </nav>
	<!--end menu-->
	

    <!--end header-->
	</header>
	 <div id="intro">
   
   <div class="group_bannner_left">
    <hgroup>
  <h2><p>判别方程:${std.FF}</p></h2>
	<h2><p>显著水平为F0.5的临界值:${std.five}</p></h2>
	<h2><p>显著水平位F0.1的临界值:${std.fone}</p></h2>
	<h2><p>判别方程F检的结论:${std.message}</p></h2>
	<h2><p>马哈拉诺比斯距离:${std.mh}</p></h2>
	<h2>
		<table border="1">
		<tr>
			<th>判别分类</th>
			<th>原有分类</th>
		</tr>
		<% Save_twice_data data=(Save_twice_data)session.getAttribute("std");
		   Map<Integer,String> map=data.getOrigin();
		for(int i=1;i<=map.size()/2;i++)
		{
		 %>
		<tr>		
				<td><%=map.get(i) %></td>
					
				<td><%=map.get(i+888) %></td>				
		</tr>
		<%} %>
		
	
		
	</table>
	</h2>
   </hgroup>
   </div>
   
   <header class="group_bannner_right">
   <hgroup>
   <img alt="jfreechart" src="jfree_tw_zhu.action"/>
   </hgroup>
   </header>
   </div>

   
  </body>
</html>
