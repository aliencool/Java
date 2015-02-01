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
 * @�๦��˵�����û���½Action
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-13 ����12:19:52
 * @�汾��V1.0
 */
public class UserAction extends ActionSupport{

	private Bloguser actionuser;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String fileFileType;
	@Resource(name="userService")
	private User_Service service;
	
	//0:ע�� 1:�޸� 2:��½ 3:����û��� 4:����û�����
	private int flag;
	//Ϊ����֤�û���ʹ��
	HttpServletResponse response=ServletActionContext.getResponse();
	//�û�id
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
					//����ͼƬ
					putUploadImage();
					service.insertUser(actionuser);return "share";
				case 1:
					//֤���޸���ͼƬ
					System.out.println(actionuser.getU_Sign());
					if(fileFileName!=null)
					{
						actionuser.setU_Pic("upload/image/"+new Date().getTime()+fileFileName);
						putUploadImage();
					}
					service.updateUser(actionuser, id);return "updata";
				case 2:	
					//�õ�����
					Bloguser bolguser= service.selectUser(actionuser,0);
					
				if(bolguser!=null)
				{
					
						//����Ϊsession������user��Ϊkey!
						request.getSession().setAttribute("user", bolguser);
						
						return "share";
				}
				else{return "error";}
				
				//�û���
				case 3:
					//ֵΪ�գ��϶�����
					if(service.checkUser(actionuser, 0)!=null)
					{
						
						response.getWriter().println(1992);
					}else{
						response.getWriter().println(1991);
					}
					
				return NONE;
				//����
				case 4:
					//ֵΪ��,�϶����������
					//1:��֤
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
	 * ��������˵��:����ͼƬ
	 * Administrator  2014-6-12
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @throws FileNotFoundException
	 * @������ @throws IOException    
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
