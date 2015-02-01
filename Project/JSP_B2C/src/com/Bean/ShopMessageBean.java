package com.Bean;



public class ShopMessageBean {
	//商品id
	int shop_id;
	//用户名
	String user;
	//等级
	int level;
	//用户评论的内容
	String mesg;
	//时间
	String time;
	
	
	public ShopMessageBean(String user, int level, String mesg, String time) {
		super();
		this.user = user;
		this.level = level;
		this.mesg = mesg;
		this.time = time;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shopId) {
		shop_id = shopId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
