
public class SuperBlock {
	private static DataBlock[] dataBlock = new DataBlock[10];
	private static Inode[] inode= new Inode[10];
	private boolean dirty = false;
	static Inode InodeAllocation() {
		for(int i=0;i<10;i++)
			if(inode[i].inodeFlag==0) {
				return inode[i]; 
			}		
		return inode[0];
	}
	static DataBlock DataBlockAllocation() {//数据块分配,存在空的数据块返回该数据块对象
		for(int i=0;i<10;i++)
			if(dataBlock[i].dataBlockFlag==0) {
				return dataBlock[i];
			}
		return dataBlock[0];
	}
	boolean getDirty() {
		return dirty;
	}
	void modifyDirty() {
		dirty = true;
	}
}
