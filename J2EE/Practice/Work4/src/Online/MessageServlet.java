package Online;
/*�õ�����û�(��Main)
 * */
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//���÷��ص�
		req.setCharacterEncoding("GBK");//���õõ���
		ServletContext s_context=getServletContext();//�õ������ģ����Բ鿴�����������ڵ�servlet����
		PrintWriter  out=resp.getWriter();//������Ӧ��
		
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		String usr=req.getParameter("uname");//�õ��û�
		String msg=req.getParameter("message");//��Ϣ ����������Ǵӵ�ǰ��Ŀ¼������ģ�ʹ�õ��ǵ�һ�ִ�ֵ��ʽ
		s_context.setAttribute("uname", usr);
		
		
		Vector<String> hsg=(Vector<String>)s_context.getAttribute("messagelist");
		if(msg!=null)
		{
			hsg.add(usr+":"+msg);
		}
		out.println("<iframe frameborder=0 heigth=146 margineheight=0 marginwidth=0"+"scorllingg=auto src='DisplayServlet?uname="+usr+"' width='100%' heigth='80%'>");//��ʾdisplay
		out.println("</iframe>");
		out.println("<form method='post' action='MessageServlet?uname="+usr+"'>");
		out.println("<hr>");
		out.println("����<input type='text' name='message'/>");
		out.println("<input type=submit value='����'");
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
