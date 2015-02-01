package Test;

public class Other_State implements State{
	private static int row=1;
	@Override
	public void State_Work(Work work) {
		// TODO Auto-generated method stub
		//行
		
		char ch=Work.getMsg()[Work.p];
		
		//声明个变量，存放组合
		String msg="";
		switch(ch)
		{
		case '#':
			Work.stats=1;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '{':
			Work.stats=7;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '}':
			Work.stats=8;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '+':
			Work.stats=9;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '-':
			Work.stats=10;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '*':
			Work.stats=11;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '/':
			Work.stats=12;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '=':
			Work.stats=13;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '<':
			//等号组合
			Work.p++;
			if((msg=String.valueOf(Work.getMsg()[Work.p])).equals("="))
			{
				msg=ch+msg;
				Work.stats=15;
				System.out.println("<"+Work.stats+"-"+msg+">");
			}
			else
			{	//只有个<
				Work.p--;
				Work.stats=14;
				System.out.println("<"+Work.stats+"-"+ch+">");
			}
			break;
		case '.':
			Work.stats=18;
			System.out.println("<"+Work.stats+"-"+ch+">");break;
		case '>':
			//等号组合
			Work.p++;
			//声明个变量，存放组合
			if((msg=String.valueOf(Work.getMsg()[Work.p])).equals("="))
			{
				msg=ch+msg;
				Work.stats=17;
				System.out.println("<"+Work.stats+"-"+msg+">");
			}
			else
			{	//只有个<
				Work.p--;
				Work.stats=16;
				System.out.println("<"+Work.stats+"-"+ch+">");
			}
			break;
		case '(':
			Work.stats=19;
			System.out.println("<"+Work.stats+"-"+ch+">");
			break;
		case ')':
			Work.stats=20;
			System.out.println("<"+Work.stats+"-"+ch+">");
			break;
		case ';':
			Work.stats=21;
			System.out.println("<"+Work.stats+"-"+ch+">");
			break;
		case '"':
			Work.stats=22;
			System.out.println("<"+Work.stats+"-"+ch+">");
			break;
		case '\\':
			Work.stats=23;
			System.out.println("<"+Work.stats+"-"+ch+">");
			break;
		case '\n':
			Work.stats=-2;
			row++;
			System.out.println("第"+row+"行");
			break;
		case '\r':
			Work.stats=-3;
			System.out.println("<"+Work.stats+"-"+"\\r"+">");
			break;	
		case '?': Work.stats=-1;break;
		case '	':break;
		default:System.out.println("第"+row+":"+ch+"行错误");break;
		}
	}
}
