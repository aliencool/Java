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
<nav id="topnav"><a href="index.jsp">首页</a><a href="about.jsp">关于我</a><a href="NewlistAction!load">博客列表</a><a href="index.jsp">留言版</a></nav></nav>
  </header>
  <article>
    <h2 class="about_h">您现在的位置是：<a href="/">首页</a>><a href="1/">博客</a>><a href="1/">博客信息</a></h2>
    <div class="index_about">
      <h2 class="c_titile">黑色Html5个人博客模板主题《如影随形》</h2>
      <p class="box_c"><span class="d_time">发布时间：2014-04-17</span><span>编辑：杨青</span></p>
      <ul class="infos">
        <p>2014第二版黑色Html5个人博客模板主题《如影随形》，如精灵般的影子会给人一种神秘的感觉。一张剪影图黑白搭配，如果整个网站用黑白灰三色，会显得比较太过沉重，于是，在选择亮色方面，用以红为主色，蓝为辅色。这样就铺上了一些神秘甚至有些俏皮的元素。</p>
        <p>如果你更喜欢用蓝色或者绿色，这也不错，替换关键的颜色值就行了，推荐颜色值：<img src="images/color.jpg" alt="黑色Html5个人博客模板"></p>
        <p>Html5响应式两栏布局，LOGO重点突出，首页推荐文章列表以Logo中轴线为时间轴，鼠标Hover触发时间轴左侧栏显示文章发布时间，文字banner动画均以css3代码来实现效果。</p>
        <p><b>首页效果图：</b></p>
        <p><img src="images/xgt.jpg" alt="黑色Html5个人博客模板"></p>
        <p><b>移动设备和平板电脑浏览效果：</b></p>
        <p><img src="images/ltpic.jpg" alt="黑色Html5个人博客模板"></p>
        <p><img src="images/col.jpg" alt="黑色Html5个人博客模板"></p>
      </ul>
      <div class="keybq">
        <p><span>关键字词</span>：黑色,个人博客,时间轴,响应式</p>
      </div>
      <div class="nextinfo">
        <p>上一篇：<a href="/news/s/2013-09-04/606.jsp">程序员应该如何高效的工作学习</a></p>
        <p>下一篇：<a href="/news/s/2013-10-21/616.jsp">柴米油盐的生活才是真实</a></p>
      </div>
      <div class="otherlink">
        <h2>相关文章</h2>
        <ul>
          <li><a href="/news/s/2013-07-25/524.jsp" title="现在，我相信爱情！">现在，我相信爱情！</a></li>
          <li><a href="/newstalk/mood/2013-07-24/518.jsp" title="我希望我的爱情是这样的">我希望我的爱情是这样的</a></li>
          <li><a href="/newstalk/mood/2013-07-02/335.jsp" title="有种情谊，不是爱情，也算不得友情">有种情谊，不是爱情，也算不得友情</a></li>
          <li><a href="/newstalk/mood/2013-07-01/329.jsp" title="世上最美好的爱情">世上最美好的爱情</a></li>
          <li><a href="/news/read/2013-06-11/213.jsp" title="爱情没有永远，地老天荒也走不完">爱情没有永远，地老天荒也走不完</a></li>
          <li><a href="/news/s/2013-06-06/24.jsp" title="爱情的背叛者">爱情的背叛者</a></li>
        </ul>
      </div>
    </div>
  </article>
  <aside>
    <div class="rnav">
    <li class="rnav1 "><a href="/">生活</a></li>
      <li class="rnav2 "><a href="/">程序</a></li>
      <li class="rnav3 "><a href="/">随笔</a></li>
      <li class="rnav4 "><a href="/">其他</a></li>
    </div>
    <div class="ph_news">
     <h2>
        <p>点击排行</p>
      </h2>
      <ul class="ph_n">
       <c:forEach items="${click_blog}" var="blog" begin="0" end="3" varStatus="status">
        <li><span class="num${status.count+1}">${status.count+1}</span><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></li>
       </c:forEach>
   		 <c:forEach items="${click_blog}" var="blog" begin="3" end="8" varStatus="status">
        <li><span>${status.count+1}</span><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></li>
         </c:forEach>
      </ul>
      <h2>
        <p>推荐文章</p>
      </h2>
      <ul>
        <c:forEach items="${recommend}" var="blog">
        <li><a href="NewlistAction.action?${blog.log_Id}&flag=0">${blog.title}</a></li>
      </c:forEach>
      </ul>
      <h2>
      <h2>
        <p>最新评论</p>
      </h2>
      <ul class="pl_n">
        <dl>
          <dt><img src="images/s8.jpg"> </dt>
          <dt> </dt>
          <dd>DanceSmile
            <time>49分钟前</time>
          </dd>
          <dd><a href="/">文章非常详细，我很喜欢.前端的工程师很少，我记得几年前yahoo花高薪招聘前端也招不到</a></dd>
        </dl>
        <dl>
          <dt><img src="images/s7.jpg"> </dt>
          <dt> </dt>
          <dd>yisa
            <time>2小时前</time>
          </dd>
          <dd><a href="/">我手机里面也有这样一个号码存在</a></dd>
        </dl>
        <dl>
          <dt><img src="images/s6.jpg"> </dt>
          <dt> </dt>
          <dd>小林博客
            <time>8月7日</time>
          </dd>
          <dd><a href="/">博客色彩丰富，很是好看</a></dd>
        </dl>
        <dl>
          <dt><img src="images/003.jpg"> </dt>
          <dt> </dt>
          <dd>DanceSmile
            <time>49分钟前</time>
          </dd>
          <dd><a href="/">文章非常详细，我很喜欢.前端的工程师很少，我记得几年前yahoo花高薪招聘前端也招不到</a></dd>
        </dl>
        <dl>
          <dt><img src="images/002.jpg"> </dt>
          <dt> </dt>
          <dd>yisa
            <time>2小时前</time>
          </dd>
          <dd><a href="/">我手机里面也有这样一个号码存在</a></dd>
        </dl>
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
