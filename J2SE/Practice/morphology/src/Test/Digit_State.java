package Test;

public class Digit_State implements State{

	@Override
	public void State_Work(Work work) {
		// TODO Auto-generated method stub
		char ch=Work.getMsg()[Work.p];
		
		int num=0;
		//1:是数字
		if((ch>='0'&&ch<='9'))
		{
			while(ch>='0'&&ch<='9')
			{
				//1.1:得到字符-'0'得到数字
				num=num*10+ch-'0';
				//1.2:状态输出
				Work.stats=11;
				//1.3:输出
				Work.p++;
				ch=Work.getMsg()[Work.p];
				System.out.println("<"+Work.stats+"-"+num+">");
			}
			Work.p--;
			
		}
		else
		{	
			//2.1:其他状态
			work.setState(new Other_State());
			//2.2:调用数字的分析
			work.analysis();
		}
	}
}
