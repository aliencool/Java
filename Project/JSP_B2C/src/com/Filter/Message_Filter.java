package com.Filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class Message_Filter implements Filter{
	String path="";
	InputStream inputStream;
	Iterator it;
	Set key;
	Properties properties;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		 HttpServletResponse httpResp=(HttpServletResponse)response;
		ResponseWrapper httpServletResponse=new ResponseWrapper(httpResp);
		//传递我的返回的内容!
		chain.doFilter(httpServletRequest, httpServletResponse);
		String result=replace(httpServletResponse.getResult());
		//打印到客户
		PrintWriter printWriter=httpResp.getWriter();
		printWriter.println(result);
		printWriter.flush();
		printWriter.close();
		
	}
	
	public String replace(String content)
	{
		//设置可变
		StringBuffer buffer=new StringBuffer(content);
		//设置所有的
		StringBuffer stringBuffer=new StringBuffer();
		try {
			for (Object str:key) {
				stringBuffer.append(str);
			}
			//再截取
			String []msg=(stringBuffer.toString()).split("=");
			for (int i = 0; i < msg.length; i++) {
				String replace_key=msg[i];
				int index=buffer.indexOf(replace_key);
				
				while(-1!=index)
				{
					buffer.replace(index, index+replace_key.length(),msg[i+1]);
					//再次查找
					index=buffer.indexOf(replace_key);
				}
				//跳过****
				i++;
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(inputStream!=null)
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		path=filterConfig.getInitParameter("filepath");
		inputStream=filterConfig.getServletContext().getResourceAsStream(path);
		//得到属性文件
		properties=new Properties();
		try {
			properties.load(inputStream);
			key=properties.entrySet(); 
			it=key.iterator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
}
