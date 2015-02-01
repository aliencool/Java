package oc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResponeTest extends HttpServlet{
	private jnditest jt=new jnditest();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				//打印的字体
				resp.setContentType("text/html;charset=gbk");
				HttpSession httpSession=req.getSession();
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head><title>StudentServlet</title></head>");
				out.println("<body bgcolor=\"#ffffff\">");
				if(req.getParameter("studentName")==null || 
						req.getParameter("studentName").equals("Input number")){
					out.println("欢迎您图书馆管理员:"+httpSession.getAttribute("user"));
					out.println("<form method='post' action='Myname'>");
					out.println("图书ID进行查询：<input type='text' name='studentName' value='Input number' />");
					out.println("<input type='submit' value='查询' /><br>");
					out.println("</form>");
					System.out.println(1);
				}else if(! req.getParameter("studentName").equals("Input number")){
					out.println("<form method='post' action='Myname'>");
					out.println("图书ID进行查询：<input type='text' name='studentName' value='Input number' />");
					out.println("<input type='submit' value='查询' /><br>");
					out.println("</form>");
					out.println("<hr>");
					out.println("<table border='1'><tr>");
					out.println("<th>书名</th><th>编号</th><th>价钱</th></tr>");
					try {
						
							jt.search_msg(Integer.parseInt(req.getParameter("studentName")));
							out.println("<tr>");
							out.println("<td>"+jt.ay.get(0)+"</td>");
							out.println("欢迎您图书馆管理员:"+httpSession.getAttribute("user")+"查询结果如下");
							out.println("<td>"+jt.ay.get(1)+"</td>");
							out.println("<td>"+jt.ay.get(2)+"</td>");
							out.println("</tr>");
					
						out.println("</table>");
					} catch (Exception e) {
						e.printStackTrace();
						out.println("<th>没有这个信息</th></tr>");
					}
					out.println("</body>");
					out.println("</html>");
					out.close();
	    	}
		}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	private static final long serialVersionUID = 1L;

}
