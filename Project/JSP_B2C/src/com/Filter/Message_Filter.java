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
		//�����ҵķ��ص�����!
		chain.doFilter(httpServletRequest, httpServletResponse);
		String result=replace(httpServletResponse.getResult());
		//��ӡ���ͻ�
		PrintWriter printWriter=httpResp.getWriter();
		printWriter.println(result);
		printWriter.flush();
		printWriter.close();
		
	}
	
	public String replace(String content)
	{
		//���ÿɱ�
		StringBuffer buffer=new StringBuffer(content);
		//�������е�
		StringBuffer stringBuffer=new StringBuffer();
		try {
			for (Object str:key) {
				stringBuffer.append(str);
			}
			//�ٽ�ȡ
			String []msg=(stringBuffer.toString()).split("=");
			for (int i = 0; i < msg.length; i++) {
				String replace_key=msg[i];
				int index=buffer.indexOf(replace_key);
				
				while(-1!=index)
				{
					buffer.replace(index, index+replace_key.length(),msg[i+1]);
					//�ٴβ���
					index=buffer.indexOf(replace_key);
				}
				//����****
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
		//�õ������ļ�
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
