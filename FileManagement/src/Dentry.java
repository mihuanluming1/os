import java.util.*;

public class Dentry {
	private StringBuffer dentryName;//目录名字
	private StringBuffer userName;//创建的用户名字
    Dentry[] childDentry = new Dentry[20];//子目录
	private Dentry parentDentry;//父目录
	private boolean flag=false;//是否被建立
	private StringBuffer createTime;//创建时间
	File[] file;//文件
	private StringBuffer fullPath;//绝对路径
    int fileNum = 0;//文件个数
    int childDentryNum = 0;//子目录个数 
	
	Dentry(String dentryName,StringBuffer userName,Dentry parentDentry){//构造函数 
		fullPath = new StringBuffer();
		createTime = new StringBuffer();
		this.dentryName = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		flag = true;
		createTime.append(getDate());
		this.parentDentry = parentDentry; 
		fullPath.append(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(parentDentry.getDentryName());
	} 
	
	Dentry(String dentryName,String userName){//构造函数
		this.dentryName = new StringBuffer();
		createTime = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		flag = true; 
		createTime.append(getDate()); 
		fullPath = new StringBuffer("FileManagement");  
	}
	
	Dentry(){
		
	}
	
	String getDate() {//获取日期与时间 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY年%<tm月%<td日%tH时%tM分",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	
	void dentryCreate(String dentryName,StringBuffer userName,Dentry parentDentry) {//创建子目录
		childDentry[childDentryNum] = new Dentry(dentryName,userName,parentDentry);   
		childDentryNum++; 
	}
	
	void dentryDelete(){//删除目录
		flag = false;
	}
	
	StringBuffer getDentryName() {//获得目录名字
		return dentryName;
	}
	
	StringBuffer getFullPath() {//获得路径
		return fullPath;
	}
	
	StringBuffer getUserName() {//获得用户名字
		return userName;
	}
}
