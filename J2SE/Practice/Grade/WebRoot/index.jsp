<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="icon" href="/Grade/images/favicon.gif" type="image/x-icon"/>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="毕业设计">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="/Grade/images/favicon.gif" type="image/x-icon"/> 
	<link rel="stylesheet" type="/Grade/text/css" href="css/styles.css"/>
	<link type="text/css" href="/Grade/css/css3.css" rel="stylesheet" />
	<script type="text/javascript" src=" http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.js"></script>
	<script type="text/javascript" src="/Grade/js/jquery.pikachoose.js"></script>
	<script language="javascript">
			$(document).ready(
				function (){
					$("#pikame").PikaChoose();
				});
		</script>
  </head>

  <body>
   	 <!--start container-->
    <div id="container">

    <!--start header-->

    <header>
 
    <!--start logo-->
    <a href="#" id="logo"><img src="/Grade/images/logo.png" width="221" height="100" alt="logo"/></a>    

	<!--end logo-->
	
   <!--start menu-->

	<nav>
    <ul>
    <li><a href="#">Home</a>

	</li>
	<li><a href="#">帮助</a></li>
    </ul>
    </nav>
	<!--end menu-->
	

    <!--end header-->
	</header>


   <!--start intro-->

   <div id="intro">
   
   <div class="group_bannner_right">
  <a href="/Grade/choice.jsp"><img src="images/picture.png" width="550" height="316"  alt="baner"></a>
   </div>
   
   <header class="group_bannner_left">
   <hgroup>
   <h1>佘学聪.Gp. </h1>
   <h2>“The most important.“ 
   </h2>
   </hgroup>
   </header>
   </div>
   <!--end intro-->

   
   
   <!--start holder-->

   <div class="holder_content">
   
   <section class="group1">
   <h3>Help</h3>
   	<p>请点击上面的excel图标来导入数据</p>

	</section>
	

     
   <section class="group2">
   <h3>Warning</h3>
   	<p>请认真选择您的数据，确保符合格式</p>
	

	</section>


       
   <section class="group3">
   <h3>Contact</h3>
   	<p>610839908-shexuecong@qq.com-</p>
	

	</section>

  
   </div>
   <!--end holder-->
 
    </div>
   <!--end container-->
   
   
   <!--start footer-->
   <footer>
   <div class="container">  
   <div id="FooterTwo"> © 2014 Graduation project </div>
   </div>
   </footer>
   
  </body>
</html>
