package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BindBean.StuBean;

public class UpdateDB extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		PrintWriter  out=resp.getWriter();//������Ӧ��
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Test</TITLE><HEAD>");
		out.println("<BODY bgcolor=\"# ffffff\">");
		out.println("<h3>�޸�ѡ���¼");
		System.out.println(Integer.parseInt(req.getParameter("select")));
		StuBean stu=new StuBean(Integer.parseInt(req.getParameter("select")));
		HttpSession session=req.getSession();
		session.setAttribute("stu", stu);
		out.println("<form method='post' action='UpdateMath'>");
		out.println("ѧ��"+stu.getSno()+"����"+stu.getSname()+"����"+stu.getChinese()+"<br>");
		out.println("��ѧ");
		out.println("<input type='text' name='math' value="+stu.getMath()+">");
		out.println("<input type=submit value='�޸���ѧ�ɼ�'>");
		out.println("</form>");
		out.println("</BODY>");
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
