
public class SuperBlock {
	private static dataBlockNum=10;
	private static InodeNum=10;
	private static DataBlock[] datablock = new DataBlock[dataBlockNum];
	private static Inode[] inode= new Inode[InodeNum];
	private boolean dirty = false;
	static Inode InodeAllocation(int inodeNum) {//索引分配,该索引号若未分配，进行分配，若已分配，返回false

	}
	static  DataBlock DataBlockAllocation(char[] cotent) {//数据块分配,DataBlockNum是分配出去的数据块序号 
			
	}
	static void DeleteInode(int InodeNum)//通过索引号删除文件，清除目录中下的文件，由目录提出请求
	{
		
	}
	
	
}
class DataBlock{
    	int DataBlockCount;
    	char [] content=new char[10];
    	DataBlock next;
    	DataBlock (){
	    	next=null;
		DataBlockCount=0;
	}
	
}
