<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<!-- Theme Design by Arthur Gapusan from Themeforest.net -->
	<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>他/她的空间</title>
		<!-- reset css -->
		<link rel="stylesheet" type="text/css" href="css/reset.css" />
		<!-- typography css -->
		<link rel="stylesheet" type="text/css" href="css/typography.css" />
		<!-- main css -->
		<link rel="stylesheet" type="text/css" href="css/customerStyle.css" />	
		<!-- transform css -->
		<!-- prettyphoto css -->
		<link rel="stylesheet" type="text/css" href="css/prettyphoto.css" />
		<!-- include jQuery library -->
		<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
		<!-- jquery tools script -->
		<script type="text/javascript" src="js/jquery.tools.min.js"></script>
		<!-- vtip script -->
		<script type="text/javascript" src="js/vtip.js"></script>
		<!-- jqtransform script for forms -->
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<!-- include shuffle plugin -->
		<script type="text/javascript" src="js/shuffle.js"></script>
		<!-- cufon script and font -->
		<script type="text/javascript" src="js/cufon-yui.js"></script>
		<script type="text/javascript" src="js/Tahoma_400.font.js"></script>
		<!-- PrettyPhoto script -->
		<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
		<!-- jquery form script for contact form -->
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<!--  initialize all jquery scripts -->
		<script type="text/javascript" src="js/init.js"></script>
		<script type="text/javascript">
	function ajax_Json_page( page)
	{
    //先清除全部li
    $("#ajaxrefresh li").remove();
    
    
    //先得到分页的页数和用户的id
    
    
		    var data={
		"actionPageBean.currentPage":page,
		"id":'${visitor.u_Id}'
		};
		//提交
        $.post("JsonPage",data,function(data){
        $.each(data,function(index,message){
       //拼接
       var content="<li><div class='connect'><span class='icon'><img style='height: 35px;width: 35px;' src='"+message.image+"'"+
			"alt='"+message.give_message_name+"' /></span>"+"<span class='text'>"+message.give_message_name+"Say:</span><span class='text'>"+message.msg_Content+"</span>"+"</div></li>";
			
			
			
			$("#ajaxrefresh").append(content);
       
        
        });
				
			});
	
	}
	
	
	
	function ajax_Save(id)
		{
	
			if($("#message").val()!=null||$("#message").val()!="")
			{
			//字数
			var wordLength=10;
			
			
			if($("#message").val().length>wordLength)
			{
				$("#message").val($("#message").val().substr(0,10));
				alert("亲，服务器能容量10个字哦");
				return;
			
			}
			
			
			
			
			
			
			
			
			
			
			//保存
				if(id=='${user.u_Id}'){
				alert("不能自己给自己留言");
				
				return;
				}
		    	else
				{
					var data=
					{
					"message.give_message_name":'${user.u_Name}',
					"message.msg_Content":	$("#message").val(),
					"message.image":'${user.u_Pic}',
					"message.save_M.u_Id":id
					};
			
			
					$.post("JsonPage!save",data);		
					alert("留言成功");
					$("#message").val("");
				}
			}
			else
			{
				alert("留言不能为空");	
				return;
			}
		}
	
		</script>
	</head>
	<body>
		<div class="container">
			<div class="paging"></div>
			<div class="slideshow">
				<!--============================================================================-->
				<!--================================= ITEM #1 ==================================-->
				<!--============================================================================-->
				<div class="item current-item">
					<div class="top"></div>
					<div class="content-container">
						<div class="content home-content">
							<div class="content-padding">
								<!-- Content Begin -->
								<!-- BEGIN LOGO -->
								<div id="logo">
									<a href="index.html"><img src="customerImages/logo.png" alt="logo" /></a>
								</div>
								<div id="home-icons">
									<!-- You can add more icons at the bottom right of the homepage -->
									<a href="IndexAction" class="grayscale vtip" title="return?" >
										<span><img src="customerImages/icons/grayscale/save_download_32.png" alt="" /></span>
									</a>
								</div>
								<!-- Content End -->
							</div>
							<div class="content-bottom"></div>
						</div>
						<div class="nav-container">
							<!-- Navigation for Home -->
							<div class="nav" id="home">
								<a href="" class="thumb" title="Home" ><span><img src="customerImages/menu_icons/home.png" alt="" /></span></a>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!--============================================================================-->
				<!--================================= ITEM #2 ==================================-->
				<!--============================================================================-->
				<div class="item">
					<div class="top"></div>
					<div class="content-container">
						<div class="content contact-content">
							<div class="content-padding">
								<!-- Content Begin -->
								<div class="grid_8" id="contact-form">
									<h2 class="border">Message</h2>
									<div class="divider-15"></div>
									
									<form action="sendemail.php"  id="contact_us" method="post">
									 
										<div class="rowElem">
											<label>Name:</label>
											
										${visitor.u_Name}
											
										  <div id="error1">
												
											</div>	
										</div>
										<div class="rowElem">
											<label>Email:</label>
											${visitor.u_Email}
											<div id="error2">
												
											</div>	
										</div>	
                                          <div class="rowElem">
											<label>Birthday</label>
											${visitor.u_Birthday}
											<div id="error3">
												
											</div>	
										</div>	
                                          <div class="rowElem">
											<label>City</label>
											${visitor.u_City}
										</div>
                              
									</form>
									
									<div id="note">
										<span class="notification_ok">Your message has been sent. Thank you!</span>
									</div>	
									
								</div>
								<div class="grid_4 last" id="connect">
									<h3 class="border">Image</h3>	
									<div class="divider-15"></div>
									<div id="connect-menu">
										<ul>
											<img src="${visitor.u_Pic}" style="width:206px; height:116px" ></img>
										</ul>
										
										<div class="clear"></div>
									</div>
								</div>
								<!-- Content End -->
							</div>
							<div class="content-bottom"></div>
						</div>
						<div class="nav-container">
							<!-- Navigation for Contact -->
							<div class="nav" id="contact">
								<a href="#" class="thumb" title="Show"><span><img src="customerImages/menu_icons/contact3.png" alt=""/></span></a>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				
				<!--============================================================================-->
				<!--================================= ITEM #3 ==================================-->
				<!--============================================================================-->
				
					<div class="item">
					<div class="top"></div>
					<div class="content-container">
						<div class="content contact-content">
							<div class="content-padding">
								<!-- Content Begin -->
								<div class="grid_8" id="contact-form">
									<h2 class="border">Give him Message?</h2>
									<div class="divider-15"></div>
									
								
										<div class="rowElem" id="textarea">
											<label>Message</label>
											<textarea name="Message" rows="5" cols="25"  id="message"></textarea>
											<div class="error3">
												Enter a Message
											</div>	
										</div>	
									
										<div id="submit">
											<label></label>
											<input type="submit" value="Send" onclick="ajax_Save(${visitor.u_Id});" name="submitButton"  class="form-submit" />
										</div>
					
									
									<div id="note">
										<span class="notification_ok">Your message has been sent. Thank you!</span>
									</div>	
									
								</div>
								<div class="grid_4 last" id="connect">
									<h3 class="border">Connect</h3>	
									<div class="divider-15"></div>
									<div id="connect-menu">
										<ul id="ajaxrefresh">
											<c:forEach items="${discuss}" var="dis">
											<li>
												<div class="connect">
														<span class="icon"><img style="height: 35px;width: 35px;" src="${dis.image}" alt="${dis.give_message_name}" /></span>
														<span class="text">${dis.give_message_name}Say:</span><span class="text">${dis.msg_Content}</span>
												
												</div>
											</li>
											</c:forEach>
										</ul>
											<c:forEach begin="1" end="${count}" var="count" varStatus="status">
                    <input  id="ajaxUp" type="button" style="cursor: pointer;" title="${status.count}-Page" value="${status.count}" onclick="ajax_Json_page(${status.count});" />
					</c:forEach>
										<div class="clear"></div>
									</div>
								</div>
								<!-- Content End -->
							</div>
							<div class="content-bottom"></div>
						</div>
						<div class="nav-container">
							<!-- Navigation for Contact -->
							<div class="nav" id="contact">
								<a href="#" class="thumb" title="Message"><span><img src="images/about.png" alt=""/></span></a>
							</div>
						</div>
					</div>
				
											
					<div class="clear"></div>
				</div>
				
				
				<!--  -->
			</div>
			<div class="clear"></div>
			<div id="footer">
				&copy; Copyright 2011 John Doe. All Rights Reserved.
			</div>
		</div>
		<!-- Initialize contact form script -->
		<script type="text/javascript" src="js/init_form.js"></script>
		<script type="text/javascript" >
			$(".nav a[title]").tooltip({ position: 'center', offset: [-3, 15], effect: "slide", delay: 200});
		</script>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function(){
				$("a[rel^='prettyPhoto']").prettyPhoto();
			});
		</script>
	</body>
</html>