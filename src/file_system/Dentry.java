package file_system;
import java.util.*;

public class Dentry {
	private StringBuffer dentryName;//目录名字
	private StringBuffer userName;//创建的用户名字
	final int maxChildDentryNum=20; //子目录最大数量
	final int maxFileNum=20; //文件最大数量
    private Dentry[] childDentry = new Dentry[maxChildDentryNum];//子目录
	private Dentry parentDentry;//父目录
	private boolean dentryFlag=false;//是否被建立
	private StringBuffer createTime;//创建时间
	private File[] file = new File[maxFileNum];//文件
	private StringBuffer fullPath;//绝对路径
	private int fileNum = 0;//文件个数
	private int childDentryNum = 0;//子目录个数 
	
	Dentry(String dentryName,StringBuffer userName,Dentry parentDentry){//构造函数 
		fullPath = new StringBuffer();
		createTime = new StringBuffer();
		this.dentryName = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		dentryFlag = true;
		createTime.append(getDate());
		this.parentDentry = parentDentry; 
		fullPath.append(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(this.getDentryName()); //?
	} 
	
	Dentry(String dentryName,String userName){//构造函数
		this.dentryName = new StringBuffer();
		createTime = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		dentryFlag = true;  
		createTime.append(getDate()); 
		fullPath = new StringBuffer("FileManagement");  
	}
	
	Dentry(){//构造函数，根目录
		this.dentryName = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append("root");
		dentryFlag = true;  
		createTime = new StringBuffer();
		createTime.append(getDate()); 
		fullPath = new StringBuffer("root");  
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
	
	void dentryDelete(){//删除当前目录
		for(int i = 0;i < childDentryNum;i++)
		{
			childDentry[childDentryNum].dentryDelete();
		}
		for(int i = 0;i < fileNum;i++)
			file[i].fileDelete();
		dentryFlag = false;
		parentDentry.decChildDentryNum();
	}
	
	void fileCreate(StringBuffer fileName) {//创建文件   
		//不合理，应该仿照分配inode的形式写
		file[fileNum] = new File(fileName);
		fileNum++;
	}
	
	void fileDelete(StringBuffer fileName) {//删除文件
		for(int i=0;i<maxFileNum;i++)
			if(file[i].fileName.equals(fileName)) {
				file[i].fileDelete();
				break; 
			}
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
    
	File getFile(int fileNum) {//获得文件
		return file[fileNum];
	} 
	boolean getFlag() {   //获得目录状态
		return dentryFlag;
	}
	void decChildDentryNum() {//子目录个数减一
		childDentryNum-=1;
	}
	int getFileNum() {//获得文件个数
		return fileNum;
	}
	
	int getChildDentryNum() {//获得子目录个数
		return childDentryNum; 
	}
	void renameDentryName(StringBuffer newName) {
		dentryName=newName;
	}
}
