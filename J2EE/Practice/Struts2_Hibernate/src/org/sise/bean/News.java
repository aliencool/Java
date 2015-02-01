package org.sise.bean;

import java.util.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private String source;
	private Date issue_time;
	private String imag_url;
	
	
	public String getImag_url() {
		return imag_url;
	}
	public void setImag_url(String imagUrl) {
		imag_url = imagUrl;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getSource() {
		return source;
	}
	public Date getIssue_time() {
		return issue_time;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setIssue_time(Date issueTime) {
		issue_time = issueTime;
	}
	
}
