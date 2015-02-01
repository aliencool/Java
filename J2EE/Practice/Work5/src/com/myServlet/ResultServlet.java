package com.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsh.EvalError;
import bsh.Interpreter;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		PrintWriter  out=resp.getWriter();//������Ӧ��
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> ResultServlet </TITLE><HEAD>");
		out.println("<BODY bgcolor=\"# ffffff\">");
		out.println("<h3>���˽��:");
		Vector<String> vector=new Vector<String>();
		vector=(Vector<String>)getServletContext().getAttribute("result");
		if(vector.size()==0)return;
		String str=vector.elementAt(0).toString();
		out.println(vector.get(0));
		for (int i = 1; i < vector.size(); i++) {
			str=str+vector.elementAt(i);
			out.println(vector.get(i));
		}
		out.println("<br>"+"������ֵ:"+str);
		Interpreter integer=new Interpreter();
		//��׺���ʽ
		try {
			integer.eval("Result="+str.toString());	
			out.println("="+integer.get("Result"));
			//�ٴμ���
			vector.removeAllElements();
		
		} catch (EvalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
