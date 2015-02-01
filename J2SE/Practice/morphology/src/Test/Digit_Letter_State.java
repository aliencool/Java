package Test;

public class Digit_Letter_State implements State{

	@Override
	public  void State_Work(Work work) {
		//读进可以显示的
		 int len=0;
		 //组装单词
		 String str="";
		 //每次读取一个
		 char ch=Work.getMsg()[Work.p];
		//1:去空格
		
		
		while(ch==' ')
		{
			Work.p++;
			ch=Work.getMsg()[Work.p];
		}
		
		//2:判断是否为字符或者数字
		//2.1:第一步必须是字符
		if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
		{
			    //2.2:第二步是字符加数字 还是全部字符 或者 关键字
				while((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				{
					
					
					Work.word[len]=ch;
					len++;
					Work.p++;
					ch=Work.getMsg()[Work.p];
					
				}
				//超过一位进行比较,所以,减
				Work.p--;
				//假设，它不是关键字
				Work.stats=10;
				//2.3:第三步把得到单词组装成字符串
				for (int i = 0; i < len; i++) {
					
					str=str+Work.word[i];
					
				}
				//2.4:第三步单词与关键字比较
				for (int i = 0; i < Work.keyword.length; i++) {
					if(str.compareTo(Work.keyword[i])==0)
					{
						//2.5打印出关键字和属性
						Work.stats=i+1;
					}
				}
			
				System.out.println("<"+Work.stats+"-"+str+">");
		}
		//3:交给下个状态处理
		else
		{
		
			//3.1:数字状态
			work.setState(new Digit_State());
			//3.2:调用数字的分析
			work.analysis();
		}
	}
}
