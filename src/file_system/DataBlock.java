package 文件系统;

public class DataBlock {
		int dataBlockFlag;   //数据块是否被使用标志
		StringBuffer array =new StringBuffer();
		StringBuffer str =new StringBuffer(); //暂时记录
	    DataBlock next;
				
		/*初始化*/
	DataBlock(){
		dataBlockFlag = 0;  // 没被使用
		next=null;
	}
	void write(String fileContenta,int x){
		int a;
		String str=fileContenta;
		a=str.length()-x;
		if(a<=10) {
			String array=str.substring(x); //x表示开始的字符位置，字符串不大于10，就直接读完
		}
		else {              
			String array=str.substring(x,x+10);     //x表示开始位置，x+10表示结束位置，一次读10个字符。
			x=x+10;
			next=SuperBlock.dataBlockAllocation();
			next.write(fileContenta,x);
		}	
	}
	void delete() {
		if (next!=null)     // 递归找到最后的块，置为null。依次往上将使用标志置为0.
			next.delete();
		dataBlockFlag=0;
		next=null;
	}
}
