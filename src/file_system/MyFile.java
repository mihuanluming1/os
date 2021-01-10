package file_system;
import java.util.Date;


public class MyFile {

//文件类
	private String fileName;//文件名字
	private StringBuffer fullPath;//文件所在目录，相对目录，只要父目录
	private String userName;//用户名       
	private StringBuffer createTime;
	private StringBuffer changeTime;//文件修改时间                 
	private StringBuffer parentFullPath;
	Inode fileInode;//文件索引
	private int fileSize;//文件大小
	private boolean fileFlag;//标志位
	Inode inode = new Inode(); 

	public MyFile(String fileName2,StringBuffer fullPath,String userName2) {
		this.fileName = fileName2;
		this.fullPath = fullPath; 
		this.userName = userName2;

		fileSize = 0;
		fileInode = SuperBlock.InodeAllocation();
		createTime = new StringBuffer();
		createTime.append(getDate()); 
		setChangeTime();
        fileFlag = true;
        parentFullPath=fullPath;
        setFullPath();
		if(fileInode == null) {
			//报错
		}
		// TODO 自动生成的构造函数存根
	}
	String getDate() {//获取日期与时间 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY年%<tm月%<td日%tH时%tM分",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	void setFullPath() { //设置文件路径
		fullPath=new StringBuffer();
		fullPath.append(parentFullPath);
		fullPath.append("/");
		fullPath.append(fileName); 
		fullPath.append(".txt");
	}
	void setChangeTime() {//设置文件修改时间
		changeTime = new StringBuffer();
		changeTime.append(getDate()); 
	}
	void rename(String fileName) {//修改文件名
		setChangeTime();
		setFullPath();
		this.fileName = fileName;
		
	}
	private void deleteFlag() { //清空相关属性
		fileSize = 0;
		fileName = null;
		fullPath = null;
		userName = null;
		fileSize = 0;
		
		// TODO 自动生成的方法存根
		
	}
	void fileDelete() { //删除文件
		fileFlag = false;
		deleteFlag();
		if (inode!=null)
			inode.delete();
		
	}
	void write(String fileContent){ //向文件里写入信息
		setChangeTime();
		inode.write(fileContent);
		
	}
	StringBuffer getContent() { //获取文件内容
		if(inode != null) {
			return inode.getFileContent();
		}
		return null;
	}
	String getFileName() { //获取文件名字
		return fileName;
	}
	StringBuffer getFullPath() {//获取文件路径
		return fullPath;
	}
	String getUserName() {//获取用户名字
		return userName;
	}
	int getFileSize() {//获取文件大小
		return fileSize;
	}
	boolean getFileFlag() {//获取文件使用标志
		return fileFlag;
	}
	StringBuffer getCreateTime() {//获取文件创建时间
		// TODO 自动生成的方法存根
		return createTime;
	}
	StringBuffer getChangeTime() {//获取文件修改时间
		// TODO 自动生成的方法存根
		return changeTime;
	}
}