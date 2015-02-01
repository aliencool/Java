package org.xml.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.xml.bean.Data_Bean;
import org.xml.model.Xml_Data;

import com.opensymphony.xwork2.ActionSupport;

public class Up_Load extends ActionSupport{
	private File file;
	private String fileFileName;
	private String fileContentType;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	
	public File getFile() {
		return file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//
		 inputStream=new FileInputStream(file);
		 outputStream=new FileOutputStream(ServletActionContext.getRequest().getRealPath("upload")+"//"+fileFileName);
		//
		byte [] by=new byte[1024];
		//
		int len=0;
		//∂¡
		while((len=inputStream.read(by))!=-1)
		{
			outputStream.write(by, 0, len);
		}
		//≤Â»Î
		Xml_Data.explain_xml(ServletActionContext.getRequest().getRealPath("upload")+"//"+fileFileName);
		inputStream.close();
		outputStream.close();

		return SUCCESS;
	}
	
	
	
	

}
