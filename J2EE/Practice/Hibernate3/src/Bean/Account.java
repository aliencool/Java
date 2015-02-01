package Bean;

import java.util.Set;

public class Account {
	private int account_id;
	private String act_no;
	private double bal;
	private Nickname  nickname;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int accountId) {
		account_id = accountId;
	}
	public String getAct_no() {
		return act_no;
	}
	public double getBal() {
		return bal;
	}
	
	
	public void setAct_no(String actNo) {
		act_no = actNo;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public Nickname getNickname() {
		return nickname;
	}
	public void setNickname(Nickname nickname) {
		this.nickname = nickname;
	}
	
	
	
	
}
