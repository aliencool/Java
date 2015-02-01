package oc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Error extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=req.getSession();
		resp.setContentType("text/html;charset=GBK");//设置返回的
		req.setCharacterEncoding("GBK");//设置得到的
		PrintWriter  out=resp.getWriter();//设置响应的
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		out.println("用户:'"+httpSession.getAttribute("user")+"'账号或者密码错误"+",请查看后再登陆");
		out.println("<li><a href=index.jsp target=view_window>重新登陆</a></li>");
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
