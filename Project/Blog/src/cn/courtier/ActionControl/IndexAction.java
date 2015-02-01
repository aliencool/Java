package cn.courtier.ActionControl;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @类功能说明：进入首页的Action
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 下午03:56:10
 * @版本：V1.0
 */
public class IndexAction extends ActionSupport{

	/**
	 *@类名：首页
	 *@描述：{todo}
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("测试");
		return SUCCESS;
	}
}
