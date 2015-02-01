package com.BindBean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.myjdbc.Myjdbc;
import com.sun.org.apache.commons.digester.SetNextRule;

public class StuBean implements HttpSessionBindingListener {
		private int sno;
		private String sname;
		private int chinese;
		private int math;
		public int getSno() {
			return sno;
		}
		public void setSno(int sno) {
			this.sno = sno;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public int getChinese() {
			return chinese;
		}
		public void setChinese(int chinese) {
			this.chinese = chinese;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		
		public String _toString()
		{
			return sno+" "+sname+" "+chinese+" "+math;
		}
		
		
		public StuBean(int sno) {
			super();
			setSno(sno);
		}
		
		
		public StuBean(int sno, String sname, int chinese, int math) {
			super();
			setSno(sno);
			setSname(sname);
			setChinese(chinese);
			setMath(math);
		}
		public void valueBound(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			Myjdbc myjdbc=new Myjdbc(this.sno);
			try {
				StuBean st=myjdbc.selectById();
				sname=st.getSname();
				chinese=st.getChinese();
				math=st.getMath();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void valueUnbound(HttpSessionBindingEvent arg0) {
			// TODO Auto-generated method stub
			Myjdbc myjdbc=new Myjdbc(this.sno);
			try {
				System.out.println(math);
				myjdbc.updateDb(math);//servletÖÐ¸ü¸Ä
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
