package cn.courtier.po;

/**
 * @�๦��˵�����Ƽ����±�
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����05:27:03
 * @�汾��V1.0
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
