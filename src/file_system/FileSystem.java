package file_system;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileSystem {
	private static Dentry currentDentry; //当前目录
	private static Dentry rootDentry;    //根目录
	private static MyUser [] users=new MyUser[100];  //用户
	private static String currentUser;  //当前用户
	private static MyJFrame myJFrame;  //文件系统界面
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		users[0]=new MyUser("admin", "123"); //初始化管理员用户
		rootDentry=new Dentry(users[0].getUserName());//初始化根目录
		login();  //弹出登录界面
		
	}
	static void setCurrentDentry(Dentry currentDentry) { //设置当前目录
		FileSystem.currentDentry=currentDentry;
	}
	static Dentry getCurrentDentry() {  //获取当前目录
		return currentDentry;
	}
	static void cdOrder(String currentPath) {  //cd命令
		Dentry sourseDentry=currentDentry;
		currentDentry=rootDentry;
		boolean flag=true;
		while (!currentPath.equals(currentDentry.getFullPath().toString())){
			int maxChildDentryNum=currentDentry.getMaxChildDentryNum();
			for (int i=0;i<maxChildDentryNum;i++) {
				Dentry tempDentry=currentDentry.getChildDentry(i);
				if (tempDentry!=null&&tempDentry.getFlag()&&currentPath.indexOf(tempDentry.getFullPath().toString())!=-1) {
					currentDentry=tempDentry;
					flag=false;
					break;
				}
			}
			if (flag)
				break;
		}
		if (currentPath.equals("root"))
			flag=false;
		if (flag){
			JOptionPane.showMessageDialog(null, "错误的地址信息", "Error", JOptionPane.ERROR_MESSAGE); 
			currentDentry=sourseDentry;
			myJFrame.repaintDetailPanel();
		}
		else{
			if (currentUser.equals(currentDentry.getUserName())||FileSystem.checkAdmin(currentUser)) {
				myJFrame.repaintDetailPanel();
			}
			else {
				JOptionPane.showMessageDialog(null, "没有权限访问目标目录", "Error", JOptionPane.ERROR_MESSAGE); 
				currentDentry=sourseDentry;
				myJFrame.repaintDetailPanel();
			}
		}
	}
	static void initPanel(String userName) {  //初始化文件系统界面
		if (checkAdmin(userName)) {
			currentUser=userName;
			currentDentry=rootDentry;
			myJFrame=new MyJFrame();
		}
		else {
			currentDentry=getDentry(userName);
			currentUser=userName;
			myJFrame=new MyJFrame();
		}
	}
	private static Dentry getDentry(String userName) {  //获取根目录下的子目录
		// TODO 自动生成的方法存根
		return rootDentry.getChildDentry(userName);
	}
	public static int checkUser(String userName, String password) {  //检查用户是否合法
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()) {
				if (users[i].checkUser(userName, password)==0)
					return 0;
				else if (users[i].checkUser(userName, password)==1)
					return 1;
			}
		}
		return 2;
		// TODO 自动生成的方法存根
		
	}
	public static boolean checkAdmin(String userName) { //检查用户是否为管理员
		return users[0].getUserName().equals(userName);
		
	}
	public static boolean checkUserName(String userName) { //检查用户名是否存在
		// TODO 自动生成的方法存根
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].getUserName().equals(userName)) {
				return false;
			}
		}
		return true;
	}
	public static void createUser(String userName, String password) { //创建用户
		// TODO 自动生成的方法存根
		for (int i=0;i<100;i++) {
			if (users[i]==null||!users[i].getFlag()) {
				users[i]=new MyUser(userName, password);
				rootDentry.dentryCreate(userName, userName, rootDentry);
				myJFrame.repaintDetailPanel();
				break;
			}
		}
		
	}
	public static MyJFrame getJFrame() {  //获取文件系统界面对象
		// TODO 自动生成的方法存根
		return myJFrame;
	}
	public static void login() {  //进入登录界面
		LoginJFrame loginJFrame=new LoginJFrame();
	}
	public static void deleteUser(String userName) { //删除用户
		// TODO 自动生成的方法存根
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].getUserName().equals(userName)) {
				users[i].deleteUser();
			}
		}
	}

}
