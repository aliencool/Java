package Online;
/*得到添加用户(从Main)
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
		resp.setContentType("text/html;charset=GBK");//设置返回的
		req.setCharacterEncoding("GBK");//设置得到的
		ServletContext s_context=getServletContext();//得到上下文，可以查看所有上下文内的servlet属性
		PrintWriter  out=resp.getWriter();//设置响应的
		
		out.println("<!DOCTYPE htmlPUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> A SERVLET </TITLE><HEAD>");
		out.println("<BODY>");
		String usr=req.getParameter("uname");//得到用户
		String msg=req.getParameter("message");//信息 这个两个都是从当前的目录的输入的，使用的是第一种传值方式
		s_context.setAttribute("uname", usr);
		
		
		Vector<String> hsg=(Vector<String>)s_context.getAttribute("messagelist");
		if(msg!=null)
		{
			hsg.add(usr+":"+msg);
		}
		out.println("<iframe frameborder=0 heigth=146 margineheight=0 marginwidth=0"+"scorllingg=auto src='DisplayServlet?uname="+usr+"' width='100%' heigth='80%'>");//显示display
		out.println("</iframe>");
		out.println("<form method='post' action='MessageServlet?uname="+usr+"'>");
		out.println("<hr>");
		out.println("发送<input type='text' name='message'/>");
		out.println("<input type=submit value='发送'");
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
