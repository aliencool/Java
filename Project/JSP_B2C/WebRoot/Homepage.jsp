<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.Bean.ShopBean"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="zh-CN" xml:lang="zh-CN">
<head>
<title>欢迎来到商城</title>
<base href="http://172.16.142.98/Web/" />
<link href="http://172.16.142.98/Web/image/data/cart.png" rel="icon" />
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/stylesheet.css" />

<!--[if IE 7]>
<link rel="stylesheet" type="text/css" 

href="catalog/view/theme/default/stylesheet/ie7.css" />
<![endif]-->
<!--[if lt IE 7]>
<link rel="stylesheet" type="text/css" 

href="catalog/view/theme/default/stylesheet/ie6.css" />
<script type="text/javascript" src="catalog/view/javascript/DD_belatedPNG_0.0.8a-

min.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('#logo img');
</script>
<![endif]-->

<!-- 已经设置userBean -->
<%@ taglib uri="/Tag"  prefix="msg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/js/jquery.nivo.slider.pack.js";>
</script>
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/stylesheet.css" />
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/nivo-slider.css" />
</head>
<body>
<style type="text/css">
#img {
	margin-bottom: 30px;
	text-align: center;
	margin-top: 100px;
}
*{margin:0px;padding:0px;}
#img img {
	width: 450px;
}

#img b {
	font-size: 20px;
	color: #a0a0a0;
	margin-left: -90px;
	position: relative;
}

#keyword {
	width: 570px;
	height: 30px;
	border: 2px solid #A0A0A0;
	font-size: 17px;
}

#input {
	text-align: center;
	margin: 0px;
}
#dSuggest {
	height: 150px;
	background-color: white;
	font-size: 15px;
	width: 150px;
	margin: 0px auto;
	display: none;
	position: absolute;
}


#sug {
	list-style: none;
	padding-left: 0;
	border-left: 1px solid #a0a0af;
	border-right: 1px solid #a0a0af;
	border-bottom: 1px solid #a0a0af;
	width: 293px;
	margin-left: 0px;
	margin-bottom: 0;
	margin-top: 0;
	text-align: left;
}

#sug li {
	height: 30px;
}

.select {
	background-color: #dddddd;
}

#submit {
	display: inline;
}

#sub {
	background-color: #f1f1f1;
	border: 1px solid #dcdcdc;
	margin-left: 15px;
	height: 30px;
	font-size: 13px;
}
.title{font-size:14px;;cursor:pointer;}


#slide{overflow:hidden;width:970px;left:550px}
ul{list-style:none;}
#showleft{float:left;margin-left:3px;padding:3px;list-style:none;}
.slideul1{width:3999px;}


#slider{width: 970px; height: 350px;z-index:0 }
.nivo-controlNav a{display:none;text-indent:-9999px;border:0;}
.nivo-directionNav a {display:block;width:30px;height:30px;background:url(http://172.16.142.98:8080/ZH_2/Imge/homepage/arrows.png) no-repeat;text-indent:-9999px;border:0;}
a.nivo-nextNav {background-position:-30px 0;right:15px;}
a.nivo-prevNav {left:15px;}


 #copy {
			font-family: "republic-web-1","republic-web-2",serif;
		text-align:center;
		font-size: 12px;
		MARGIN-RIGHT: auto; 
		MARGIN-LEFT: 200px;
	}

	#copy .strike {
		width: 24px;
		height: 10px;
		text-align:center;
		padding-top: 10px;
		float: left;
		background:  url('http://www.teixido.co/gfx/backs/back_copy_line.png') repeat-x left center;			
	}
	#copy .copyright {
	text-align:center;
		width: 460px;
		float:left;
		text-align: center;
	}
	#copy .copyright  span.smallcaps {
	text-align:center;
			font-family: "republic-web-1","republic-web-2",serif;
			text-transform: uppercase;
			font-size: 10px; 
			letter-spacing: 0.3px; 
	}
</style>


<script type="text/javascript">
	//得到键盘的值
	var select=0;
	var count=0;
	function getKeyCode(e)
	{
		var keycode;
		if(window.event)
		{
			keycode=e.keyCode;
		}
		else if(e.which)
		{
			keycode=e.which;
		}
		return keycode;
	}
	
	function getSuggest(keyword,e)
	{
		var keycode=getKeyCode(e);
		//如果他按下 上和下或者Enter则返回
		if(keycode==40||keycode==38||keycode==13)
		{
			return;
		}
		if(escape(keyword)==null)
		{
			document.getElementById("dSuggest").innerHTML="";
			return;
		}
		
		var url = "http://172.16.142.98:8080/ZH_2/control?keyword="+escape(keyword)+"&action=search";
		var xmlHttp;
		if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();
		}
		else
		{
			xmlHttp=new ActiveX("Microsoft.XMLHTTP");
		}
		
			xmlHttp.open("POST", url,true);
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xmlHttp.onreadystatechange=function()
			{	
			
				if(xmlHttp.readyState==4&&xmlHttp.status==200)
				{
					var Text=xmlHttp.responseText;
					if(Text!=404&&Text!="")
					{
						var spit_msg=Text.split("|");
						var msg="<ul id='sug'>";
						for(var i=0;i<spit_msg.length-1;i++)
						{
						if(i==5)break;
							var msg=msg+
						"<li  onclick=\"theMouseClick("+ count +")\" onmouseover=\"theMouseOver(" + count + ");\" " +
							"onmouseout=\"theMouseOut("+ count +");\">"+spit_msg[i]+"</li>";
						//下一个就++
						count++;
						}
						msg=msg+"</ul>";
						document.getElementById("dSuggest").innerHTML=msg;
						showDiv();
						//下次到来就重新刷新
						count=0;
					}	
				}
			}
			xmlHttp.send(null);
		
	}
	//设置div为可见
	function showDiv() {
	//让他自动换行
		document.getElementById("dSuggest").style.display = "block";
	}
	//单击某个值
	function theMouseClick(pos) {
		var key =document.getElementById("sug").getElementsByTagName("LI")[pos].innerHTML;
	
		document.getElementById("filter_name").value=key;
		clear();
	}
	function upanddown(e)
	{
		var keycode=getKeyCode(e);
		//得到所有节点
		var li =document.getElementById("sug").getElementsByTagName("LI");
		if(keycode==13)
		{
			window.location.href="http://172.16.142.98:8080/ZH_2/control?action=search_enter";
		}
		
		//你选择
		if(keycode==38||keycode==40)
		{
			if(li==null)
			{
				return;
			}
		
			//向上
			if(keycode==38)
			{
				select--;
				//小于0表示  显示最后一条 从0所以减一
				if(select==-1)select=li.length-1;
			}
			//向下
			if(keycode==40)
			{
				
				select++;
				//大于长度  显示一条
				if(select>=li.length)select=0;
			}
				//先设置颜色
		set_style(select);
		//先再设置其他
		var key =document.getElementById("sug").getElementsByTagName("LI")[select].innerHTML;
		document.getElementById("filter_name").value=key;	
		
		
		}
		
	
	}
	
	function clear()
	{
		document.getElementById("dSuggest").style.display = "none";
	}
	
	//设置高亮
	function set_style(num)
	{
		//得到所有标签
		var key =document.getElementById("sug").getElementsByTagName("LI");
		for(i=0;i<key.length;i++)
		{
			if(i==num)
			{
				document.getElementById("sug").getElementsByTagName("LI")[i].className="select";
			
			}
			else
			{
				document.getElementById("sug").getElementsByTagName("LI")[i].className="";
			}
		}
	}
	
	//鼠标移进
	function theMouseOver(pos)
	{
		document.getElementById("sug").getElementsByTagName("LI")[pos].className="select";
		var key =document.getElementById("sug").getElementsByTagName("LI")[pos].innerHTML;
		//这里要注意当用户在当前鼠标位置按下 上下键的时候，应该从当前位置上下，而不应该从其他位置上下
		select=pos;
		document.getElementById("filter_name").value=key;	
	}
	
	//鼠标移走
		function theMouseOut(pos)
	{
		document.getElementById("sug").getElementsByTagName("LI")[pos].className="";
	}
	
	function add(index)
	{
		var xmlHttp;
		if (window.XMLHttpRequest)
 	 	{// code for IE7+, Firefox, Chrome, Opera, Safari
 			xmlHttp=new XMLHttpRequest();
 		}
		else
 		{// code for IE6, IE5
 			 xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
 		}
		var url = "http://172.16.142.98:8080/ZH_2/control?id="+index+"&action=addcar";
		xmlHttp.open("POST", url,true);
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.onreadystatechange=function()
		{
			if(xmlHttp.readyState==4&&xmlHttp.status==200)
			{
					var num=xmlHttp.responseText;
					if(num!=null)
					  document.getElementById("notification").innerHTML='<div class="success"><b>'+num+'</b><a method="post" href="http://172.16.142.98:8080/ZH_2/showcar.jsp">查看购物车</a></div>'
			}
		}
  
   		xmlHttp.send(null);
	}
		function showmenu(id) {
	
	if (id.style.display=="none") {
		id.style.display="block";
	}else {
		id.style.display="none";
	}
}
	function showmenu2(id) {
		id.style.display="block";
}

	function shownone(id)
	{
	
		id.style.display="none";
	} 
	
	
	$(function(){
		$('#slider').nivoSlider();
	});
</script>

<div id="container">


<div id="header"><div id="logo"><a href="http://172.16.142.98:8080/ZH_2"><img src="http://172.16.142.98:8080/ZH_2/Imge/Re/251110294145.png" title="Your Store" alt="Store" /></a></div>
        <div id="cart">
</div>  <div id="search">
    <div class="button-search"></div>
        <input type="text" id="filter_name" value="搜索" onkeyup="getSuggest(this.value,event);upanddown(event)" 

onkeydown="this.style.color = '#000000';" />

		<div id="blank0"></div>
		<div id="dSuggest" ></div>
      </div>

   <div id="welcome">
        欢迎您,您登录为:<b><a href="http://172.16.142.98:8080/ZH_2/Person_Info.jsp">${user.user}</a>
   <br />
   <a ></a>
    ${user.time_Start}
    </b>
         <b>(</b> <a href="http://172.16.142.98:8080/ZH_2/control?action=out">退出</a> <b>)</b>      </div>
 <div class="links"><a href="http://172.16.142.98:8080/ZH_2/">首页

</a><a href="http://172.16.142.98:8080/ZH_2/register.jsp">注册</a><a href="http://172.16.142.98:8080/ZH_2/showcar.jsp">去结账</a>
<a href="http://172.16.142.98:8080/ZH_2/Chart.jsp">Charte</a>
</div>
</div>
<div id="menu">
  <ul>
  		<c:forEach items="${navigation}"  var="nav">
  		   <li><a href="http://172.16.142.98:8080/ZH_2/Category_control?action=category&category=${nav.category_name}&page_count=1" onmousemove="showmenu2(${nav.category_name}2)">${nav.category_name}</a>
  		   <div id="${nav.category_name}2" onmouseout="shownone(${nav.category_name}2)" onmousemove="showmenu2(${nav.category_name}2)" style="display: none;">
  		           <ul>
                      <!--每次都遍历-->
                       <c:forTokens items="${nav.category_son_name}" delims="," var="son_name">   
							<li>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://172.16.142.98:8080/ZH_2/Category_control?action=category_son&category=${son_name}&category_father=${nav.category_name}&page_count=1">-${son_name}</a>					
							</li>
					 </c:forTokens>	
					 </ul>
					 </div>	
          </li>
  		</c:forEach>
      </ul>
</div>











<div id="notification"></div>
 
<div id="content">  
	<div id="slider" class="nivoSlider">
		   <a href="http://172.16.142.98:8080/ZH_2/success.jsp"><img src="http://172.16.142.98:8080/ZH_2/Imge/show/s1.jpg" alt="" title="Welcome"  /></a>
		   <a href="http://172.16.142.98:8080/ZH_2/success.jsp"><img src="http://172.16.142.98:8080/ZH_2/Imge/show/s2.jpg" alt="" title="Producte"  /></a>
	</div>
	
	
	<div id="slide"> 
	<ul class="slideul1"> 
		<li class="slideli1" id="showleft"> 
      		<ul class="slideul2"> 
			 <li class="left" id="showleft"><img src="http://172.16.142.98:8080/ZH_2/Imge/homepage/2.jpg" alt="PALM" title="PALM" /></li>
		        <li class="left" id="showleft"> <img src="http://172.16.142.98:8080/ZH_2/Imge/homepage/3.jpg" alt="SONY" title="SONY" /></li>
		         <li class="left" id="showleft"><img src="http://172.16.142.98:8080/ZH_2/Imge/homepage/4.jpg" alt="CANON" title="CANON" /></li>
		   
			</ul> <li id="showleft" class="slideli2"></li> </li> 
		
	</ul> 
</div> 
	
	
	
</div> 
       
 <script type="text/javascript">
 var speed=30;
 var _slide=$('#slide');
 var _slideli1=$('.slideli1');
 var _slideli2 = $(".slideli2");
_slideli2.html(_slideli1.html());
 
 function move_imge()
 {	
 	
 	if(_slide.scrollLeft() >= _slideli1.width())
 	{
 
 	_slide.scrollLeft(0);
 	}
		
 	else
 	{	
 		
 		_slide.scrollLeft(_slide.scrollLeft()+1);
 	}
 
 }
 $(
 	function start_image()
 	{
 		var max=setInterval(move_imge,speed);
 		//动画运动
 	_slide.hover(
 	function()
 	{
 		clearInterval(max);
 	},function ()
 	{
 		max=setInterval(move_imge,speed);
 	}
 	);
 	}
 );
 </script>   
<div id="copy">
		<div class="strike"></div>
		<div class="copyright"><p>All Text and Images are Copyright © 2013 <span class="smallcaps">Techology</span>
	- <a href="http://weibo.com/sso/login.php?ssosavestate=1389884065&url=http%3A%2F%2Fweibo.com%2F%3Fc%3Dspr_web_yilang_maxthon_weibo_p003&ticket=ST-MTc3NDE0NzEyNw==-1387292065-xd-C2DC97FDF7012CB605F08F8F217718C2&retcode=0">蔡朝臣</a></div>		
		</p>
		<div class="strike"></div>
	</div>
			
<!--
OpenCart is open source software and you are free to remove the powered by OpenCart if you 

want, but its generally accepted practise to make a small donation.
Please donate via PayPal to donate@opencart.com
//-->
<!--
OpenCart is open source software and you are free to remove the powered by OpenCart if you 

want, but its generally accepted practise to make a small donation.
Please donate via PayPal to donate@opencart.com
//-->
</div>
</body>

</html>

