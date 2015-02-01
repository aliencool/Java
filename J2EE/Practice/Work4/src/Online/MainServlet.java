package Online;
/*添加用户到信息页面
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
		resp.setContentType("text/html;charset=GBK");//设置返回的
		req.setCharacterEncoding("GBK");//设置得到的
		ServletContext s_context=getServletContext();//得到上下文，可以查看所有上下文内的servlet属性
		PrintWriter  out=resp.getWriter();//设置响应的
		
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		out.println("<h3>进入聊天室");
		Vector<String> vc=(Vector<String>)s_context.getAttribute("userlist");//得到在线列表
		String username=req.getParameter("uname");
		
		for (int i = 0; i < vc.size(); i++) {
			if(vc.get(i).equals(username))
			{
				count=1;//相同就为1,表示不添加
			}
			
			
		}//每次登陆前判断
		if(count==0)
		{
			vc.add(username);
			
		}
		count=0;//每个用户都重置
		
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
