package cn.courtier.ActionBean;

import java.util.HashSet;
import java.util.Set;

/**
 * @�๦��˵����Blog   ��ʾ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-9 ����04:59:17
 * @�汾��V1.0
 */
public class ActionCategory {
    
	private int id;
	private String c_Name;
	//1...n����

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

	
	//
	public ActionCategory(String cName) {
		super();
		c_Name = cName;
	}

	
	
	
}
