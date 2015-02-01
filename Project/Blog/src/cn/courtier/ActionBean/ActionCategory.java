package cn.courtier.ActionBean;

import java.util.HashSet;
import java.util.Set;

/**
 * @类功能说明：Blog   显示类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-9 下午04:59:17
 * @版本：V1.0
 */
public class ActionCategory {
    
	private int id;
	private String c_Name;
	//1...n博文

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
