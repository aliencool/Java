package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BindBean.StuBean;

public class UpdateMath extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		PrintWriter  out=resp.getWriter();//������Ӧ��
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Test</TITLE><HEAD>");
		out.println("<BODY bgcolor=\"# ffffff\">");
		out.println("<h3>�޸���ѧ�ɼ����");
		HttpSession session=req.getSession();	
		StuBean stu=(StuBean) session.getAttribute("stu");//�õ�ǰ������� ������ѧ
		
		if(req.getParameter("math")!=null)
		{
			System.out.println(req.getParameter("math"));
			stu.setMath(Integer.parseInt(req.getParameter("math")));
		}
		session.removeAttribute("stu");//��������
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
