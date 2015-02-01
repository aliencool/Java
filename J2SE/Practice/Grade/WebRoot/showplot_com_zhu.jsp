<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.grade.bean.Save_command_data"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html>
  <head>
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
    <h2>
   <table border="1">
		<tr>
			<th>判别分类</th>
			<th>原有分类</th>
			<th>后座概率</th>
		</tr>
		<% Save_command_data data=(Save_command_data)session.getAttribute("comm");
		   double [][] data_show=data.getNew_Sort();
		for(int i=1;i<=data.getCount();i++)
		{
		 %>
		<tr>		
				<td><%=(int)data_show[i][1] %></td>
				<td><%=(int)data_show[i][2] %></td>		
				<td><%=data_show[i][3] %></td>		
		</tr>
		<%} %>
		
	
		
	</table>
	</h2>
   </hgroup>
   </div>
   
   <header class="group_bannner_right">
   <hgroup>
  <img alt="jfreechart" src="jfree_com_zhu.action"/>
   </hgroup>
   </header>
   </div>
    
	</header>
   
   <!--start intro-->

   <!--end intro-->

   
   
   <!--start holder-->

  
  </body>
</html>
