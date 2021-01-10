package file_system;

public class MyUser {
	private String userName;
	private String password;
	private boolean userFlag;
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		//System.out.println(userName+"@");
		userFlag=true;
		// TODO 自动生成的构造函数存根
		
	}
	int checkUser(String userName,String password) {
		//System.out.println(userName+"!");
		if (this.userName.equals(userName)&&this.password.equals(password))
			return 0;
		else if (this.userName.equals(userName))
			return 1;
		else {
			return 2;
		}
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
