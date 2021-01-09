package file_system;

public class MyUser {
	private String userName;
	private String password;
	private boolean userFlag;
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		userFlag=true;
		// TODO 自动生成的构造函数存根
		
	}
	boolean checkUser(String userName,String password) {
		return this.userName.equals(userName)&&this.password.equals(password);
	}
	void deleteUser() {
		userFlag=false;
	}
	public boolean getFlag() {
		// TODO 自动生成的方法存根
		return userFlag;
	}
	public String getUserName() {
		// TODO 自动生成的方法存根
		return userName;
	}
}
