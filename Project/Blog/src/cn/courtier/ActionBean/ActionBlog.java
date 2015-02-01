package cn.courtier.ActionBean;



/**
 * @类功能说明：博文  显示类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-9 下午05:08:22
 * @版本：V1.0
 */
public class ActionBlog {
	private int log_Id;
	

	private String c_Name;
	private String title;
	private String content;
	private String time;
	private String img_Name;
	//flag标记是否修改
	private int flag;
	//点击次数
	private int click;
	//点赞次数
	private int award;
	public int getLog_Id() {
		return log_Id;
	}
	
	

	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	public String getImg_Name() {
		return img_Name;
	}
	public int getFlag() {
		return flag;
	}
	public void setLog_Id(int logId) {
		log_Id = logId;
	}
	
	
	
	public String getC_Name() {
		return c_Name;
	}


	public void setC_Name(String cName) {
		c_Name = cName;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public void setImg_Name(String imgName) {
		img_Name = imgName;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getClick() {
		return click;
	}
	public int getAward() {
		return award;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public void setAward(int award) {
		this.award = award;
	}


	public ActionBlog(String cName,  String title,
			String content, String Time, 
			String imgName, int click, int award) {
		super();
		c_Name = cName;
		this.title = title;
		this.content = content;
		time = Time;
		img_Name = imgName;
		this.click = click;
		this.award = award;
	}
	
	

	
	
}
