import java.lang.*;
import java.util.Date;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dentry current;
		Dentry root = new Dentry("root","20857");
		root.dentryCreate("abc",root.getUserName(),root); 
		current = root.childDentry[0];
		System.out.print(current.getFullPath()); 
	}

}
