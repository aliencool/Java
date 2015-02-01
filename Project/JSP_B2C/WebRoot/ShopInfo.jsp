<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.Bean.ShopBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="zh-CN" xml:lang="zh-CN">
<head>
<title>书城</title>
<base href="http://172.16.142.98/Web/" />
<link href="http://172.16.142.98/Web/image/data/cart.png" rel="icon" />
<link rel="stylesheet" type="text/css" 
href="catalog/view/theme/default/stylesheet/stylesheet.css" />
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/stylesheet.css" />
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/ui/jquery-ui-1.8.16.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/ui/themes/ui-lightness/jquery-ui-1.8.16.custom.css" />
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/colorbox/jquery.colorbox.js"></script>
<link rel="stylesheet" type="text/css" href="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/colorbox/colorbox.css" media="screen" />
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/jquery/tabs.js"></script>
<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/catalog/view/javascript/common.js"></script>
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

<%@ taglib uri="/Tag"  prefix="msg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<style type="text/css"> 
s#img { 
	margin-bottom: 30px; 
	text-align: center; 
	margin-top: 100px; 
} 
 
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
 		//得到的时候你设置的
 		var count=document.getElementById("quantity").value;

		var url = "http://172.16.142.98:8080/ZH_2/control?id="+index+"&action=addcar&count="+count;

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
	//每次用户点击就显示全部
	function add_mesg()
	{
		
		document.getElementById("review").innerHTML='<div class="attention"><img src="catalog/view/theme/default/image/loading.gif" alt="" />请稍候！</div>'
		window.setTimeout(add_mesagsubmit,600)
  
	}
	function add_mesagsubmit()
	{
		var xmlHttp;
		//得到选中的值
		var radiolen=document.getElementsByName("rating");
		var level;
		for(var i=0;i<radiolen.length;i++)
		{
			if(radiolen[i].checked)
			{
				level=radiolen[i].value;
			}
		}
		if (window.XMLHttpRequest)
 	 	{// code for IE7+, Firefox, Chrome, Opera, Safari
 			xmlHttp=new XMLHttpRequest();
 		}
		else
 		{// code for IE6, IE5
 			 xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
 		}
 
		var url = "http://172.16.142.98:8080/ZH_2/ShopInfo_Control?action=addshowmes&user="+'${user.user}'+"&shopid="+${shopinfo.shop_id}+"&level="+level+"&msg="+document.getElementById("text").value;
		xmlHttp.onreadystatechange=function ()
		{
			if(xmlHttp.status==200&&xmlHttp.readyState==4)
			{
				var text=xmlHttp.responseText;
				document.getElementById("review").innerHTML='<div class="success">'+text+",Please Waiting for a minitue and Enter again this page!"+'</div>';
			}
		}
		xmlHttp.open("POST", url,true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
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
           <b>
         
           </b>
    </b>
         <b>(</b> <a href="http://localhost:8080/ZH_2/control?action=out">退出</a> <b>)</b>      </div>
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
<div id="column-left">
    <div class="box">
  <div class="box-heading">商品分类</div>
  <div class="box-content">
    <div class="box-category">
		
  	<c:forEach items="${navigation}" var="nav">
  		             <li>
                    <div class="title" id="${nav.category_name}"  onclick="showmenu(${nav.category_name}1)">${nav.category_name}</div>
                      <div id="${nav.category_name}1"  style="display: none;">
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
    </div>
  </div>
</div>
<script type="text/javascript"><!--
$(document).ready(function() {
	$('#banner0 div:first-child').css('display', 'block');
});

var banner = function() {
	$('#banner0').cycle({
		before: function(current, next) {
			$(next).parent().height($(next).outerHeight());
		}
	});
}

setTimeout(banner, 2000);
//--></script> </div>
 
<div id="content">  <div class="breadcrumb">
		<c:choose>
			<c:when test="${param.category eq 'nagivation_son'}">
<a href="http://172.16.142.98:8080/ZH_2">首页</a>»<a href="http://172.16.142.98:8080/ZH_2/Nagivation_son.jsp?category=${param.son}">商品子导航(${param.son})</a>»<a href="http://172.16.142.98:8080/ZH_2/ShopInfo.jsp?category=nagivation_son">商品信息(${shopinfo.shop_name})</a>			
			</c:when>
			
			<c:when test="${param.category eq 'nagivation'}">
<a href="http://172.16.142.98:8080/ZH_2">首页</a>»<a href="http://172.16.142.98:8080/ZH_2/Nagivation.jsp?category=${param.father}">商品总导航(${param.father})</a>»<a href="http://172.16.142.98:8080/ZH_2/ShopInfo.jsp?category=nagivation">商品信息(${shopinfo.shop_name})</a>							
			</c:when>
			
			<c:when test="${param.category eq 'search'}">
<a href="http://172.16.142.98:8080/ZH_2">首页</a>»<a href="http://172.16.142.98:8080/ZH_2/control?action=search_enter">搜索</a>»<a href="http://172.16.142.98:8080/ZH_2/ShopInfo.jsp?category=search">商品信息(${shopinfo.shop_name})</a>					
			</c:when>
			
			<c:otherwise>
				<a href="http://172.16.142.98:8080/ZH_2">首页</a>»<a href="http://172.16.142.98:8080/ZH_2/ShopInfo.jsp">商品信息(${shopinfo.shop_name})</a>
			</c:otherwise>
		</c:choose>
      </div>
  <h1>欢迎来到商城</h1>
  <h2>简介</h2>
  <div class="category-list">
      <p>
Welcome to SuperMarkt</p>
      </div>      <div class="product-filter">
    <div class="display"><b>显示方式：</b> </div>
  </div>
  <div class="product-info">
        <div class="left">
            <div class="image"><a href="http://172.16.142.98/Web/image/cache/data/macbook_1-500x500.jpg" title="MacBook" class="colorbox" rel="colorbox"><img src="http://172.16.142.98/Web/image/cache/data/macbook_1-228x228.jpg" title="MacBook" alt="MacBook" id="image" /></a></div>
                  <div class="image-additional">
                <a href="http://172.16.142.98/Web/image/cache/data/macbook_3-500x500.jpg" title="MacBook" class="colorbox" rel="colorbox"><img src="http://172.16.142.98/Web/image/cache/data/macbook_3-74x74.jpg" title="MacBook" alt="MacBook" /></a>
                <a href="http://172.16.142.98/Web/image/cache/data/macbook_2-500x500.jpg" title="MacBook" class="colorbox" rel="colorbox"><img src="http://172.16.142.98/Web/image/cache/data/macbook_2-74x74.jpg" title="MacBook" alt="MacBook" /></a>
                <a href="http://172.16.142.98/Web/image/cache/data/macbook_4-500x500.jpg" title="MacBook" class="colorbox" rel="colorbox"><img src="http://172.16.142.98/Web/image/cache/data/macbook_4-74x74.jpg" title="MacBook" alt="MacBook" /></a>
                <a href="http://172.16.142.98/Web/image/cache/data/macbook_5-500x500.jpg" title="MacBook" class="colorbox" rel="colorbox"><img src="http://172.16.142.98/Web/image/cache/data/macbook_5-74x74.jpg" title="MacBook" alt="MacBook" /></a>
              </div>
          </div>
        <div class="right">
      	 <div class="description">
      	 <span>品　牌：</span> <a href="http://172.16.142.98:8080/ZH_2/ShopInfo_Control?action=shopinfolist&shopid=${shopinfo.getShop_id()}">${shopinfo.shop_name}</a><br />
                <span>型　号：</span> Product ${shopinfo.shop_id}<br />
                <span>库存状态：</span> ${shopinfo.shop_amount}</div>
            <div class="price">销售价：                ￥${shopinfo.shop_price} <br />
                <span class="price-tax">税前：￥${shopinfo.shop_price}</span><br />
                              </div>
 
                  <div class="cart">
        <div>购买数量：          <input type="text" id="quantity" size="2" value="1" />
          &nbsp;
          <input type="button" value="加入购物车" onclick="add(${shopinfo.shop_id})" id="button-cart" class="button" />
        </div>
              </div>
            <div class="review">
        <div><img src="http://172.16.142.98:8080/ZH_2/Imge/level/stars-${LEVEL}.png" alt="${count} 评价" />&nbsp;&nbsp;<a onclick="$('a[href=\'#tab-review\']').trigger('click');">${count} 评价</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a onclick="$('a[href=\'#tab-review\']').trigger('click');">如果您对本商品有什么问题或经验，请在此留下您的意见和建议！</a></div>
        <div class="share">
        </div>
      </div>
          </div>
  </div>
  <div id="tabs" class="htabs"><a href="#tab-description">产品详细介绍</a>
        <a href="#tab-attribute">规格</a>
            <a href="#tab-review">商品评价 (已有${count} 条评价)</a>
          </div>
  <div id="tab-description" class="tab-content"><div>
	<p>
		<b>Intel Core 2 Duo processor</b></p>
	<p>
		Powered by an Intel Core 2 Duo processor at speeds up to 2.16GHz, the new MacBook is the fastest ever.</p>
	<p>
		<b>1GB memory, larger hard drives</b></p>
	<p>
		The new MacBook now comes with 1GB of memory standard and larger hard drives for the entire line perfect for running more of your favorite applications and storing growing media collections.</p>
	<p>
		<b>Sleek, 1.08-inch-thin design</b></p>
	<p>
		MacBook makes it easy to hit the road thanks to its tough polycarbonate case, built-in wireless technologies, and innovative MagSafe Power Adapter that releases automatically if someone accidentally trips on the cord.</p>
	<p>
		<b>Built-in iSight camera</b></p>
	<p>
		Right out of the box, you can have a video chat with friends or family,2 record a video at your desk, or take fun pictures with Photo Booth</p>
</div>
</div>
    <div id="tab-attribute" class="tab-content">
    <table class="attribute">
            <thead>
        <tr>
          <td colspan="2">Memory</td>
        </tr>
      </thead>
      <tbody>
                <tr>
          <td>test 1</td>
          <td>8gb</td>
        </tr>
              </tbody>
            <thead>
        <tr>
          <td colspan="2">Processor</td>
        </tr>
      </thead>
      <tbody>
                <tr>
          <td>No. of Cores</td>
          <td>1</td>
        </tr>
              </tbody>
          </table>
  </div>
      <div id="tab-review" class="tab-content">
  	<c:forEach items="${show_mes}" var="mes">
  	<div class="review-list">
  	 	<div class="author"><b>${mes.user}</b>  评论时间:${mes.time}</div>
  	<div class="rating"><img src="http://172.16.142.98:8080/ZH_2/Imge/level/stars-${mes.level}.png"/></div>
  	<div class="text">${mes.mesg}</div>
  	</div>
  	</c:forEach>
  	<div id="review"></div>
    <h2 id="review-title">如果您对本商品有什么问题或经验，请在此留下您的意见和建议！</h2>
    <b>您的姓名：</b><br />
  	 <b>${user.user}</b>
    <br />
    <br />
    <b>您的评价：</b>
    <textarea id="text" cols="40" rows="8" style="width: 98%;"></textarea>
    <span style="font-size: 11px;"><span style="color： #FF0000;">注意：</span> 评论内容不支持HTML代码！</span><br />
    <br />
    <b>顾客评分：</b> <span>差评</span>&nbsp;
    <input type="radio" name="rating" value="1" />
    &nbsp;
    <input type="radio" name="rating" value="2" />
    &nbsp;
    <input type="radio" name="rating" value="3" />
    &nbsp;
    <input type="radio" name="rating" value="4" />
    &nbsp;
    <input type="radio" name="rating" value="5" />
    &nbsp;<span>好评</span><br />
    <div class="buttons">
      <div class="right"><a id="button-review" onclick="add_mesg()" class="button">继续</a></div>
    </div>
  </div>
  
     
<script type="text/javascript"><!--
$('#button-cart').bind('click', function() {
	$.ajax({
		url: 'index.php?route=checkout/cart/add',
		type: 'post',
		data: $('.product-info input[type=\'text\'], .product-info input[type=\'hidden\'], .product-info input[type=\'radio\']:checked, .product-info input[type=\'checkbox\']:checked, .product-info select, .product-info textarea'),
		dataType: 'json',
		success: function(json) {
			$('.success, .warning, .attention, information, .error').remove();
			
			if (json['error']) {
				if (json['error']['option']) {
					for (i in json['error']['option']) {
						$('#option-' + i).after('<span class="error">' + json['error']['option'][i] + '</span>');
					}
				}
			} 
			
			if (json['success']) {
				$('#notification').html('<div class="success" style="display: none;">' + json['success'] + '<img src="catalog/view/theme/default/image/close.png" alt="" class="close" /></div>');
					
				$('.success').fadeIn('slow');
					
				$('#cart-total').html(json['total']);
				
				$('html, body').animate({ scrollTop: 0 }, 'slow'); 
			}	
		}
	});
});
//--></script>
<script type="text/javascript"><!--
$('#review .pagination a').live('click', function() {
	$('#review').fadeOut('slow');
		
	$('#review').load(this.href);
	
	$('#review').fadeIn('slow');
	
	return false;
});			


//--></script> 
<script type="text/javascript"><!--
$('#tabs a').tabs();
//--></script> 
<script type="text/javascript" src="catalog/view/javascript/jquery/ui/jquery-ui-timepicker-addon.js"></script> 
<script type="text/javascript"><!--
if ($.browser.msie && $.browser.version == 6) {
	$('.date, .datetime, .time').bgIframe();
}

$('.date').datepicker({dateFormat: 'yy-mm-dd'});
$('.datetime').datetimepicker({
	dateFormat: 'yy-mm-dd',
	timeFormat: 'h:m'
});
$('.time').timepicker({timeFormat: 'h:m'});
</script> 
</div>
<div id="footer">
    <div class="column">
    <h3>关于我们</h3>
    <ul>
            <li><a href="http://172.16.142.98/Web/index.php?

route=information/information&amp;information_id=4">关于我们</a></li>
            <li><a href="http://172.16.142.98/Web/index.php?

route=information/information&amp;information_id=3">隐私权声明</a></li>
            <li><a href="http://172.16.142.98/Web/index.php?

route=information/information&amp;information_id=5">政策&amp; 条款</a></li>
          </ul>
  </div>
    <div class="column">
    <h3>客户服务</h3>
    <ul>
      <li><a href="http://172.16.142.98/Web/index.php?route=information/contact">联系我们

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/return/insert">退换服

务</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=information/sitemap">网站地图

</a></li>
    </ul>
  </div>
  <div class="column">
    <h3>其他</h3>
    <ul>
      <li><a href="http://172.16.142.98/Web/index.php?route=product/manufacturer">品牌专区

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/voucher">礼&nbsp;品

&nbsp;券</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=affiliate/account">加盟会员

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=product/special">特别优惠

</a></li>
    </ul>
  </div>
  <div class="column">
    <h3>会员中心</h3>
    <ul>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/account">会员中心

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/order">历史订单

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/wishlist">收藏列表

</a></li>
      <li><a href="http://172.16.142.98/Web/index.php?route=account/newsletter">订阅咨询

</a></li>
    </ul>
  </div>
</div>
<div id="powered">技术支持 <a href="http://www.opencart.com">蔡朝臣</a><br /> Your Store 

&copy; 2013</div>

</div>
</body>

</html>

