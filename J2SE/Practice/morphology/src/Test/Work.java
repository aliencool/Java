package Test;
//�����࣬����״̬�������йؼ��ֱ�
public class Work {
	
	/*�ֶ�*/
	//�ƶ������
	public static int p=0;
	//���浱ǰ��
	public static int m=0;
	//״̬
	private State state;
	//����һ������ ֻ��
	private  static char []msg; 
	//Ϊ�ؼ�����������
	public static String []keyword={"#","include","int","main","printf","return"};
	
	//��������
	public static int stats=0;
	//����
	public static char []word=new char[8];
	
	
	
	/*����*/
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
	//���ó�ʼ״̬
	public Work()
	{
		this.setState(new Digit_Letter_State());
	}
	
	
	//����
	public void analysis()
	{	
		state.State_Work(this);
		
	}
	
	
}
