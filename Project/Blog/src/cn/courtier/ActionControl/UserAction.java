package cn.courtier.ActionControl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.courtier.po.Bloguser;
import cn.courtier.user.Im.User_Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @类功能说明：用户登陆Action
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-13 下午12:19:52
 * @版本：V1.0
 */
public class UserAction extends ActionSupport{

	private Bloguser actionuser;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String fileFileType;
	@Resource(name="userService")
	private User_Service service;
	
	//0:注册 1:修改 2:登陆 3:检测用户名 4:检测用户密码
	private int flag;
	//为了验证用户名使用
	HttpServletResponse response=ServletActionContext.getResponse();
	//用户id
	private int id;
	@Autowired  
	private  HttpServletRequest request; 
	
	

	public File getFile() {
		return file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public String getFileFileType() {
		return fileFileType;
	}

	
	public void setFile(File file) {
		this.file = file;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFileFileType(String fileFileType) {
		this.fileFileType = fileFileType;
	}

	
	
	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Bloguser getActionuser() {
		return actionuser;
	}

	public void setActionuser(Bloguser actionuser) {
		this.actionuser = actionuser;
	}

	@Override
	public String execute() throws Exception {
		
		switch(flag)
		{
				case 0:
					actionuser.setU_Pic("upload/image/"+new Date().getTime()+fileFileName);
					//保存图片
					putUploadImage();
					service.insertUser(actionuser);return "share";
				case 1:
					//证明修改了图片
					System.out.println(actionuser.getU_Sign());
					if(fileFileName!=null)
					{
						actionuser.setU_Pic("upload/image/"+new Date().getTime()+fileFileName);
						putUploadImage();
					}
					service.updateUser(actionuser, id);return "updata";
				case 2:	
					//得到对象
					Bloguser bolguser= service.selectUser(actionuser,0);
					
				if(bolguser!=null)
				{
					
						//保存为session级别，用user作为key!
						request.getSession().setAttribute("user", bolguser);
						
						return "share";
				}
				else{return "error";}
				
				//用户名
				case 3:
					//值为空，肯定可用
					if(service.checkUser(actionuser, 0)!=null)
					{
						
						response.getWriter().println(1992);
					}else{
						response.getWriter().println(1991);
					}
					
				return NONE;
				//密码
				case 4:
					//值为空,肯定是密码错误
					//1:验证
					if(service.checkUser(actionuser, 1)!=null)
					{
						response.getWriter().println(1991);
					}else
					{
						response.getWriter().println(1992);
					}
					
				return NONE;
		}
		return "error";
	}
	
	/**
	 * 函数功能说明:保存图片
	 * Administrator  2014-6-12
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @throws FileNotFoundException
	 * @参数： @throws IOException    
	 * @return void   
	 * @throws
	 */
	private void putUploadImage() throws FileNotFoundException, IOException {
		
		InputStream inputStream=new FileInputStream(file);
		
		OutputStream outputStream=new FileOutputStream(ServletActionContext.getRequest().getRealPath("upload/image")+"/"+new Date().getTime()+fileFileName);
		
		byte []b=new byte[1024*1024*5];
		
		int len;
		
		while((len=inputStream.read(b))!=-1)
		{
			outputStream.write(b,0,len);
		}
		inputStream.close();
		outputStream.close();
	}
	
	
}
