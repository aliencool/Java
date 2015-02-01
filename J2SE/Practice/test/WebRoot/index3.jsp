<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.Studen"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <base href="<%=basePath%>">
    <style type="text/css">
    table
  {
  border-collapse:collapse;
  }

    </style>
    <title>My JSP 'index3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <%
  	Studen studen=new Studen(1,"Tom",25,"Man",new int[]{88,88,99});
  	Studen studen1=new Studen(2,"Jyl",22,"Woman",new int[]{88,88,99});
  	Studen studen2=new Studen(3,"MLI",23,"Gril",new int[]{88,88,99});
  	ArrayList<Studen> st=new ArrayList<Studen>();
  	st.add(studen);
  	st.add(studen1);
  	st.add(studen2);
  	session.setAttribute("st",st);
   %>
  
 <script type="text/javascript">
 function show(va,ch)
 {
  

  	if(ch.checked)
  	{
  		document.getElementById(va).style.backgroundColor="yellow";
  	}	
  	else
 	{
 		document.getElementById(va).style.backgroundColor="FFFFFF";
 		
 	}
  
  

 	
 }
 </script> 
  
  
  
  
  <body>
  <form action="MyJsp.jsp">
     <table width="200" height="100" border="1" >
     <tr>
     	<td><br>&nbsp;</td>
     	<th>姓名</th>
     	<th>年龄</th>
     	<th>性别</th>
     	<td>语文</td>
     	<td>数学</td>
     	<td>英语</td>
     </tr>
     <c:forEach items="${st}" var="st">
     <tr id="${st.stuid}" >
     	<td>
     		<input type="checkbox" onclick="show(${st.stuid},this)" name="select" value="${st.stuid}"></input>
     	</td>
     	<th>
     		${st.name}
     	</th>
     	<th>
     		${st.age}
     	</th>
     	<th>
     		${st.gender}
     	</th>
     		<th>
     		${st.result[0]}
     	</th>
     		<th>
     		${st.result[1]}
     	</th>
     		<th>
     		${st.result[2]}
     	</th>
     </tr>
     
     </c:forEach>
     
     </table>
     <input type="submit" value="提交"></input>
      </form>
  </body>
</html>
