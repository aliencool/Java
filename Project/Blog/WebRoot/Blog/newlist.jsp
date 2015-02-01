<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Courtier</title>
<meta name="keywords" content="蔡朝臣-博客" />
<meta name="description" content="蔡朝臣-博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/media.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
   <nav id="topnav"><a href="index.jsp">首页</a><a href="about.jsp">关于我</a><a href="NewlistAction!load">博客列表</a><a href="MessageAction?flag=0&&actionPageBean.currentPage=1">留言版</a></nav></nav>
  </header>
  <article>
    <h2 class="about_h">您现在的位置是：<a href="index.jsp">首页</a>><a href="NewlistAction!load">博客列表</a></h2>
    <div class="bloglist">
    <c:forEach items="${all_blog}" var="blog">
      <div class="newblog">
        <ul>
             <h3><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></h3>
          <div class="autor"><span>作者：蔡朝臣</span><span>分类：[<a href="PageAction?flag=1&categoryName=${blog.c_Name}&actionPage.currentPage=1">${blog.c_Name}</a>]</span></div>
          <p>${fn:substring(blog.content,0,135)}... <a href="NewlistAction.action?${blog.log_Id}&flag=0" target="_blank" class="readmore">全文</a></p>
        </ul>
        <figure><img src="images/001.jpg" ></figure>
        <div class="dateview">${blog.time}</div>
      </div>
      </c:forEach>

    </div>
    <div class="page"><a title="Total page"><b>${count}</b></a>
     <c:forEach  begin="1" end="${count}" var="page">
    <a href="PageAction?flag=0&actionPage.currentPage=${page}">${page}</a>
 	</c:forEach>
 	</div>
  </article>
  <aside>
    <div class="rnav">
   
        <c:forEach items="${category}" var="blog" begin="0" end="3" varStatus="status">
      <li class="rnav${status.count}"><a href="PageAction?flag=1&categoryName=${blog.c_Name}&actionPage.currentPage=1">${blog.c_Name}</a></li>
      </c:forEach>
    </div>
    <div class="ph_news">
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
