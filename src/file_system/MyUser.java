package file_system;

public class MyUser {
	private String userName;//用户名
	private String password;//密码
	private boolean userFlag;//用户是否存在标识
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		userFlag=true;

		
	}
	int checkUser(String userName,String password) {//检查用户与密码是否合法
		if (this.userName.equals(userName)&&this.password.equals(password))
			return 0;//表示用户与密码正确
		else if (this.userName.equals(userName))
			return 1;//表示用户密码错误
		else {
			return 2;//表示用户不存在
		}
	}
	void deleteUser() { //删除用户
		userFlag=false;
	}
	public boolean getFlag() {//获取用户存在标识
		// TODO 自动生成的方法存根
		return userFlag;
	}
	public String getUserName() {//获取用户名
		// TODO 自动生成的方法存根
		return userName;
	}
}
