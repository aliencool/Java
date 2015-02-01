<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>about Courtier</title>
<meta name="keywords" content="蔡朝臣-博客" />
<meta name="description" content="蔡朝臣-博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
<link href="css/media.css" rel="stylesheet">

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
   <nav id="topnav"><a href="index.jsp">首页</a><a href="about.jsp">关于我</a><a href="NewlistAction!load">博客列表</a><a href="MessageAction?flag=0&&actionPageBean.currentPage=1">留言版</a></nav></nav>
  </header>
  <article>
    <h3 class="about_h">您现在的位置是：<a href="/">首页</a>><a href="1/">关于我</a></h3>
    <div class="about">
      <h2>Just about me</h2>
      <ul>
        <p>
        Love the Life
        </p>
        <p>  Love the Book</p>
        <p>  Love the Program</p>
        <p>  Love the Basketball</p>
      </ul>
      <h2>About my blog</h2>
      <ul class="blog_a">
        <p>Record my life and technology </p>
        <p>The web temple from <a href="http://www.yangqq.com">Yangqing</a></p>
      </ul>
      <h2>Contact me?</h2>
      <p>Weibo:<a href="http://weibo.com/yeskiller/home?wvr=5&c=spr_web_yilang_maxthon_weibo_p003">Sina</a></p>
      <p>E-mail:aasuperkey@163.com</p>
    </div>
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
  </aside>
  <script src="js/silder.js"></script>
  <div class="clear"></div>
  <!-- 清除浮动 --> 
</div>
</body>
</html>
