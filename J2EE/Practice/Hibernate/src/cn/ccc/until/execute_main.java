package cn.ccc.until;

import cn.ccc.Dao.execute;
import cn.ccc.bean.User;

public class execute_main {

	/**
	 * ִ���ļ�
	 * @param args
	 */
	public static void main(String[] args) {
		//����ִ��
		execute e=new execute();
		
		//����vo
		User u=new User();
		u.setAge(22);
		u.setName("ccc");
		u.setId(1);
		
		//����
		e.save(u);
		
		//��ѯ
		System.out.print("��ѯ:");
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
		
		System.out.println();
		
		//�޸�ǰ
		System.out.print("�޸�ǰ:");
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
		
		//�޸ĺ�
		System.out.print("�޸ĺ�:");
		u.setAge(23);
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
	}

}
