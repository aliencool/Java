<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎登陆</title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen, projection">
  </head>
  <style>
  .font1{
  	font-size:30px;
  	font-family:"黑体";
  	color:"#008080";
  }
  </style>
  <body><center>
  <%
  String username = (String)session.getAttribute("user");
  %>
  <br/>
  <h3>欢迎用户：<span class="font1"><%=username%></span>&nbsp;&nbsp;光临留言板</h3>
  <br/><br/><br/>
  <h3><a href="index.jsp">进入留言板进行留言</a></h3>
  </center>
  </body>
</html>
