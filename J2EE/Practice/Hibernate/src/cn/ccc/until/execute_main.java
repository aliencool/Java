package cn.ccc.until;

import cn.ccc.Dao.execute;
import cn.ccc.bean.User;

public class execute_main {

	/**
	 * 执行文件
	 * @param args
	 */
	public static void main(String[] args) {
		//创建执行
		execute e=new execute();
		
		//创建vo
		User u=new User();
		u.setAge(22);
		u.setName("ccc");
		u.setId(1);
		
		//保存
		e.save(u);
		
		//查询
		System.out.print("查询:");
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
		
		System.out.println();
		
		//修改前
		System.out.print("修改前:");
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
		
		//修改后
		System.out.print("修改后:");
		u.setAge(23);
		u=e.search(1);
		System.out.println("name="+u.getName()+","+"age="+u.getAge());
	}

}
