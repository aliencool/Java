<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.web.css?V=20120501" media="screen" />
<script type="text/javascript" src="resources/js/jquery-1.8.3.js"></script>
 <script type="text/javascript" src="resources/js/check.js"></script>
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.loginandreg.css?V=20120501" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.webkitanimation.css?V=20120501" media="screen" />
<title>注册页面</title>
</head>
<body>

<div class="theCenterBox" style="">
  <style>
.theCenterBox{width:670px; margin-top:100px;}
</style>
  <div class="theLoginBox" style="width:657px">
    <div class="loginTxt">注册账号</div>
    <form id="myform" enctype="multipart/form-data" onSubmit="check_all();"  action="UserAction" method="post">
      <div class="theLoginArea" id="loginBox">
        <p style="position: relative;">
          <label >用户名:<font color="#FF0000" size="3">*</font></label>
          <input placeholder="请输入您的用户名" name="actionuser.u_Name"  onblur="check_User();"   id="LoginForm_user" type="text" maxlength="255"/>
          
          <div id="user"></div>
        <p style="position: relative;">
          <label >昵称：<font color="#FF0000" size="3">*</font></label>
          <input placeholder="请输入您的昵称(也就是网名啦)" name="actionuser.u_Nickname" onKeyDown="cheack_nick();"  onBlur="cheack_nick();"  id="LoginForm_nickname" type="text" maxlength="255" />
       		<div id="nickname"></div>
            
        <p style="position: relative;">
          <label >邮箱：<font color="#FF0000" size="3">*</font></label>
          <input placeholder="请输入您的邮箱" name="actionuser.u_Email" onKeyDown="cheack_email();" onBlur="cheack_email();"  id="LoginForm_email" type="text" maxlength="255" /><div id="email"></div>
       	
        <input type="hidden" name="flag" value="0"/>
        <p style="position: relative;">
          <label >生日：<font color="#FF0000" size="3">*</font></label>
          <input placeholder="请输入您的生日" name="actionuser.u_Birthday"  onKeyDown="cheack_birthday();" onBlur="cheack_birthday();"  id="LoginForm_birthday" type="text" maxlength="255" />
        <div id="birthday"></div>
        <p style="position: relative;">
          <label >头像：<font color="#FF0000" size="3">*</font></label>
          <input type="file" name="file">
       
        <p style="position: relative;">
          <label >密码：<font color="#FF0000" size="3">*</font></label>
          <input placeholder="请输入您的密码"    id="LoginForm_password" type="password" maxlength="16" />
          <div id="answerJS"></div>
        <p style="position: relative;">
          <label >重新输入密码：<font color="#FF0000" size="3">*</font></label>
          <input placeholder="万一你输错了呢？重新输入个确认" onKeyDown="cheack_password();" onBlur="cheack_password();" id="LoginForm_check_passworld" name="actionuser.u_Password" type="password" value="" />
         <div id="answer1JS"></div>
            
        <p style="position: relative;">
          <label >通讯地址：</label>
          <input placeholder="可以不填，但是，你忍心？" name="actionuser.u_City"  id="LoginForm_area" type="text" value="" />
          <div id="city"></div>
          
          <p style="position: relative;">
          <label >您的个性签名：</label>
          <input placeholder="你的个性不写下来？"  name="actionuser.u_Sign"  id="LoginForm_sign" type="text" value="" />
         <div id="sign"></div>
         
        <div class="loginSubmitBnt">
          <div class="reg_submit">
            <input name="userSubmit" onClick="check_all();" class="theSubmitButton" value="" type="submit" />
          </div>
        </div>
      </div>
      <div class="theRegArea fixRegHeight" id="reg_reg">
      <h2 style="color:#F00">*:必填</h2>
      
      <br/>
        <h2>已经有账号？</h2>
        <br/>
        <a class="reg_login" href="login.jsp"></a> </div>
    </form>
  </div>
  
</div>
</body>
</html>

