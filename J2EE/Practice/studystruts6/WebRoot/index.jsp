<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
  </head>
  
  <body><!-- 要加"/"的  与struct.xml一样 -->
  <s:form method="post" action="reg" namespace="/RA" theme="simple">  
    <table border="9">  
        <tr>  
            <td>姓名</td>  
            <td><s:textfield name="username" /></td>  
            <%-- 在字段的后面显示错误信息，如此稍显人性化 --%>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>username</s:param>   
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>密码</td>  
            <td><s:password name="password" /></td>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>password</s:param>   
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>重复密码</td>  
            <td><s:password name="password1" /></td>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>password1</s:param>     
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>年龄</td>  
            <td><s:textfield name="age"/></td>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>age</s:param>    
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>生日</td>  
            <td><s:textfield name="birthday"/></td>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>birthday</s:param>   
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>Email</td>  
            <td><s:textfield name="email"/></td>  
            <td>  
                <s:fielderror cssStyle="font-size:20px;color:red;text-align:left;font-weight:bold">  
                    <s:param>email</s:param>     
                </s:fielderror>  
            </td>  
        </tr>  
        <tr>  
            <td>&nbsp;</td>  
            <td><s:submit value="提交"/></td>  
        </tr>  
    </table>  
</s:form>  
  </body>
</html>
