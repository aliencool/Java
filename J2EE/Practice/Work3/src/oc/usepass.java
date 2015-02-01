package oc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class usepass extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  DataBaseBeanTest data=null;
	private  jnditest jt=new jnditest();
	public static String use;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
	
		
		String msg=req.getParameter("sname");
		String password=req.getParameter("ssex");
		HttpSession httpSession=req.getSession();
		
		if(msg!=null&&password!=null)
		{
			httpSession.setAttribute("user", msg);
			httpSession.setAttribute("password",password);
		}
		if(jt.search_use(msg, password))
		{
			RequestDispatcher re=req.getRequestDispatcher("Myname");
			re.forward(req, resp);
		}
		else
		{
			RequestDispatcher re=req.getRequestDispatcher("myError");
			re.forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
}
