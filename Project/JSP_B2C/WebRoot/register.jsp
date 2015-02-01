<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="zh-CN" xml:lang="zh-CN">
<head>
<title>用户注册</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<base href="http://172.16.142.98/Web/" />
<link href="http://172.16.142.98/Web/image/data/cart.png" rel="icon" />
<link rel="stylesheet" type="text/css" 
href="http://172.16.142.98:8080/ZH_2/css/stylesheet.css" />
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
<script type="text/javascript" >
	
	var select=0;
	var count=0;
	
	function getKeyCode(e)
	{
		var keycode;
		//为了兼容IE浏览器
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









	//检测用户名
	var user_check=false;
	var password_check=false;
	var city_check=false;
	var telephone_check=false;
	var Email_check=false;
	var country_check=false
	var city_check_2=false;
	
	function check()
	{
		
		if(!(document.getElementById("agree").checked))
		{
			alert('错误,没有同意隐私');
			return false;
		}
	 	 if(!(user_check))
		{		
				document.getElementById("firstname").focus();
				return false;
		}
		if(!password_check)
		{
				document.getElementById("password").focus();
				return false;
		}
		if(!Email_check)
		{
		
			document.getElementById("email").focus();
				return false;
		}
		if(!telephone_check)
		{
		
			document.getElementById("telephone").focus();
			return false;
		}
		if(!city_check)
		{
				document.getElementById("city").focus();
				return false;
		
		}
		if(!city_check_2)
		{
				document.getElementById("address_1").focus();
				return false;
		}
		if(!country_check)
		{
				alert("请选择，国家");
				return false;
		
		}
		
		if(country_check&&city_check_2&&city_check&&telephone_check&&Email_check&&user_check&&document.getElementById("agree").checked)
		{alert(country_check&&city_check_2&&city_check&&telephone_check&&Email_check&&user_check&&document.getElementById("agree").checked);
			return true;
			
		}
		return false;
	}
	function check_user_name(user)
	{
		var xmlHttp;
		if(window.XMLHttpRequest)
		{
			xmlHttp=new XMLHttpRequest();

		}
		else
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		var url="http://172.16.142.98:8080/ZH_2/control?action=check_user&user_name="+document.myform.firstname.value;
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.onreadystatechange=function()
		{	
			if(xmlHttp.readyState==4&&xmlHttp.status==200)
			{
				var Cheack=xmlHttp.responseText;
				success_failed(Cheack);
			}
		}
		xmlHttp.send(null);
	}	
	function success_failed(Cheack)
	{	
		if(Cheack==0)
		{
			
			document.getElementById("user").innerHTML="<img src='http://localhost:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>这个用户名已经存在，请更换</div>";
		}
		else if(Cheack==1)
		{
			
			 document.getElementById("user").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>";
			user_check=true;
		}
	}
	
	function cheack_user()
	{
		var user=document.myform.firstname.value;
		var user_cheack=/\w{4,}/;
		if((!user_cheack.test(user))||!(user!=""))
		{	
			
			document.getElementById("user").innerHTML="<img src='http://localhost:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>必须是数字加字母不小于4</div>"
		}
		else
		{
			document.getElementById("user").innerHTML='<div class="attention"><img src="catalog/view/theme/default/image/loading.gif" alt="" />正在检测用户名</div>';

			setTimeout(check_user_name,600);
		}
		 
		 
	}
	function cheack_password()
	{
		var password_cheack=/\w{5,}/;
		var cheackpwd=document.myform.password.value;
		if((!password_cheack.test(cheackpwd))||!(cheackpwd!=""))
		{
			
				
			document.getElementById("answerJS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>必须是数字加字母不小于5</div>"
		}
		else
		{	
			
			 document.getElementById("answerJS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>";
			 
		}
	}
	
	function cheack_password1()
	{
		var cheackpwd=document.myform.password;
		var cheackpwd1=document.myform.confirm;
			if((cheackpwd.value!=cheackpwd1.value)||cheackpwd1.value=="")
			{	
					
				document.getElementById("answerJS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>密码不一致</div>"
				document.getElementById("answer1JS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>密码不一致</div>"
			}
			else
			{
				password_check=true;
				document.getElementById("answerJS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>"
				document.getElementById("answer1JS").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>"
				
			}
	}
	function cheack_email()
	{
		var email=document.myform.email.value;
		var emil_cheack=/\w+([_+.]\w)*@\w+([-.]\w+)*\.\w+/;
		if((!emil_cheack.test(email))||!(email!=""))
		{
				
			document.getElementById("Email1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>邮箱格式错误</div>"
		}
		else
		{	
			Email_check=true;
			 document.getElementById("Email1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>";
			 
		}
	
	}
	function cheack_telephone()
	{
		var phone_cheack=/\d{3}-\d{5,}/;
		var telephone=document.myform.telephone.value;
		if((!phone_cheack.test(telephone))||!(telephone!=""))
		{
		
			document.getElementById("Telephone1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'></img>"+"<div id='d' style='background-color:red;border-color:red;font-size:10'>样式020-88888888</div>"
		}
		else
		{
			telephone_check=true;
			 document.getElementById("Telephone1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>";
			 
		}
	
	}
	function cheack_city()
	{
		var city=document.myform.city;
		if(city.value!="")
			{	
			
				document.getElementById("City1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>"
				city_check=true;
			}
			else
			{
					
				document.getElementById("City1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'>您没有填城市</img>"
				
			}
	
	}
	function cheack_address()
	{
			var address_1=document.myform.address_1;
			if(address_1.value!="")
			{
				
				document.getElementById("Adress1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>"
				city_check_2=true;
			}
			else
			{	
				
				document.getElementById("Adress1").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'>您没有填地址</img>"
			}
	
	}
	function cheack_select()
	{
			var select=document.myform.country_id;
			if(select.selectedIndex!=0)
			{
				
				document.getElementById("select").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/ok.jpg'></img>"
				country_check=true;
				
			}
			else
			{
				
				document.getElementById("select").innerHTML="<img src='http://172.16.142.98:8080/ZH_2/Imge/Re/error.png'>您没有选择城市</img>"
				
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
<form action="" ></form>
<div id="container">
<div id="notification"></div>
   <div id="header"><div id="logo"><a href="http://172.16.142.98:8080/ZH_2"><img src="http://172.16.142.98:8080/ZH_2/Imge/Re/251110294145.png" title="Your Store" alt="Store" /></a></div>
     <div id="search">
    <div class="button-search"></div>
        <input type="text" id="filter_name" value="搜索" onkeyup="getSuggest(this.value,event);upanddown(event)" 

onkeydown="this.style.color = '#000000';" />

		<div id="blank0"></div>
		<div id="dSuggest" ></div>
      </div>
   
    <div id="welcome">
        欢迎您注册<b>
   <a ></a>
    ${user.time_Start}
    </b>
    
   </div>
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

  <h3>用户注册</h3>
  <p>欢迎来到我们网站，如果您是新用户，请填写下面的表单进行注册。如果您已经是本站的会员，请您直接<a href="http://172.16.142.98:8080/ZH_2/index.jsp?route=account/login">登录</a>。</p>
  <form name="myform"  action="http://172.16.142.98:8080/ZH_2/control" onsubmit="return check();" method="post">
  
    <h2>您的个人资料</h2>
    <div class="content">
      <table class="form">      
        <tr>
          <td><span class="required">*</span> 您的用户：</td>
          <td><input type="text" id="firstname" value="" onblur="cheack_user()" />
            </td>
           <td><div id="user"></div></td> 
        </tr>
        <tr>
          <td><span class="required">*</span> 电子邮箱：</td>
          <td><input type="text" id="email" value="" onblur="cheack_email()"  />
            </td>
            <td><div id="Email1"></div></td> 
        </tr>
        <tr>
          <td><span class="required">*</span> 联系电话：</td>
          <td><input type="text" id="telephone" value="" onblur="cheack_telephone()" />
            </td>
             <td><div id="Telephone1"></div></td> 
        </tr>
      </table>
    </div>
    <h2>您的详细地址</h2>
    <div class="content">
      <table class="form">
        <tr>
          <td><span class="required">*</span> 地址 ：</td>
          <td><input type="text" id="address_1" value=""  onblur="cheack_address()" />
            </td>
            <td><div id="Adress1"></div></td> 
        </tr>
        <tr>
          <td><span class="required">*</span> 所在城市：</td>
          <td><input type="text" id="city" value="" onblur="cheack_city()" />
            </td>
                     <td><div id="City1"></div></td> 
        </tr>
        <tr>
          <td><span class="required">*</span> 所在国家：</td>
          <td><select id="country_id" onblur="cheack_select()">
              <option value="" selected="selected"> --- 请选择 --- </option>
                              <option value="china">中国 </option>
                                        </select>
            </td>
            <td><div id="select"></div></td>
            
        </tr>
      </table>
    </div>
    <h2>您的账户密码</h2>
    <div class="content">
      <table class="form">
        <tr>
          <td><span class="required">*</span> 输入密码：</td>
          <td><input type="password" id="password" value="" onblur="cheack_password()"/> </td>
           <td><div id="answerJS"></div></td> 
        </tr>
        <tr>
          <td><span class="required">*</span> 确认密码：</td>
          <td><input type="password" id="confirm" value="" onblur="cheack_password1()"/>   </td> 
            <td>  
                        <div id="answer1JS"></div>  
                    </td> 
        </tr>
      </table>
    </div>
    
        <div class="buttons">
      <div class="right">我已经阅读并同意 <a class="colorbox" href="http://172.16.142.98/Web/index.php?route=information/information/info&amp;information_id=3" alt="隐私权声明"><b>隐私权声明</b></a>条款                <input type="checkbox" id="agree" value="1" />
                <input type="submit" value="继续" class="button" />
                <input type="hidden" value="register" name="action"/>
      </div>
    </div>
      </form>
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
<div id="powered">技术支持 <a href="#we">蔡朝臣</a><br /> Your Web &copy; 2013</div>
</div>
</body></html>