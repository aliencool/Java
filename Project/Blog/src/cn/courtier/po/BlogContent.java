package cn.courtier.po;



/**
 * @�๦��˵��������  ʵ����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����05:08:22
 * @�汾��V1.0
 */
public class BlogContent {
	private int log_Id;
	
//	//�����user 1.....n������
	private Bloguser bloguser;
//	//�����Category 1....n������
	private Category category;
	
	private String title;
	private String content;
	private String send_Time;
	private String correct_Time;
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
	public Bloguser getBloguser() {
		return bloguser;
	}
	public Category getCategory() {
		return category;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getSend_Time() {
		return send_Time;
	}
	public String getCorrect_Time() {
		return correct_Time;
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
	public void setBloguser(Bloguser bloguser) {
		this.bloguser = bloguser;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSend_Time(String sendTime) {
		send_Time = sendTime;
	}
	public void setCorrect_Time(String correctTime) {
		correct_Time = correctTime;
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
	
	

	
	
}
