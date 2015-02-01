<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <title>My JSP 'index.jsp' starting page</title>
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
    <s:form method="post" enctype="multipart/form-data" action="upload" namespace="/ActionUpload">
			<s:text name="name">
				<s:param>
					<s:property value="fdfdsf"/>
				</s:param>
			
			</s:text>
    	<s:file  name="file" label="%{getText('struts.message.error.file.too.large')};"/>
    	<s:submit value="submit"/>
    </s:form>
  </body>
</html>
