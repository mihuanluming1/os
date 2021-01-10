package file_system;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileSystem {
	private static Dentry currentDentry; //��ǰĿ¼
	private static Dentry rootDentry;    //��Ŀ¼
	private static MyUser [] users=new MyUser[100];  //�û�
	private static String currentUser;  //��ǰ�û�
	private static MyJFrame myJFrame;  //�ļ�ϵͳ����
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		users[0]=new MyUser("admin", "123"); //��ʼ������Ա�û�
		rootDentry=new Dentry(users[0].getUserName());//��ʼ����Ŀ¼
		login();  //������¼����
		
	}
	static void setCurrentDentry(Dentry currentDentry) { //���õ�ǰĿ¼
		FileSystem.currentDentry=currentDentry;
	}
	static Dentry getCurrentDentry() {  //��ȡ��ǰĿ¼
		return currentDentry;
	}
	static void cdOrder(String currentPath) {  //cd����
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
			JOptionPane.showMessageDialog(null, "����ĵ�ַ��Ϣ", "Error", JOptionPane.ERROR_MESSAGE); 
			currentDentry=sourseDentry;
			myJFrame.repaintDetailPanel();
		}
		else{
			if (currentUser.equals(currentDentry.getUserName())||FileSystem.checkAdmin(currentUser)) {
				myJFrame.repaintDetailPanel();
			}
			else {
				JOptionPane.showMessageDialog(null, "û��Ȩ�޷���Ŀ��Ŀ¼", "Error", JOptionPane.ERROR_MESSAGE); 
				currentDentry=sourseDentry;
				myJFrame.repaintDetailPanel();
			}
		}
	}
	static void initPanel(String userName) {  //��ʼ���ļ�ϵͳ����
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
	private static Dentry getDentry(String userName) {  //��ȡ��Ŀ¼�µ���Ŀ¼
		// TODO �Զ����ɵķ������
		return rootDentry.getChildDentry(userName);
	}
	public static int checkUser(String userName, String password) {  //����û��Ƿ�Ϸ�
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()) {
				if (users[i].checkUser(userName, password)==0)
					return 0;
				else if (users[i].checkUser(userName, password)==1)
					return 1;
			}
		}
		return 2;
		// TODO �Զ����ɵķ������
		
	}
	public static boolean checkAdmin(String userName) { //����û��Ƿ�Ϊ����Ա
		return users[0].getUserName().equals(userName);
		
	}
	public static boolean checkUserName(String userName) { //����û����Ƿ����
		// TODO �Զ����ɵķ������
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].getUserName().equals(userName)) {
				return false;
			}
		}
		return true;
	}
	public static void createUser(String userName, String password) { //�����û�
		// TODO �Զ����ɵķ������
		for (int i=0;i<100;i++) {
			if (users[i]==null||!users[i].getFlag()) {
				users[i]=new MyUser(userName, password);
				rootDentry.dentryCreate(userName, userName, rootDentry);
				myJFrame.repaintDetailPanel();
				break;
			}
		}
		
	}
	public static MyJFrame getJFrame() {  //��ȡ�ļ�ϵͳ�������
		// TODO �Զ����ɵķ������
		return myJFrame;
	}
	public static void login() {  //�����¼����
		LoginJFrame loginJFrame=new LoginJFrame();
	}
	public static void deleteUser(String userName) { //ɾ���û�
		// TODO �Զ����ɵķ������
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].getUserName().equals(userName)) {
				users[i].deleteUser();
			}
		}
	}

}
