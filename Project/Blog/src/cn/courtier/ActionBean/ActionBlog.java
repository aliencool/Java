package cn.courtier.ActionBean;



/**
 * @�๦��˵��������  ��ʾ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-9 ����05:08:22
 * @�汾��V1.0
 */
public class ActionBlog {
	private int log_Id;
	

	private String c_Name;
	private String title;
	private String content;
	private String time;
	private String img_Name;
	//flag����Ƿ��޸�
	private int flag;
	//�������
	private int click;
	//���޴���
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
