package file_system;

import java.util.*;

public class Dentry {
	
	private String dentryName;//目录名字
	private String userName;//创建的用户名字
	final int maxChildDentryNum=20; //子目录最大数量
	final int maxFileNum=20; //文件最大数量
    private Dentry[] childDentry = new Dentry[maxChildDentryNum];//子目录
	private Dentry parentDentry;//父目录
	private boolean dentryFlag=false;//是否被建立
	private StringBuffer createTime;//创建时间
	private StringBuffer changeTime;
	private MyFile[] file = new MyFile[maxFileNum];//文件
	private StringBuffer fullPath;//绝对路径
	private int fileNum = 0;//文件个数
	private int childDentryNum = 0;//子目录个数 
	
	Dentry(String dentryName,String userName,Dentry parentDentry){//构造函数 
		fullPath = new StringBuffer();
		createTime = new StringBuffer();
		this.dentryName = dentryName;
		this.userName = userName;
		dentryFlag = true;
		createTime.append(getDate());
		setChangeTime();
		this.parentDentry = parentDentry; 
		fullPath.append(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(this.getDentryName()); 
	} 
	
	Dentry(String userName){//构造函数，根目录
		this.dentryName = "root";
		this.userName = userName;
		dentryFlag = true;  
		createTime = new StringBuffer();
		createTime.append(getDate()); 
		//changeTime = createTime;
		setChangeTime();
		fullPath = new StringBuffer("root");  
	}
	
	String getDate() {//获取日期与时间 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY年%<tm月%<td日%tH时%tM分",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	void setChangeTime() {//设置文件修改时间
		changeTime = new StringBuffer();
		changeTime.append(getDate()); 
	}
	boolean dentryCreate(String dentryName,String userName,Dentry parentDentry) {//创建子目录
		if(childDentryNum >= maxChildDentryNum){
			return false;
		}
		else {
			for(int i = 0;i < maxChildDentryNum;i++)
				if(childDentry[i]==null||!childDentry[i].dentryFlag){
					childDentry[i] = new Dentry(dentryName,userName,parentDentry);
					childDentryNum++;
					setChangeTime();
					return true;
				}
			return false;
		}
	}
	
	void dentryDelete(){//删除当前目录
		for(int i = 0;i < childDentryNum;i++) {
			if (childDentry[i]!=null) {
				childDentry[i].dentryDelete();
			}
		}
		for(int i = 0;i < fileNum;i++) {
			if (file[i]!=null) {
				file[i].fileDelete();
			}
		}
		if (!parentDentry.getUserName().equals(userName)) {
			FileSystem.deleteUser(userName);
		}
		dentryFlag = false;
		parentDentry.decChildDentryNum();
		parentDentry.setChangeTime();
	}
	

	boolean fileCreate(String fileName) {//创建文件 
		boolean judge = false;//返回值
		StringBuffer fullPath = new StringBuffer();
		fullPath.append(this.fullPath);
		//fullPath.append("/");
		//fullPath.append(dentryName);
		if(fileNum >= maxFileNum){
			return judge;//输出错误
		}
		else {
			for(int i = 0;i < maxFileNum;i++)
				if(file[i]==null||!file[i].getFileFlag()){
					file[i] = new MyFile(fileName,fullPath,userName);
					fileNum++;
					judge = true;
					setChangeTime();
					return judge;
				}
		}
		return judge;
	}
	
	void fileDelete(String fileName) {//删除文件
		for(int i=0;i<maxFileNum;i++)
			if(file[i]!=null&&file[i].getFileName().equals(fileName)) {
				file[i].fileDelete();
				break; 
			}
		setChangeTime();
		fileNum--;
	}
	
	String getDentryName() {//获得目录名字
		return dentryName;
	}
	
	StringBuffer getFullPath() {//获得路径
		return fullPath;
	}
	
	String getUserName() {//获得用户名字
		return userName;
	}
	
    Dentry getChildDentry(int childDentryNum) {//获得子对象
    	return childDentry[childDentryNum];
    }
    
    Dentry getParentDentry() {//获得父对象
    	return parentDentry;
    }
    
    StringBuffer getCreateTime()//获得创建时间
    {
    	return createTime;
    }
    StringBuffer getChangeTime()//获得创建时间
    {
    	return changeTime;
    }
	MyFile getFile(int fileNum) {//获得文件
		return file[fileNum];
	} 
	boolean getFlag() {   //获得目录状态
		return dentryFlag;
	}
	void decChildDentryNum() {//子目录个数减一
		childDentryNum-=1;
	}
	
	void decFileNum() {//子目录个数减一
		fileNum-=1;
	}
	
	int getFileNum() {//获得文件个数
		return fileNum;
	}
	
	int getChildDentryNum() {//获得子目录个数
		return childDentryNum; 
	}
	void renameDentryName(String newName) {//重命名
		setChangeTime();
		fullPath=new StringBuffer(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(newName);
		dentryName=newName;
	}
	int getMaxChildDentryNum() {//获取子目录最大个数
		return maxChildDentryNum;
	}

	Dentry getChildDentry(String userName) {//获取子目录
		// TODO 自动生成的方法存根
		for (int i=0;i<maxChildDentryNum;i++) {
			if (childDentry[i]!=null&&childDentry[i].getDentryName().equals(userName)) {
				return childDentry[i];
			}
		}
		return null;
	}

	 
}
