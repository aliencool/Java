package Online;
/*����û�����Ϣҳ��
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private int count=0;
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
		out.println("<h3>����������");
		Vector<String> vc=(Vector<String>)s_context.getAttribute("userlist");//�õ������б�
		String username=req.getParameter("uname");
		
		for (int i = 0; i < vc.size(); i++) {
			if(vc.get(i).equals(username))
			{
				count=1;//��ͬ��Ϊ1,��ʾ�����
			}
			
			
		}//ÿ�ε�½ǰ�ж�
		if(count==0)
		{
			vc.add(username);
			
		}
		count=0;//ÿ���û�������
		
		RequestDispatcher view=req.getRequestDispatcher("MessageServlet?uname="+username);
		view.forward(req, resp);
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
