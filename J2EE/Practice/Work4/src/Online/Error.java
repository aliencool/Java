package Online;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		req.setCharacterEncoding("GBK");//���õõ���
		PrintWriter  out=resp.getWriter();//������Ӧ��
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		String username=req.getParameter("sname");
		out.println("�û�:'"+username+"'�������"+",��鿴���ٵ�½");
		out.println("<li><a href=UserServlet target=view_window>���µ�½</a></li>");
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
