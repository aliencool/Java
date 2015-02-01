package org.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class MyResponseWrapper extends HttpServletResponseWrapper
{
    private ByteArrayOutputStream baos;
    private ByteArrayServletOutputStream basos;
    private PrintWriter pw;
    
    public MyResponseWrapper(HttpServletResponse response)
    {
        super(response);
        //����ByteArrayOutputStream����
        baos=new ByteArrayOutputStream();
        //��ByteArrayOutputStream������Ϊ������
        //����ByteArrayServletOutputStream����
        basos=new ByteArrayServletOutputStream(baos);
        //��ByteArrayOutputStream������Ϊ������
        //����PrintWriter����
        pw=new PrintWriter(baos);
    }
    
    public PrintWriter getWriter()
    {
        return pw;
    }
    
    public ServletOutputStream getOutputStream()
    {
        return basos;
    }
    
    /**
     * ���ֽ��������ʽ����������������е����ݡ�
     */
    public byte[] toByteArray()
    {
        return baos.toByteArray();
    }
}