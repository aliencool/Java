<%@page import="com.Bean.ShopCarBean" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="UTF-8" xml:lang="UTF-8">
<head>
<title>购物车内的商品</title>
<base href="http://172.16.142.98/Web/" />
<link href="http://172.16.142.98/Web/image/data/cart.png" rel="icon" />
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/stylesheet.css" />
<script type="text/javascript" src="catalog/view/javascript/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="catalog/view/javascript/jquery/ui/jquery-ui-1.8.16.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="catalog/view/javascript/jquery/ui/themes/ui-lightness/jquery-ui-1.8.16.custom.css" />
<script type="text/javascript" src="catalog/view/javascript/jquery/ui/external/jquery.cookie.js"></script>
<script type="text/javascript" src="catalog/view/javascript/jquery/colorbox/jquery.colorbox.js"></script>
<link rel="stylesheet" type="text/css" href="catalog/view/javascript/jquery/colorbox/colorbox.css" media="screen" />
<script type="text/javascript" src="catalog/view/javascript/jquery/tabs.js"></script>
<script type="text/javascript" src="catalog/view/javascript/common.js"></script>
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="catalog/view/theme/default/stylesheet/ie7.css" />
<![endif]-->
<!--[if lt IE 7]>
<link rel="stylesheet" type="text/css" href="catalog/view/theme/default/stylesheet/ie6.css" />
<script type="text/javascript" src="catalog/view/javascript/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('#logo img');
</script>
<![endif]-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/Tag" prefix="my"%>
<script type="text/javascript">	










	function deleteCar(id)
	{
		var xmlHttp;
		
		var url = "http://172.16.142.98:8080/ZH_2/control?id="+id+"&action=delete";
		if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();
		}
		else
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send(null);
		document.getElementById("shop_table").removeChild(document.getElementById(id));
		updatetoal();
		
	}




	function update(id,num)
	{
		var NumTest=/\d+/
		if(NumTest.test(num)&&num>0)
		{
				var xmlHttp;
		
		var url = "http://172.16.142.98:8080/ZH_2/control?id="+id+"&num="+num+"&action=updatecar";
		if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();
		}
		else
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlHttp.onreadystatechange=function()
		{
			if(xmlHttp.readyState==4&&xmlHttp.status==200)
			{				
				var num=xmlHttp.responseText;
				var text="false"
				if(num==0)
				{
					alert("Sorry,The Store is not enough!Please,Change it again!Thank you!");
					alert(document.getElementById('quantity_change'+id));
					document.getElementById('quantity_change'+id).value=1;
					update(id,1);
				}
				else
				{
					var total_single=num.substring(0,num.indexOf("|"));
					var total_All=num.substring(num.indexOf("|")+1,num.length);

					document.getElementById('total_price'+id).innerHTML=' <td class="total">'+total_single+'</td>'
					document.getElementById("total1").innerHTML='<td class="right">'+total_All+'</td>'
				}
			}
		
		}
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send(null);
		}
		else
		{
			alert("Sorry,Change it again!Thank you!");
			document.getElementById('quantity_change'+id).value=1;
			update(id,1);
		}
	}
	
	
	
	
	function updatetoal()
	{
		var xmlHttp;
		
		var url= "http://172.16.142.98:8080/ZH_2/control?action=first";
		if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();
		}
		else
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.open("POST",url,true);
		xmlHttp.onreadystatechange=function()
		{
		
			if(xmlHttp.readyState==4&&xmlHttp.status==200)
			{
			
				var total=xmlHttp.responseText;
				
				document.getElementById("total1").innerHTML='<td class="right">'+total+'</td>'
			}
		
		}
		xmlHttp.send(null);
		
	}
	//每次先更新
	window.onload=updatetoal();
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
</head>
<body>
<div id="container">


<div id="header">
   <div id="logo"><a href="http://172.16.142.98:8080/ZH_2"><img src="http://172.16.142.98:8080/ZH_2/Imge/Re/251110294145.png" title="Your Store" alt="Store" /></a></div>
        <div id="cart">

  <div class="content">
        <div class="mini-cart-info">
      <table>
                <tr>
          <td class="image">            <a href="http://172.16.142.98/Web/index.php?route=product/product&amp;product_id=47"><img src="http://172.16.142.98/Web/image/cache/data/hp_1-47x47.jpg" alt="HP LP3065" title="HP LP3065" /></a>
            </td>
          <td class="name"><a href="http://172.16.142.98/Web/index.php?route=product/product&amp;product_id=47">HP LP3065</a></td>
          <td class="quantity">x&nbsp;1</td>
          <td class="total">￥100.00</td>
          <td class="remove"><img src="catalog/view/theme/default/image/remove-small.png" alt="移除" title="移除" onclick="(getURLVar('route') == 'checkout/cart' || getURLVar('route') == 'checkout/checkout') ? location = 'index.php?route=checkout/cart&remove=47:YToxOntpOjIyNTtzOjEwOiIyMDExLTA0LTIyIjt9' : $('#cart').load('index.php?route=module/cart&remove=47:YToxOntpOjIyNTtzOjEwOiIyMDExLTA0LTIyIjt9' + ' #cart > *');" /></td>
        </tr>
                      </table>
    </div>
    <div class="mini-cart-total">
      <table>

                <tr>
          <td class="right"><b>订单总额:</b></td>
          <td class="right">￥100.00</td>
        </tr>
              </table>
    </div>
    <div class="checkout"><a href="http://172.16.142.98:8080/ZH_2/showcar.jsp">查看购物车</a> | <a href="http://172.16.142.98/Web/index.php?route=checkout/checkout">结算</a></div>
      </div>
</div>  <div id="search">
    <div class="button-search"></div>
        <input type="text" name="filter_name" value="搜索" onclick="this.value = '';" onkeydown="this.style.color = '#000000';" />
      </div>
  <div id="welcome">
        欢迎光临:${user.user} </div>
  <div class="links"><a href="http://172.16.142.98:8080/ZH_2/">首页

</a><a href="http://172.16.142.98:8080/ZH_2/register.jsp">注册</a><a href="http://172.16.142.98:8080/ZH_2/control?action=showcar">去结账</a>
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

  <c:choose>
  	<c:when test="${sessionScope.car!=null}">
  	<h1>购物车内的商品        &nbsp;</h1>
  	
  	<form action="http://172.16.142.98/Web/index.php?route=checkout/cart" method="post" enctype="multipart/form-data">
  	
  		 <div class="cart-info">
      <table id="shop_table">
        <thead>
          <tr>
            <td class="image">图片</td>
            <td class="name">品名</td>
            <td class="model">型号</td>
            <td class="quantity">数量</td>
            <td class="price">单价</td>
            <td class="total">总计</td>
          </tr>
        </thead>
       
        	<my:MyItem shopCarBean='${car}' id="car">
            <tbody id='${car.getShopBean().getShop_id()}'>
                <tr>
            <td class="image"><a href="http://172.16.142.98:8080/ZH_2/ShopInfo_Control?action=shopinfolist&shopid=${car.getShopBean().getShop_id()}"><img src="http://172.16.142.98:8080/ZH_2/${car.getShopBean().getShop_Image()}" alt="${car.getShopBean().getShop_name()}" title="${car.getShopBean().getShop_name()}" /></a>
              </td>
            <td class="name"><a href="http://172.16.142.98:8080/ZH_2/ShopInfo_Control?action=shopinfolist&shopid=${car.getShopBean().getShop_id()}">${car.getShopBean().getShop_name()}</a>
              </td>
            <td class="model">${car.getShopBean().getShop_id()}</td>

            <td class="quantity"><input type="text" id='quantity_change${car.getShopBean().getShop_id()}' onblur="update(${car.getShopBean().getShop_id()},this.value)" size="1" value='${car.getCount()}'/>
              &nbsp;<a onclick="deleteCar(${car.getShopBean().getShop_id()})">
              <img src="http://172.16.142.98:8080/ZH_2/Imge/Re/error.png" alt="移除" title="移除" /></a></td>
            <td class="price">${car.getShopBean().getShop_price()}</td>
            <td class="total" id='total_price${car.getShopBean().getShop_id()}'>${car.total_price()}</td>
          </tr>
         </tbody>
        </my:MyItem>

      </table>
    </div>
  	</form>
  	    <div class="cart-total">
    <table id="total">
            <tr>
        <td class="right"><b>订单总额:</b></td>
        <td id="total1" class="right"></td>
      </tr>
          </table>
  </div>
  <div class="buttons">
    <div class="right"><a href="http://172.16.142.98:8080/ZH_2/success.jsp" class="button">去结账</a></div>
    <div class="center"><a href= "http://172.16.142.98:8080/ZH_2/success.jsp" class="button">继续购物</a></div>
  </div>
  	</c:when>
  	<c:otherwise>
<div id="content">  <div class="breadcrumb">
        <a href="http://172.16.142.98:8080/ZH_2">首页</a>
         &raquo; <a href="http://172.16.142.98:8080/ZH_2/control?action=showcar">购物车内的商品</a>
      </div>
  <h1>购物车内的商品</h1>
  <div class="content">您的购物车内没有商品！</div>
  <div class="buttons">
    <div class="right"><a href="http://172.16.142.98:8080/ZH_2" class="button">继续</a></div>
  </div>
  </div>
  	</c:otherwise>
  </c:choose>

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
<!--
OpenCart is open source software and you are free to remove the powered by OpenCart if you want, but its generally accepted practise to make a small donation.
Please donate via PayPal to donate@opencart.com
//-->
<div id="powered">技术支持 <a href="http://www.opencart.com">蔡朝臣</a><br /> Your Store &copy; 2013</div>
<!--
OpenCart is open source software and you are free to remove the powered by OpenCart if you want, but its generally accepted practise to make a small donation.
Please donate via PayPal to donate@opencart.com
//-->
</div>
</body></html>