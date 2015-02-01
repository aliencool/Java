<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>留言板</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" media="screen, projection">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
  </head>
<body>
	<header>
		<h1>留言板</h1>
	</header>
	<div id="wrapper">
		<h3 id="sign-in-tab" class="active">登陆</h3>
		<h3 id="register-tab">注册</h3>
  <%
   if(request.getParameter("submit") != null){
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		if("java".equals(username) && "sise".equals(password)){
  			session.setAttribute("user",username);
  		%>
  		<jsp:forward page="login_success.jsp" />
  		<%
  		}else{
  		%> 
  		 <font color="#ff0000">用户名或者密码不正确！(请输入用户名：java，

密码：sise)</font> 
  		<%
  		}
  }
   %>
		<ul id="form-section">
			<form class="sign-in-form" action="User" method="post">
			<li>
				<label>
					<span>用户名</span>
					<input placeholder="请输入你的用户名" name="username" pattern="[a-zA-Z0-9]{6,}" type="text" tabindex="1" title="必须输入您选择的用户名来登陆" required autofocus>
				</label>
			</li>
			<li>
				<label>
					<span>密码</span>
					<input placeholder=请输入你的密码" name="password" pattern=".{6,}" type="password" tabindex="2" title="必须包含你选择注册的密码" required>
				</label>
			</li>
		
			<li>
				<button name="sign-in-submit" type="submit" id="sign-in-submit">登陆</button>
			</li>

			<div style="clear: both;"></div>
			</form>
		
			<form class="register-form" action="" method="post">
			<p><span class="register-numbering">1</span><span class="register-numbering-text">基本注册信息</span></p>
			
			<li>
				<label>
					<span>用户名*</span>
					<input type="text" name="username" tabindex="8" pattern="[a-zA-Z0-9]{6,}"  placeholder="请输入需要注册的用户名" title="至少要有6个字符长度!" required>
				</label>
			</li>
			<li>
				<label>
					<span>密码*</span>
					<input type="password" name="password" tabindex="9" pattern=".{6,}"  placeholder="请输入要设置的密码" title="密码不得少于6个字符长度" required>
				</label>
			</li>
            <p><span class="register-numbering">2</span><span class="register-numbering-text">其他注册信息</span></p>
            <div style="clear: both;"></div>
			<li>
				<label>
				<span>邮箱*</span>
				  <input type="email" name="email" tabindex="3" placeholder="请填写你的有效邮箱地址" title="必须填写一个有效的电子邮件地址。 'zf1105@scse.com' !" required>
				</label>
			</li>
			<li>
				<label>
					<span>手机号码*</span>
					<input type="tel" name="telephone" pattern="(\+?\d[- .]*){11,11}" tabindex="4" placeholder="请输入你的手机号码" title="请填写11位有效的手机号码!" required>
				</label>
			</li>
			<div style="clear: both;"></div>
			<li>
            
				<button name="submit" tabindex="11" type="submit" id="create-account-submit">创建用户</button>
			</li>
			</form>
		</ul>
	</div>
    <div style="text-align:center;clear:both"><br>

    <div id="footer">
    <p>Copyright (c) Feng. All rights reserved. Design by FengCheung </p>
  </div>
</body>
</html>
