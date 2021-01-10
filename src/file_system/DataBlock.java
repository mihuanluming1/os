package file_system;

import java.io.Serializable;

public class DataBlock {
		
	
		int dataBlockFlag;   //���ݿ��Ƿ�ʹ�ñ�־
		StringBuffer array =new StringBuffer();//�洢��Ϣ
		StringBuffer str =new StringBuffer(); //��ʱ��¼
	    DataBlock next;   //���ӵ���һ�����ݿ�
	   
				
		/*��ʼ��*/
	DataBlock(){
		dataBlockFlag = 0;  // û��ʹ��
		next=null;
	}
	void write(String fileContent,int x){ //�����ݿ���д����Ϣ
		int a;
		String str=fileContent;
		a=str.length()-x;
		if(a<=10) {
			array=new StringBuffer(str.substring(x)); //x��ʾ��ʼ���ַ�λ�ã��ַ���������10����ֱ�Ӷ���
		}
		else {              
			array=new StringBuffer(str.substring(x,x+10));     //x��ʾ��ʼλ�ã�x+10��ʾ����λ�ã�һ�ζ�10���ַ���
			x=x+10;
			next=SuperBlock.DataBlockAllocation();
			next.write(fileContent,x);
		}	
	}
	StringBuffer getFileContent() { //��ȡ�ļ�����
		StringBuffer str1=new StringBuffer(); //�������õ���content����Ȼ�󷵻ظ�inode
		if(array!=null) {
			str1=array;  
			if (next!=null)
				str1.append(next.getFileContent()); 
			return str1;
		}		
		return null;
	}
	void delete() { //ɾ�����ݿ�
		if (next!=null)     // �ݹ��ҵ����Ŀ飬��Ϊnull���������Ͻ�ʹ�ñ�־��Ϊ0.
			next.delete();
		dataBlockFlag=0;
		next=null;
	}
}
