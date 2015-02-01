<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Search_Jsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<title>Direction by FCT</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="http://fonts.googleapis.com/css?family=Arvo:400,700" rel="stylesheet" type="text/css" />
	<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
	<!--[if IE 6]>
	<link href="default_ie6.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<script type="text/javascript" src="http://172.16.142.98:8080/Struts2_Hibernate/css/ajax.js"></script> 
  </head>
  
  <body>
   <div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">实时新闻</a></h1>
			<p>Template Design by <a href="#" rel="nofollow">蔡朝臣</a></p>
		</div>
		<div id="menu">
			<ul>
				<li><a href="#" accesskey="1" title="">首页</a></li>
				<li><a href="#" accesskey="2" title="">新闻列表</a></li>
				<li><a href="#" accesskey="3" title="">关于我们</a></li>
	
				<li><a href="#" accesskey="4" title="">联系</a></li>
			</ul>
		</div>
	</div>
  <div id="page">
		<div id="content">
		   		<div id="tbox1">
				<h2>Information</h2>
				<ul class="style2">
					<c:forEach items="${Message_search}" var="news">
					<li>
						<h3><a href="show.action?id=${news.id}">${news.title}</a></h3>--<a href="show.action?id=${news.id}">${news.issue_time}</a>--<a href="show.action?id=${news.id}">${news.source}</a>
						<p><a href="show.action?id=${news.id}">${fn:substring(news.content,0,15)}........</a></p>
					</li>
					</c:forEach>
				</ul>
			</div>
			</div>
		<div id="sidebar">
			<div id="tbox1">
				<h2>Information</h2>
				<ul class="style2">
					<li class="first">
						<h3>搜索</h3>
							<p><input type="text" id="search" onkeyup="getSuggest(this.value,event);upanddown(event,this.value);"/></p>
						<div id="dSuggest" class="dSuggest"></div>
					</li>
					<c:forEach items="${Message}" var="news">
					<li>
						<h3><a href="show.action?id=${news.id}">${news.title}</a></h3>--<a href="show.action?id=${news.id}">${news.issue_time}</a>--<a href="show.action?id=${news.id}">${news.source}</a>
						<p><a href="show.action?id=${news.id}">${fn:substring(news.content,0,15)}........</a></p>
					</li>
					</c:forEach>
				</ul>
			<p><a href="All_index.jsp" class="button-style">Read More</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	  <p>Copyright (c) 2013  All rights reserved. Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">蔡朝臣</a>. Photos by <a href="http://fotogrph.com/">蔡朝臣</a>.</p>
	</div>
</div>
  </body>
</html>
