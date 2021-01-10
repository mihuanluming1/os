package file_system;

import java.util.*;

public class Dentry {
	
	private String dentryName;//Ŀ¼����
	private String userName;//�������û�����
	final int maxChildDentryNum=20; //��Ŀ¼�������
	final int maxFileNum=20; //�ļ��������
    private Dentry[] childDentry = new Dentry[maxChildDentryNum];//��Ŀ¼
	private Dentry parentDentry;//��Ŀ¼
	private boolean dentryFlag=false;//�Ƿ񱻽���
	private StringBuffer createTime;//����ʱ��
	private StringBuffer changeTime;
	private MyFile[] file = new MyFile[maxFileNum];//�ļ�
	private StringBuffer fullPath;//����·��
	private int fileNum = 0;//�ļ�����
	private int childDentryNum = 0;//��Ŀ¼���� 
	
	Dentry(String dentryName,String userName,Dentry parentDentry){//���캯�� 
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
	
	Dentry(String userName){//���캯������Ŀ¼
		this.dentryName = "root";
		this.userName = userName;
		dentryFlag = true;  
		createTime = new StringBuffer();
		createTime.append(getDate()); 
		//changeTime = createTime;
		setChangeTime();
		fullPath = new StringBuffer("root");  
	}
	
	String getDate() {//��ȡ������ʱ�� 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY��%<tm��%<td��%tHʱ%tM��",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	void setChangeTime() {//�����ļ��޸�ʱ��
		changeTime = new StringBuffer();
		changeTime.append(getDate()); 
	}
	boolean dentryCreate(String dentryName,String userName,Dentry parentDentry) {//������Ŀ¼
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
	
	void dentryDelete(){//ɾ����ǰĿ¼
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
	

	boolean fileCreate(String fileName) {//�����ļ� 
		boolean judge = false;//����ֵ
		StringBuffer fullPath = new StringBuffer();
		fullPath.append(this.fullPath);
		//fullPath.append("/");
		//fullPath.append(dentryName);
		if(fileNum >= maxFileNum){
			return judge;//�������
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
	
	void fileDelete(String fileName) {//ɾ���ļ�
		for(int i=0;i<maxFileNum;i++)
			if(file[i]!=null&&file[i].getFileName().equals(fileName)) {
				file[i].fileDelete();
				break; 
			}
		setChangeTime();
		fileNum--;
	}
	
	String getDentryName() {//���Ŀ¼����
		return dentryName;
	}
	
	StringBuffer getFullPath() {//���·��
		return fullPath;
	}
	
	String getUserName() {//����û�����
		return userName;
	}
	
    Dentry getChildDentry(int childDentryNum) {//����Ӷ���
    	return childDentry[childDentryNum];
    }
    
    Dentry getParentDentry() {//��ø�����
    	return parentDentry;
    }
    
    StringBuffer getCreateTime()//��ô���ʱ��
    {
    	return createTime;
    }
    StringBuffer getChangeTime()//��ô���ʱ��
    {
    	return changeTime;
    }
	MyFile getFile(int fileNum) {//����ļ�
		return file[fileNum];
	} 
	boolean getFlag() {   //���Ŀ¼״̬
		return dentryFlag;
	}
	void decChildDentryNum() {//��Ŀ¼������һ
		childDentryNum-=1;
	}
	
	void decFileNum() {//��Ŀ¼������һ
		fileNum-=1;
	}
	
	int getFileNum() {//����ļ�����
		return fileNum;
	}
	
	int getChildDentryNum() {//�����Ŀ¼����
		return childDentryNum; 
	}
	void renameDentryName(String newName) {//������
		setChangeTime();
		fullPath=new StringBuffer(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(newName);
		dentryName=newName;
	}
	int getMaxChildDentryNum() {//��ȡ��Ŀ¼������
		return maxChildDentryNum;
	}

	Dentry getChildDentry(String userName) {//��ȡ��Ŀ¼
		// TODO �Զ����ɵķ������
		for (int i=0;i<maxChildDentryNum;i++) {
			if (childDentry[i]!=null&&childDentry[i].getDentryName().equals(userName)) {
				return childDentry[i];
			}
		}
		return null;
	}

	 
}
