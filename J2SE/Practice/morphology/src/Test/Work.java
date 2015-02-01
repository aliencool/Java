package Test;
//工作类，交给状态处理，并有关键字表
public class Work {
	
	/*字段*/
	//移动数组的
	public static int p=0;
	//保存当前的
	public static int m=0;
	//状态
	private State state;
	//生成一个数组 只读
	private  static char []msg; 
	//为关键字设置数字
	public static String []keyword={"#","include","int","main","printf","return"};
	
	//单词属性
	public static int stats=0;
	//单词
	public static char []word=new char[8];
	
	
	
	/*属性*/
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public static void setMsg(char[] msg) {
		Work.msg = msg;
	}
	public static char[] getMsg() {
		return msg;
	}
	//设置初始状态
	public Work()
	{
		this.setState(new Digit_Letter_State());
	}
	
	
	//分析
	public void analysis()
	{	
		state.State_Work(this);
		
	}
	
	
}
