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
		resp.setContentType("text/html;charset=GBK");//设置返回的
		req.setCharacterEncoding("GBK");//设置得到的
		ServletContext s_context=getServletContext();//得到上下文，可以查看所有上下文内的servlet属性
		PrintWriter  out=resp.getWriter();//设置响应的
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		out.println("<h3>进入聊天室");
		if(s_context.getAttribute("userlist")==null)
		{
			Vector<String> aduser=new Vector<String>();//如果没有用户列表使用集合添加
			s_context.setAttribute("userlist", aduser);
		}
		if(s_context.getAttribute("messagelist")==null)
		{
			Vector<String> message=new Vector<String>();//如果没有新信息使用集合添加
			s_context.setAttribute("messagelist", message);
		}
		out.println("<form method='post' action='MainServlet'>");//处理的servlet
		out.println("昵称<input type='text' name='uname'/>");
		out.println("<input type=submit value='登陆'");
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
