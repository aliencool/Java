package S_Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ActionShow extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义区
	private String name;
	private String password;
	private String sx;
	private List<String> hob;
	private List<String> fav;
	private String mes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSx() {
		return sx;
	}
	public void setSx(String sx) {
		this.sx = sx;
	}
	public List<String> getHob() {
		return hob;
	}
	public void setHob(List<String> hob) {
		this.hob = hob;
	}
	public List<String> getFav() {
		return fav;
	}
	public void setFav(List<String> fav) {
		this.fav = fav;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	//验证
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(name==null || name.trim().length() == 0)
		{
			addFieldError("name", "User Don'T null");
		}
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(212);
		
		return SUCCESS;
	}
	
	
	
	

}
