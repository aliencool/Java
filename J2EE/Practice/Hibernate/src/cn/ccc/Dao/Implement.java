package cn.ccc.Dao;

import cn.ccc.bean.User;
/*2014��4��12��16:41:08
 * ������
 * 
 * ע�⣺
 * update ��:ȫ��bean�ļ�
 * */
public interface Implement {
		public User search(int id);
		public void save(User u);
		public void delete(User u);
		public void Update(User u );
}
