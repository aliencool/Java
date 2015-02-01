<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 引入 -->
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <title>My JSP 'showmes.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{
  	width:960px;
  	margin:15px auto;
 	font-family: Arial, "MS Trebuchet", sans-serif;
	}
	
	</style>
  </head>
  
  <body>
  <!-- Required -->
       <fieldset>
    	<legend >
    		Required
    	</legend>
    	<ul>
    		<li>
    			<s:property value="name"/>
    		</li>
    		<li>
    			<s:property value="password"/> 
    				
    		</li>
    	</ul>
    </fieldset>
    <!-- Optional -->
      <fieldset>
    	<legend >
    		Option
    	</legend>
    	<ul>
    		<li>
    			
    				<s:property value="sx"/>
    		</li>
    		<li>
    			
    				<s:property value="hob"/>
    		</li>
    		
    		<li>
    			<s:iterator value="fav" var="f">
    			<s:property value="f"/>
    			
    			</s:iterator>
				
    		
    		</li>
    		
    		<li>
    			
				<s:property value="mes"/>
    		
    		</li>
    	
    	</ul>
    </fieldset>    
    
    
    
    
    
    
    
  </body>
</html>
