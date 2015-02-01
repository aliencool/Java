<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- Html开始 -->
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Courtier-Blog</title>
<meta name="keywords" content="蔡朝臣-博客" />
<meta name="description" content="蔡朝臣-博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
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
    <div class="banner">
      <ul class="texts">
        <p><font color="#FFFFFF">Stay foolish stay hungery</font></p>
        <p><font color="#FFFFFF">Can you with me change the world?</font></p>
      </ul>
    </div>
    <div class="bloglist">
      <h2>
        <p><span>推荐</span>文章</p>
      </h2>
      <c:forEach items="${recommend}" var="blog">
      <div class="blogs">
        <h3><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></h3>
        <figure><img src="images/01.jpg" /></figure>
        <ul>
          <p>${fn:substring(blog.content,0,135)}...</p>
          <a href="NewlistAction.action?${blog.log_Id}&flag=0" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
        </ul>
        <p class="autor"><span>作者：蔡朝臣</span><span>分类：【<a href="PageAction?flag=1&categoryName=${blog.c_Name}&actionPage.currentPage=1">${blog.c_Name}</a>】</span></p>
        <div class="dateview">${blog.time}</div>
      </div>
      </c:forEach>
  </article>
  <aside>
    <div class="avatar"><a href="about.jsp"><span>关于我</span></a></div>
    <div class="topspaceinfo">
      <h1>Welcome to My Blog</h1>
      <p>change the world</p>
    </div>
    <div class="about_c">
      <p>姓名：蔡朝臣</p>
      <p>职业：Programmer</p>
      <p>热爱：篮球,书</p>
      <p>邮箱：aasuperkey@163.com</p>
    </div>
  <!-- Baidu Button BEGIN -->
<div class="bdsharebuttonbox"><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{},"image":{"viewList":["tsina","weixin","tqq","qzone","renren"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["tsina","weixin","tqq","qzone","renren"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<!-- Baidu Button END -->
    <div class="tj_news">
      <h2>
        <p class="tj_t1">最新文章</p>
      </h2>
      <ul>
      <c:forEach items="${new_blog}" var="blog">
        <li><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></li>
      </c:forEach>
      </ul>
      <h2>
        <p class="tj_t2">推荐文章</p>
      </h2>
      <ul>
          <c:forEach items="${recommend}" var="blog">
        <li><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></li>
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
