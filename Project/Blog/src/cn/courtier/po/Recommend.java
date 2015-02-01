package cn.courtier.po;

/**
 * @类功能说明：推荐文章表
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-7 下午05:27:03
 * @版本：V1.0
 */
public class Recommend {
    private int r_Id;
    private BlogContent bid;
	public int getR_Id() {
		return r_Id;
	}
	
	public void setR_Id(int rId) {
		r_Id = rId;
	}
	
	public void setBid(BlogContent bid) {
		this.bid = bid;
	}
	public BlogContent getBid() {
		return bid;
	}
      
      
      
}
