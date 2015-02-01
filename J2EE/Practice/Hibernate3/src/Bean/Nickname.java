package Bean;

import java.util.HashSet;
import java.util.Set;

public class Nickname {
	private int user_id;
	private String Nickname_name;
	private String Nickname_password;
	private Set<Account> account=new HashSet<Account>();
	

	public Set<Account> getAccount(){
		return account;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	
	public String getNickname_name() {
		return Nickname_name;
	}

	public String getNickname_password() {
		return Nickname_password;
	}

	public void setNickname_name(String nicknameName) {
		Nickname_name = nicknameName;
	}

	public void setNickname_password(String nicknamePassword) {
		Nickname_password = nicknamePassword;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
}
