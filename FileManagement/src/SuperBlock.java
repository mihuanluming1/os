
public class SuperBlock {

	private static DataBlock[] dataBlock = new DataBlock[10];
	private static Inode[] inode= new Inode[10];
	private boolean dirty = false;//脏位为真时需要写回磁盘；为假时说明内存中文件没有被改变，不需要写回磁盘
	static Inode InodeAllocation() {//索引分配
		for(int i=0;i<10;i++)
			if(inode[i].i_flag==0) {
				return inode[i];
			}		
		return inode[0];
	}
	static DataBlock DataBlockAllocation() {//数据块分配,存在空的数据块返回该数据块对象
		for(int i=0;i<10;i++)
			if(dataBlock[i].d_flag==0) {
				return dataBlock[i];
			}
		return dataBlock[0];
	}
	boolean getDirty() {//获取脏位
		return dirty;
	}
	void modifyDirty() {//修改脏位
		dirty = true;
	}

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
