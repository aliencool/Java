package oc;

import java.sql.*;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataBaseBeanTest {
	private String sname;
	private String ssex;
	private String sscore;
	
	public DataBaseBeanTest() {
		super();
	
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String ssname) {
		this.sname = ssname;
		
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSscore() {
		return sscore;
	}
	public void setSscore(String sscore) {
		this.sscore = sscore;
	}
	
	

}




