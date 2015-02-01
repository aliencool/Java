<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--引入-->
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
   		ul li{
	list-style-type:none;
	}
	body{
  width:960px;
  margin:15px auto;
  font-family: Arial, "MS Trebuchet", sans-serif;
	}
	.errorMessage {font-weight:bold; color:red; }
    </style>
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
  <form method="post" action="S_Action/login.action">
  	<!-- Required -->
    <fieldset>
    	<legend >
    		Required
    	</legend>
    	<ul>
    		<li>
    			
    				<s:textfield name="name" label="NickName" required="true"/>
    		</li>
    		<li>
    			
    				<s:password name="password" label="Password"/>
    		</li>
    	</ul>
    </fieldset>
    
    <!-- Option -->
	    <fieldset>
    	<legend >
    		Option
    	</legend>
    	<ul>
    		<li>
    			
    				<s:radio label="Sex" name="sx" list="{'M','G'}" value="'M'"/>
    		</li>
    		<li>
    			
    				<s:checkboxlist label="Hobby" name="hob" list="#{'网球':'网球','乒乓球':'乒乓球','篮球':'篮球'}" listKey="key" listValue="value" value="{'篮球','网球'}"/>
    		</li>
    		
    		<li>
    			
					<s:select label="Favourite" name="fav" headerKey="-1" headerValue="请选择一个" emptyOption="true" multiple="true" size="4" list="#{'小说':'小说','诗歌':'诗歌','韵文':'韵文','古典文学':'古典文学'}"/>
    		
    		</li>
    		
    		<li>
    			
				<s:textarea label="Message" name="mes" rows="10" cols="30"/>
    		
    		</li>
    	
    	</ul>
    </fieldset>    
    		<s:submit value="Submit" />
			<s:reset value="Rest"/>
    </form>
  </body>
</html>
