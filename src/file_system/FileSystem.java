package file_system;

import javax.swing.JFrame;

public class FileSystem {
	static Dentry currentDentry;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		currentDentry=new Dentry();
		MyJFrame myJFrame=new MyJFrame(currentDentry);
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

}
