package cn.ccc.Dao;

import cn.ccc.bean.User;
/*2014年4月12日16:41:08
 * 工具类
 * 
 * 注意：
 * update 等:全是bean文件
 * */
public interface Implement {
		public User search(int id);
		public void save(User u);
		public void delete(User u);
		public void Update(User u );
}
