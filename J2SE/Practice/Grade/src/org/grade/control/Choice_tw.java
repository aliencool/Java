package org.grade.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.grade.Model_Get_Data_Excel.Excel_until;
import org.grade.bean.Save_twice;
import org.grade.bean.Save_twice_data;
import org.grade.model_command.Logic_CalCoeD2;
import org.grade.model_twice.logic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Choice_tw extends ActionSupport{
	private  File file;
	private  String fileFileName;
	private  String fileContentType;
	private OutputStream outputStream;
	private InputStream inputStream;
	private String choice;
	private Save_twice_data std;
	
	
	
	
	
	
	
	
	
	


	public Save_twice_data getStd() {
		return std;
	}


	public void setStd(Save_twice_data std) {
		this.std = std;
	}


	public String getChoice() {
		return choice;
	}


	public void setChoice(String choice) {
		this.choice = choice;
	}


	public String getPath() {
		return ServletActionContext.getRequest().getRealPath("/upload");
	}


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
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//专门保存数据
		Save_twice_data std=new Save_twice_data();
		
		//上传
		up();
		//得到excel文件
		File F_Excel=new File(getPath()+"//"+fileFileName);
			
			//分析
			//两组判别算法
			//先set
			Excel_until.setF(F_Excel);
			//再执行
			Excel_until.getExcel();
			//两组判别分析
			logic.complute(std);
			//设置对象
			ActionContext.getContext().getSession().put("std", std);
			return "two";
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	//上传数据
	public void up()
	{
		//定义缓冲
		byte[] b=new byte[1024*1024];
		
		try {
			//定义输入区
			inputStream=new FileInputStream(file);
			 //定义输出区
			outputStream=new FileOutputStream(getPath()+"//"+fileFileName);
			//定义len
			int len=0;
			//输出到服务器
			while((len=inputStream.read(b))!=-1)
			{
				outputStream.write(b,0,len);
			}
			closestream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*//上传数据验证
	@Override
	public void validate() {
		
	}*/


	public void closestream()
	{
			try {
				if(inputStream!=null)
					inputStream.close();
				if(outputStream!=null)
					outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
