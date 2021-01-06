
public class SuperBlock {
	private static DataBlock[] datablock = new DataBlock[10];
	private static Inode[] inode= new Inode[10];
	private boolean dirty = false;
	static int[] InodeNum = {0,0,0,0,0,0,0,0,0,0}; 
	static int[] DataBlockNum = {0,0,0,0,0,0,0,0,0,0}; 
	static int[] GetInodeNum()//获得索引分配状态
	{ 
		return InodeNum;
	}
	static int[]  GetDataBlockNum()//获得数据块分配状态
	{ 
		return DataBlockNum;
	}
	static boolean InodeAllocation(int inodeNum) {//索引分配,该索引号若未分配，进行分配，若已分配，返回false
		if(InodeNum[inodeNum]==0)
		{
			InodeNum[inodeNum]=1;
			return true;
		}
		else
			return false;
	}
	static boolean DataBlockAllocation(int dataBlockNum,char[] cotent) {//数据块分配,DataBlockNum是分配出去的数据块序号
		if(DataBlockNum[dataBlockNum]==0)
		{
			DataBlockNum[dataBlockNum]=1;
			dataBlock[dataBlockNum].array=cotent;
			return true;
		}
		else
			return false;
	}
	static void DeleteInode(int InodeNum)//通过索引号删除文件，清除目录中下的文件，由目录提出请求
	{
		
	}
	
	
}
