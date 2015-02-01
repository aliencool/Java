<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" type="text/javascript">
		function cheack()
		{
			var cheackpwd=document.myform.password;
			if(cheacknum(cheackpwd))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		function cheacknum(numcheck)
		{
			var cheacknumber=/\d+/;
			
			if(!cheacknumber.test(numcheck.value))
			{
				alert("输入的格式有错误");
				numcheck.value="";
				numcheck.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
   	  <form name="myform"  method=post onsubmit="return cheack();"  action="logincheack.jsp">
    	<p align="right">
    		姓名：
    		<input size="40" name="name" value="">
    	</p>
    	<p align="right">
    		密码：
    		<input size=40 type="password" name="password" value="">
    	</p>
    	<p align="right">
    		<input class="button"   type="submit" value="登陆"  >
    		&nbsp;
    		<input type="reset" value="清除" >
    	</p>
    </form>
  </body>
</html>
