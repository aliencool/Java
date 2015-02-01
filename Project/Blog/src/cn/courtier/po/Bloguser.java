package cn.courtier.po;

import java.util.HashSet;
import java.util.Set;


	
/**
 * @类功能说明：User的实体类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-7 下午04:57:40
 * @版本：V1.0
 */
public class Bloguser {
	private int u_Id;
	private String u_Name;
	private String u_Nickname;
	private String u_Email;
	private String u_Password;
	private String u_Province;
	private String u_City;
	private String u_Area;
	private String u_Birthday;
	private String u_Sign;
	private String u_Pic;
	private int u_Status;
	private String u_Ip;
	private String u_LoginTime;
	private int  u_Power;
	
	//给当前用户留言
	Set<Send_Message> messages=new HashSet<Send_Message>();
	
	public int getU_Id() {
		return u_Id;
	}
	public String getU_Name() {
		return u_Name;
	}
	public String getU_Nickname() {
		return u_Nickname;
	}
	public String getU_Email() {
		return u_Email;
	}
	public String getU_Password() {
		return u_Password;
	}
	public String getU_Province() {
		return u_Province;
	}
	public String getU_City() {
		return u_City;
	}
	public String getU_Area() {
		return u_Area;
	}
	public String getU_Birthday() {
		return u_Birthday;
	}
	public String getU_Sign() {
		return u_Sign;
	}
	public String getU_Pic() {
		return u_Pic;
	}
	public int getU_Status() {
		return u_Status;
	}
	public String getU_Ip() {
		return u_Ip;
	}
	public String getU_LoginTime() {
		return u_LoginTime;
	}
	public int getU_Power() {
		return u_Power;
	}
	public void setU_Id(int uId) {
		u_Id = uId;
	}
	public void setU_Name(String uName) {
		u_Name = uName;
	}
	public void setU_Nickname(String uNickname) {
		u_Nickname = uNickname;
	}
	public void setU_Email(String uEmail) {
		u_Email = uEmail;
	}
	public void setU_Password(String uPassword) {
		u_Password = uPassword;
	}
	public void setU_Province(String uProvince) {
		u_Province = uProvince;
	}
	public void setU_City(String uCity) {
		u_City = uCity;
	}
	public void setU_Area(String uArea) {
		u_Area = uArea;
	}
	public void setU_Birthday(String uBirthday) {
		u_Birthday = uBirthday;
	}
	public void setU_Sign(String uSign) {
		u_Sign = uSign;
	}
	public void setU_Pic(String uPic) {
		u_Pic = uPic;
	}
	public void setU_Status(int uStatus) {
		u_Status = uStatus;
	}
	public void setU_Ip(String uIp) {
		u_Ip = uIp;
	}
	public void setU_LoginTime(String string) {
		u_LoginTime = string;
	}
	public void setU_Power(int uPower) {
		u_Power = uPower;
	}
	public Set<Send_Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Send_Message> messages) {
		this.messages = messages;
	}
	

	
}
