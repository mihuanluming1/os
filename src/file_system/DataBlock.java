package file_system;

import java.io.Serializable;

public class DataBlock {
		
	
		int dataBlockFlag;   //数据块是否被使用标志
		StringBuffer array =new StringBuffer();//存储信息
		StringBuffer str =new StringBuffer(); //暂时记录
	    DataBlock next;   //连接的下一个数据块
	   
				
		/*初始化*/
	DataBlock(){
		dataBlockFlag = 0;  // 没被使用
		next=null;
	}
	void write(String fileContent,int x){ //向数据块中写入信息
		int a;
		String str=fileContent;
		a=str.length()-x;
		if(a<=10) {
			array=new StringBuffer(str.substring(x)); //x表示开始的字符位置，字符串不大于10，就直接读完
		}
		else {              
			array=new StringBuffer(str.substring(x,x+10));     //x表示开始位置，x+10表示结束位置，一次读10个字符。
			x=x+10;
			next=SuperBlock.DataBlockAllocation();
			next.write(fileContent,x);
		}	
	}
	StringBuffer getFileContent() { //获取文件内容
		StringBuffer str1=new StringBuffer(); //储存最后得到的content内容然后返回给inode
		if(array!=null) {
			str1=array;  
			if (next!=null)
				str1.append(next.getFileContent()); 
			return str1;
		}		
		return null;
	}
	void delete() { //删除数据块
		if (next!=null)     // 递归找到最后的块，置为null。依次往上将使用标志置为0.
			next.delete();
		dataBlockFlag=0;
		next=null;
	}
}
