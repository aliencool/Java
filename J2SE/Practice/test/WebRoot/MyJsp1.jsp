<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp1.jsp' starting page</title>
    
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
  <c:choose>
  	<c:when test="${param.select eq 'zh'}">
  	<fmt:setLocale value="zh"/>
  	<fmt:setBundle basename="Language_zh" var="boundle" scope="session"/>
  	</c:when>
  	<c:when test="${param.select eq 'en'}">
  	<fmt:setLocale value="en"/>
  	<fmt:setBundle basename="Language_en" var="boundle" scope="session"/>
  	</c:when>
  </c:choose>
  <c:set value="0" var="max"/>
   <fmt:message key="title" bundle="${boundle}"/>
 <br/>
    <c:forTokens items="${param.maxvalue}" var="num" delims=",">
    	    <c:out value="${num}"></c:out><br/>
    	<c:if test="${num>max}">
    		<c:set value="${num}" var="max"/>
    	</c:if>
    </c:forTokens>
    <fmt:message key="title" bundle="${boundle}"/><c:out value=":${max}"></c:out>
  </body>
</html>
