<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>MessageBox</title>
<meta name="keywords" content="蔡朝臣-博客" />
<meta name="description" content="蔡朝臣-博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
<link href="css/media.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="js/jquery-1.8.3.js" type="application/javascript"></script>
<script>
	var wordLength=80;
	var flag=true;
	
		function check_Length(){
			
		if($("#textarea").val().length>=wordLength)
		{
			$("#textarea").val($("#textarea").val().substr(0,80));
			
		}else
		{
			   
				$("#remLen").html(wordLength-$("#textarea").val().length-1);
		}
		
		
		};
		
		
		function click_add()
		{
	
		if(flag)
		{
			alert('您已经提交留言,请刷新页面查看');
		
		$("#showlist").prepend('<dl><dt><img src="${user.u_Pic}"> </dt><dt> </dt><dd>"${user.u_Name}"<time>49分钟前</time></dd><dd>'+$("#textarea").val()+'</dd></dl>');
			
		$("#button_click").attr("disabled", true);
			
			
			
			
			var date={    
			    "flag":1,    
			    "messageBox.u_Id.u_Id":'${user.u_Id}',    
			    "messageBox.reply_Content":$("#textarea").val()
			};		
						
						
			
			$.post("MessageAction",date);
		
			$("#textarea").val("");
	
	
			flag=false;

		}else {alert('作为一名服务器，您老点提交压力很大的!!');}
		
		}

</script>
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<div class="ibody">
  <header>
    <h1>Courtier</h1>
    <h2>大梦谁先觉，平生我自知</h2>
    <div class="logo"><a href="/"></a></div>
   <nav id="topnav"><a href="index.jsp">首页</a><a href="about.jsp">关于我</a><a href="NewlistAction!load">博客列表</a><a href="MessageAction?flag=0&&actionPageBean.currentPage=1">留言版</a>
   <a href="RedirectAction?id=${user.u_Id}">${user.u_Name}</a>
   </nav>
  
  </header>
  <article>
    <h2 class="about_h">您现在的位置是：<a href="/">首页</a>><a href="1/">留言版</a></h2>
    <div class="template">
         <h3>
        <p><span>管理员</span>通告</p>
      </h3>
       <ul  class="pl_n">
        <dl>
          <dt><img src="images/s8.jpg"> </dt>
          <dt> </dt>
          <dd>Adminstreator
          </dd>
          <dd><font color="#000000" size="1">欢迎来到我的博客，您的支持是我们的荣幸!</font></dd>
        </dl>
      <h3>
        <p><span>会员</span>留言表</p>
        </h3>
      <ul id="showlist" class="pl_n">
      <c:forEach items="${messagebox}" var="messagelist">
        <dl>
          <dt><a href="RedirectAction?id=${messagelist.u_Id}"><img src="${messagelist.u_Pic}"/> </a></dt>
          <dt> </dt>
          <dd>${messagelist.u_Name}
            <time>${messagelist.reply_Time}小时前</time>
          </dd>
          <dd style="cursor:pointer">${messagelist.reply_Content}</dd>
        </dl>
        </c:forEach>
        </dl>
      </ul>
         <div class="page">
         <a title="Total record"><b>${count}</b></a> <c:forEach  begin="1" end="${count}" var="page">
    <a href="PageAction?flag=2&actionPage.currentPage=${page}">${page}</a>
 	</c:forEach></div>
        
      </ul>
      <h3>
        <p>留言<span>输入区</span></p>
       </h3>
     <ul class="pl_n">
        <dl>
          <dt><img src="${user.u_Pic}"> </dt>
          <dt> </dt>
          <dd>name:<font align="right" color="#066" ><b>${user.u_Name}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>count:<font align="right" color="#066" ><b id="remLen">80</b>/80</font>
          </dd>
          
          <dd>
          
        

          <textarea  onKeyDown="check_Length();" id="textarea" cols="60" rows="3"></textarea>
          
          </dd>
          <dd></a>
          
<a onClick="click_add();" class="button   green">commit in <span>One minute</span></a>

        </dl>
       </ul>
     
    </div>
  </article>
  <aside>
   <div class="avatar"><a href="about.html"><span>关于我</span></a></div>
    <div class="ph_news">
      <h2>
     <h2>
        <p>点击排行</p>
      </h2>
      <ul class="ph_n">
       <c:forEach items="${click_blog}" var="blog" begin="0" end="3" varStatus="status">
        <li><span class="num${status.count}">${status.count}</span><a href="NewlistAction.action?${blog.log_Id}&flag=0">${fn:substring(blog.content,0,15)}...</a></li>
       </c:forEach>
   		 <c:forEach items="${click_blog}" var="blog" begin="3" end="8" varStatus="status">
        <li><span>${status.count+3}</span><a href="NewlistAction.action?${blog.log_Id}&flag=0">${fn:substring(blog.content,0,15)}...</a></li>
         </c:forEach>
      </ul>
      <h2>
        <p>推荐文章</p>
      </h2>
      <ul>
        <c:forEach items="${recommend}" var="blog">
        <li><a href="NewlistAction.action?${blog.log_Id}&flag=0">${fn:substring(blog.content,0,15)}...</a></li>
      </c:forEach>
      </ul>
      <h2>
        <p>最新评论</p>
      </h2>
         <ul id="showlist" class="pl_n">
      <c:forEach items="${newcomment}" var="newcom">
        <dl>
          <dt><a href="RedirectAction?id=${newcom.u_Id}&&flag=1"><img src="${newcom.u_Pic}"/> </a></dt>
          <dt> </dt>
          <dd>${newcom.u_Name}
            <time>${newcom.reply_Time}小时前</time>
          </dd>
          <dd style="cursor:pointer">${fn:substring(newcom.reply_Content,0,14)}......</dd>
        </dl>
        </c:forEach>
      </ul>
    </div>
    <div class="copyright">
      <ul>
        <p> Design by <a href="/">DanceSmile</a></p>
        <p>蜀ICP备11002373号-1</p>
        </p>
      </ul>
    </div>
  </aside>
  <script src="js/silder.js"></script>
  <div class="clear"></div>
  <!-- 清除浮动 --> 
</div>
</body>
</html>

