package org.sise.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Imple;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionSupport;

public class add_action extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 188553L;
	/*ͼƬ*/
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	
	
	private String title;
	private String soure;
	private Date datetime;
	private String tt;
	
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
	public String getTitle() {
		return title;
	}
	public String getSoure() {
		return soure;
	}
	public Date getDatetime() {
		return datetime;
	}
	public String getTt() {
		return tt;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSoure(String soure) {
		this.soure = soure;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
	
		//1:ת��
		String date_time=new SimpleDateFormat("yyyy-MM-dd").format(this.getDatetime());
		
		//����
		News news=new News();
		
		//����:
		news.setContent(this.getTt());
		//ʱ��:
		news.setIssue_time(datetime);
		//����:
		news.setTitle(this.getTitle());
		//��Դ:
		news.setSource(this.getSoure());
		//����
		Save_Image();
		//����ͼƬ:
		news.setImag_url("upload"+"/"+fileFileName);
		
		
		//������ݿ�
		Dao_Interface daoInterface=DB_Factory.getInstance();
		daoInterface.insert(news);
		
		return SUCCESS;
	}
	
	public void Save_Image()
	{
		OutputStream outputStream=null;
		InputStream inputStream=null;
		String url=ServletActionContext.getRequest().getRealPath("upload")+"//"+fileFileName;
		try {
			outputStream=new  FileOutputStream(url);
			inputStream=new FileInputStream(file);
			//����
			int len=0;
			byte[] b=new byte[1024];
			
			while((len=inputStream.read(b))!=-1)
			{
				outputStream.write(b, 0, len);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				if(outputStream!=null)
				outputStream.close();
				if(inputStream!=null)
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
	
}
