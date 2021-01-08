package file_system;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileSystem {
	private static Dentry currentDentry;
	private static StringBuffer userName;
	private static Dentry rootDentry;
	private static MyJFrame myJFrame;
	private static String currentPath;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		rootDentry=new Dentry();
		currentDentry=rootDentry;
		myJFrame=new MyJFrame();
		//currentDentry=new Dentry();
		//System.out.println(current.getFullPath());
		/*Dentry current;
		Dentry root = new Dentry("root","20857");
		root.dentryCreate("abc",root.getUserName(),root); 
		current = root.getChildDentry(0);
		System.out.println(current.getFullPath()); 
		current.dentryCreate("sdf",current.getUserName(),current);
		current = current.getChildDentry(0);
		System.out.println (current.getFullPath()); 
		current=root.getChildDentry(0).getChildDentry(0);
		System.out.print(current.getFullPath());*/
	}
	static void setCurrentDentry(Dentry currentDentry) {
		FileSystem.currentDentry=currentDentry;
	}
	static Dentry getCurrentDentry() {
		return currentDentry;
	}
	static void cdOrder(String currentPath) {
		//currentPath=myJFrame.getCurrentPath().toString();
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
		if (flag){
			if (currentPath.equals("root")) {
				JOptionPane.showMessageDialog(null, "没有权限访问系统根目录", "Error", JOptionPane.ERROR_MESSAGE); 
			}
			else {
				JOptionPane.showMessageDialog(null, "错误的地址信息", "Error", JOptionPane.ERROR_MESSAGE); 
			}
		}
		else
			myJFrame.repaintDetailPanel();
	}

}
