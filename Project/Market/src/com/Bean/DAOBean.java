package com.Bean;

import java.util.HashMap;

public class DAOBean {
	private int id;
	private String user;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String country;
	private String City;
	private String ip;
	private String time;
	private String time_Start;
	
	public DAOBean()
	{
	}
	
	
	public DAOBean(String user, String password, String address, String email,
			String phone, String country, String city, String timeStart) {
		super();
		this.user = user;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.country = country;
		City = city;
		time_Start = timeStart;
	}
	

	public DAOBean(int id, String user, String email, String ip, String time) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.ip = ip;
		this.time = time;
	}


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getTime_Start() {
		return time_Start;
	}
	public void setTime_Start(String timeStart) {
		time_Start = timeStart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	
	
}
