package Online;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		req.setCharacterEncoding("GBK");//���õõ���
		ServletContext s_context=getServletContext();//�õ������ģ����Բ鿴�����������ڵ�servlet����
		PrintWriter  out=resp.getWriter();//������Ӧ��
		String name=s_context.getInitParameter("uname");
    
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		out.println("����");
		Vector<String> hsb=(Vector<String>)s_context.getAttribute("messagelist");
		out.println("<textarea name='info' row='9'>");
		for (int i = 0; i < hsb.size(); i++) {
			out.println(hsb.get(i));//������Ϣ��ȥ
			
		}
		out.println("</textarea>");
		out.println("�û��б�");
		Vector<String> usb=(Vector<String>)s_context.getAttribute("userlist");
		out.println("<textarea name='user' row='9'>");
		
		
		for (int i = 0; i < usb.size(); i++) {

			
			if(usb.get(i)!=null)
			{
				out.println(usb.get(i));
			}
			
		}
		out.println("</textarea>");
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
