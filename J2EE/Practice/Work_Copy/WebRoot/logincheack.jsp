<%@ page language="java" import="java.util.*" import="First.DbTest" pageEncoding="UTF-8"%>
<jsp:useBean id="test1" class="First.TestBean" scope="request">
	<jsp:setProperty property="*" name="test1"/>
</jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("GB2312");
DbTest tb=new DbTest(test1);
if(tb.ok()){
%>
<jsp:forward page="MyJsp.jsp"></jsp:forward>
<%}
else
{

	out.println("用户名或者密码错误,请<a href=\"index.jsp\">重新登陆</a>");
} %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logincheack.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
</html>
