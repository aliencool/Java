<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
</head>

<body>
<sx:head extraLocales="UTF-8"/> 
	<s:form action="add" enctype="multipart/form-data">
           <s:textfield label="新闻标题:" name="title" type="text"/>
          <s:textfield label="新闻来源:" name="soure" type="text"/>
       	<sx:datetimepicker name="datetime" label="新闻时间:" displayFormat="yyyy-MM-dd"/>
       	<s:file name="file" label="新闻图片"></s:file>
         <s:textarea label="新闻内容:" name="tt" rows="10"/>
            <s:submit name="submit" label="提交"/>
	</s:form>
</body>
</html>
