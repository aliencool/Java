<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>

<%@page import="java.awt.Color"%>

<html>
	<head>
		<title>����������԰�</title>
	</head>
	<body>
	<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>

<%@page import="java.awt.Color"%>

<html>
	<head>
	
		<title>����������԰�</title>
		<link rel="stylesheet" type="text/css" href="css/style2.css" media="screen, projection"/>
	</head>
	<body>
	<div id="header1">
	<div id="header2">
		<div id="menu">
			<ul>
				<li><a href="index.html">��ҳ</a></li>
				<li><a href="say.html">��Ҫ����</a></li>
				<li><a href="lookChart.html">�鿴ͼ��</a></li>
                <li><div id="font1">��XX�˷���</div></li>
                <li><a href="xxx" target="_blank">About us</a></li>
			</ul>
		</div>
     </div>
</div>
<div id="page">
	<div id="page-bgtop">
		<div id="content">
			<div class="post">
				<div class="entry">
               	<%
			Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/first?zeroDateTimeBehavior=convertToNull","root","123");
            
            //�����ɹ����Ľ������
			Statement stmt=conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery("select * from guestbook order by gst_time desc");
			
			//�ƶ��α굽����������һ�С�
			rs.last();
			
			//�õ���ǰ�е�������Ҳ�͵õ������ݿ������Ե�������
			int rowCount=rs.getRow();
			if(rowCount==0)
			{
				out.println("��ǰû���κ�����!");
				out.flush();
				return;
			}
			else
		    {
	    %>
	             ����<strong><%=rowCount%></strong>������&nbsp;&nbsp;&nbsp;&nbsp;
	    <%        
	        }
			
			String strCurPage=request.getParameter("page");
			
			//��ʾ��ǰ��ҳ����
			int curPage;
			
			if(strCurPage==null)
				curPage=1;
			else
				curPage=Integer.parseInt(strCurPage);
			
			//����ÿҳ��ʾ����������
			int countPerPage=5;
			
			//��������������ʾ��Ҫ����ҳ����
			int pageCount=(rowCount+countPerPage-1)/countPerPage;
			
			//�ƶ��α굽�������ָ�����С������ʾ���ǵ�һҳ��curPage=1��
			//�α��ƶ�����1�С�
			rs.absolute((curPage-1)*countPerPage+1);
			
		    //����ǵ�1ҳ������ʾ�������ӵ����֣�������ǵ�1ҳ��
		    //����û��ṩ��ת����һҳ����һҳ�����ӡ�
			if(curPage==1)
			{	
		%>
		        ��һҳ&nbsp;&nbsp;&nbsp;&nbsp;
		        ��һҳ&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			}
			else
			{
		%>
		        <a href="index.jsp?page=<%=1%>">��һҳ</a>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="index.jsp?page=<%=curPage-1%>">��һҳ</a>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		<%
			}
			//�����ǰҳ�����һҳ������ʾ�������ӵ����֣�����������һҳ��
			//����û��ṩ��ת�����һҳ����һҳ�����ӡ�
			if(curPage==pageCount)
			{
			
		%>
		        ��һҳ&nbsp;&nbsp;&nbsp;&nbsp;
		        ���ҳ&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			}
			else
			{
		%>
		        <a href="index.jsp?page=<%=curPage+1%>">��һҳ</a>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="index.jsp?page=<%=pageCount%>">���ҳ</a>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		<%
			}
	   
			int i=0;
			//��ѭ���ķ�ʽȡ��ÿҳҪ��ʾ�����ݣ���Ϊ��ǰ�����Ҫ��ʾ��ҳ����
			//������rs.absolute((curPage-1)*countPerPage+1);
			//�����Ǵ��α����ڵ�λ��ȡ����ǰҳҪ��ʾ�����ݡ�
			while(i<countPerPage && !rs.isAfterLast())
			{
				out.println("<hr color=\"blue\" size=\"2\"><br>");
				out.println("�û�����"+rs.getString("gst_user"));
				out.println("&nbsp;&nbsp;");
				
				Timestamp ts=rs.getTimestamp("gst_time");
				long lms=ts.getTime();
				Date date=new Date(lms);
				Time time=new Time(lms);
			
				
				
				
				out.println("����ʱ�䣺"+date+" "+time);
				
				out.println("&nbsp;&nbsp;");
				out.println("�û�IP��"+rs.getString("gst_ip")+"<br>");
				out.println("���⣺"+rs.getString("gst_title")+"<br>");
				out.println("���ݣ�"+rs.getString("gst_content"));
				i++;
				rs.next();	
			}
			rs.close();
			stmt.close();
			conn.close();
		%>

                </div>
			</div>
			</div>
</body>
</html><%out.flush();%>