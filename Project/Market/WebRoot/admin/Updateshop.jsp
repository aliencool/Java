<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<title>Simpla Admin</title>
		
		<!--                       CSS                       -->
	  
		<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/r.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/sty.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/invalid.css" type="text/css" media="screen" />	
		
		<!-- Colour Schemes
	  
		Default colour scheme is green. Uncomment prefered stylesheet to use it.
		
		<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/blue.css" type="text/css" media="screen" />
		
		<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/red.css" type="text/css" media="screen" />  
	 
		-->
		
		<!-- Internet Explorer Fixes Stylesheet -->
		
		<!--[if lte IE 7]>
			<link rel="stylesheet" href="http://172.16.142.98:8080/ZH_2/admin/resources/css/ie.css" type="text/css" media="screen" />
		<![endif]-->
		
		<!--                       Javascripts                       -->
  
		<!-- jQuery -->
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/jquery-1.3.2.min.js"></script>
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/jquery.datePicker.js"></script>
		<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/jquery.date.js"></script>
		<!--[if IE]><script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/jquery.bgiframe.js"></script><![endif]-->

		
		<!-- Internet Explorer .png-fix -->
		
		<!--[if IE 6]>
			<script type="text/javascript" src="http://172.16.142.98:8080/ZH_2/admin/resources/scripts/DD_belatedPNG_0.0.7a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png_bg, img, li');
			</script>
		<![endif]-->
		
	</head>
  
	<body>
		
		
		
	<div id="main-content"> <!-- Main Content Section with everything -->
			
			<noscript> <!-- Show a notification if the user has disabled javascript -->
			</noscript>
			
			<!-- Page Head -->
			<h2>商品修改信息</h2>
			
			<ul class="shortcut-buttons-set">
			  <li></li></ul><!-- End .shortcut-buttons-set -->
			
	  <div class="clear"></div> <!-- End .clear -->
			
	  <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>商品修改</h3>	
					<div class="clear"></div>
					
		</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
					<div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->

					  <table width="102%">
							
						  <thead>
								<tr>
								   <th width="6%"><input class="check-all" type="checkbox" /></th>
							      <th width="18%"><div align="center">商品名称</div></th>
								   <th width="13%"><div align="center">商品价格</div></th>
								   <th width="21%"><div align="center">商品数量</div></th>
							      <th width="17%"><div align="center">商品总类</div></th>
                                   <th width="17%"><div align="center">商品子类</div></th>
                                   
							      <th width="6%"><div align="center">&#32534;&#36753;</div></th>
								</tr>
								
						</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
										<div class="bulk-actions align-left"><a class="button" href="#">增加</a>
										
										</div>
									   &nbsp;&nbsp;
										<div class="bulk-actions align-left"><a class="button" href="#">删除</a>
										
										</div>
										<div class="pagination">
										<a href="http://172.16.142.98:8080/ZH_2/control_admin?action=shopadminlist&page=1" title="First Page">&laquo; First</a>
											<c:forEach var="count"  begin="1" end="${count}">
											<a href="http://172.16.142.98:8080/ZH_2/control_admin?action=shopadminlist&page=${count}" class="number" title="${count}">${count}</a>
											</c:forEach>
									<a href="http://172.16.142.98:8080/ZH_2/control_admin?action=shopadminlist&page=${count}" title="Last Page">Last &raquo;</a>
										</div> <!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
						 
							<tbody>
								
									
									<c:forEach var="adminshoplist" items="${adminshoplist}" >
										<tr>
									<td><input type="checkbox" /></td>
									<td><div align="center">${adminshoplist.shop_name}</div></td>
									<td><div align="center">${adminshoplist.shop_price}</div></td>
									<td><div align="center">${adminshoplist.shop_amount}</div></td>
									<td><div align="center">${adminshoplist.shop_category}</div></td>
									<td><div align="center">${adminshoplist.shop_soncategory}</div></td>
									<td>
										<div align="center">
										  <!-- Icons -->
								    <a href="http://172.16.142.98:8080/ZH_2/control_admin?action=shopadminlist&id=${adminshoplist.shop_id}" title="Edit"><img src="http://172.16.142.98:8080/ZH_2/admin/resources/images/icons/pencil.png" alt="Edit" /></a></div></td>
								  	</tr>
									</c:forEach>
									
							
							</tbody>
							
					  </table>
						
					</div> 
					<!-- End #tab1 -->
				</div> <!-- End .content-box-content -->
				
	  </div> <!-- End .content-box --><!-- End .content-box --><!-- End .content-box -->
	  <div class="clear"></div>
		
	</div>
		</body>
  

<!-- Download From www.exet.tk-->
</html>
