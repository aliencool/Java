package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BindBean.StuBean;
import com.myjdbc.Myjdbc;

public class Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		PrintWriter  out=resp.getWriter();//������Ӧ��
		Myjdbc myjdbc=new Myjdbc();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Test</TITLE><HEAD>");
		out.println("<BODY bgcolor=\"# ffffff\">");
		out.println("<h3>���Զ���󶨻Ự����");
		out.println("<form method='post' action='UpdateDb'>");
		out.println("<���ݿ���Ϣ>");
		out.println("<select name='select' size=10>");
		try {
			
			Vector<StuBean> vector=myjdbc.select();
			
			for (int i = 0; i < vector.size(); i++) {
				out.println("<option value="+vector.get(i).getSno()+">");//�õ���һ�������id
				out.println(((StuBean)vector.get(i))._toString());
				out.println("</option>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</select>");
		out.println("<hr>");
		out.println("<input type=submit value='ѡ��'>");
        out.println("</form>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
