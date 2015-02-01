package Online;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		req.setCharacterEncoding("GBK");//���õõ���
		ServletContext s_context=getServletContext();//�õ������ģ����Բ鿴�����������ڵ�servlet����
		PrintWriter  out=resp.getWriter();//������Ӧ��
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		out.println("<h3>����������");
		if(s_context.getAttribute("userlist")==null)
		{
			Vector<String> aduser=new Vector<String>();//���û���û��б�ʹ�ü������
			s_context.setAttribute("userlist", aduser);
		}
		if(s_context.getAttribute("messagelist")==null)
		{
			Vector<String> message=new Vector<String>();//���û������Ϣʹ�ü������
			s_context.setAttribute("messagelist", message);
		}
		out.println("<form method='post' action='MainServlet'>");//�����servlet
		out.println("�ǳ�<input type='text' name='uname'/>");
		out.println("<input type=submit value='��½'");
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
