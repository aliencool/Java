<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 3.0 License

Name       : Definitive
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20120805
-->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<title>Definitive by Free CSS Templates</title>
		<link href="http://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet" type="text/css" />
		<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
		<link href="http://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div id="logo">
					<h1><a href="#">XML</a></h1>
				</div>
				<div id="menu">
					<ul>
						<li class="first current_page_item"><a href="#">Homepage</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Links</a></li>
						<li class="last"><a href="#">Contact</a></li>
					</ul>
					<br class="clearfix" />
				</div>
			</div>
			<div id="page">
				<div id="content">
					<div class="box">
						<h2>Welcome to Trans</h2>
						<img class="alignleft" src="images/pic01.jpg" width="200" height="200" alt="" />
						<p>
							请点击下面的按钮选择您需要转换的数据库</p>
					</div>
					<div id="col1" class="box">
						  	<s:form action="trans" >
  		 <c:forEach var="dbname" items="${bean_name.getData_name()}" >
  		 <c:if test="${not empty dbname}">
  		 	<p><input type="radio" value="${dbname}" name="dbname" >${dbname}</p>
  		 </c:if>
    	
    </c:forEach>
  			<s:submit value="提交"></s:submit>
  	</s:form>
  
  
  
					</div>
					<br class="clearfix" />
				</div>
				<br class="clearfix" />
			</div>
			<div id="page-bottom"><br class="clearfix" />
			</div>
		</div>
		<div id="footer">
			&copy; 2012 Untitled | Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a> | Images by <a href="http://fotogrph.com/">Fotogrph</a>
		</div>
	</body>
</html>