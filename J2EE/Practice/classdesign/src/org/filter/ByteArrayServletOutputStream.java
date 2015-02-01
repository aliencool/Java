package org.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;

public class ByteArrayServletOutputStream extends ServletOutputStream
{
    ByteArrayOutputStream baos;
    
    ByteArrayServletOutputStream(ByteArrayOutputStream baos)
    {
        this.baos = baos;
    }
    public void write(int data) throws IOException
    {
        baos.write(data);
    }
}