package cn.courtier.po;

import java.util.HashSet;
import java.util.Set;

/**
 * @�๦��˵����Blog ����ʵ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����04:59:17
 * @�汾��V1.0
 */
public class Category {
    
	private int id;
	private String c_Name;
	//1...n����
	private  Set<BlogContent> b_all=new HashSet<BlogContent>();
	

  
	

	public Set<BlogContent> getB_all() {
		return b_all;
	}

	public void setB_all(Set<BlogContent> bAll) {
		b_all = bAll;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_Name() {
		return c_Name;
	}

	

	public void setC_Name(String cName) {
		c_Name = cName;
	}
	
	
	
	
}
