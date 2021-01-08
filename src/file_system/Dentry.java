package file_system;
import java.util.*;

public class Dentry {
	private StringBuffer dentryName;//Ŀ¼����
	private StringBuffer userName;//�������û�����
	final int maxChildDentryNum=20; //��Ŀ¼�������
	final int maxFileNum=20; //�ļ��������
    private Dentry[] childDentry = new Dentry[maxChildDentryNum];//��Ŀ¼
	private Dentry parentDentry;//��Ŀ¼
	private boolean dentryFlag=false;//�Ƿ񱻽���
	private StringBuffer createTime;//����ʱ��
	private File[] file = new File[maxFileNum];//�ļ�
	private StringBuffer fullPath;//����·��
	private int fileNum = 0;//�ļ�����
	private int childDentryNum = 0;//��Ŀ¼���� 
	
	Dentry(String dentryName,StringBuffer userName,Dentry parentDentry){//���캯�� 
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
	
	Dentry(){//���캯������Ŀ¼
		this.dentryName = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append("root");
		dentryFlag = true;  
		createTime = new StringBuffer();
		createTime.append(getDate()); 
		fullPath = new StringBuffer("root");  
	}
	
	String getDate() {//��ȡ������ʱ�� 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY��%<tm��%<td��%tHʱ%tM��",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	
	boolean dentryCreate(String dentryName,StringBuffer userName,Dentry parentDentry) {//������Ŀ¼
		if(childDentryNum >= maxChildDentryNum){
			return false;
		}
		else {
			for(int i = 0;i < maxChildDentryNum;i++)
				if(childDentry[i]==null||!childDentry[i].dentryFlag){
					childDentry[i] = new Dentry(dentryName,userName,parentDentry);
					childDentryNum++;
					return true;
				}
			return false;
		}
	}
	
	void dentryDelete(){//ɾ����ǰĿ¼
		for(int i = 0;i < childDentryNum;i++)
			childDentry[childDentryNum].dentryDelete();
		for(int i = 0;i < fileNum;i++)
			file[i].fileDelete();
		dentryFlag = false;
		parentDentry.decChildDentryNum();
	}
	
	boolean fileCreate(StringBuffer fileName) {//�����ļ� 
		boolean judge = false;//����ֵ
		StringBuffer fullPath = new StringBuffer();
		fullPath.append(this.fullPath);
		fullPath.append("/");
		fullPath.append(dentryName);
		if(fileNum >= maxFileNum){
			return judge;//�������
		}
		else {
			for(int i = 0;i < maxFileNum;i++)
				if(file[i]==null||!file[i].getFileFlag()){
					file[i] = new File(fileName,fullPath,userName);
					fileNum++;
					judge = true;
					return judge;
				}
		}
		return judge;
	}
	
	void fileDelete(StringBuffer fileName) {//ɾ���ļ�
		for(int i=0;i<maxFileNum;i++)
			if(file[i].getFileName().equals(fileName)) {
				file[i].fileDelete();
				break; 
			}
	}
	
	StringBuffer getDentryName() {//���Ŀ¼����
		return dentryName;
	}
	
	StringBuffer getFullPath() {//���·��
		return fullPath;
	}
	
	StringBuffer getUserName() {//����û�����
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
    
	File getFile(int fileNum) {//����ļ�
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
	void renameDentryName(StringBuffer newName) {
		dentryName=newName;
	}
	int getMaxChildDentryNum() {
		return maxChildDentryNum;
	}
}
