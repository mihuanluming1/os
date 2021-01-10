package file_system;
public class SuperBlock { //超级块
	private static DataBlock[] dataBlock = new DataBlock[100];
	private static Inode[] inode = new Inode[100];
	private boolean dirty = false;//脏位，内存中的数据是否被改变的标志
	static Inode InodeAllocation() {
		for(int i=0;i<100;i++)
			if(inode[i]==null||inode[i].inodeFlag == 0) {
				inode[i]=new Inode();
				return inode[i]; 
			}		
		return null;
	}
	static DataBlock DataBlockAllocation() {//数据块分配,存在空的数据块返回该数据块对象
		for(int i = 0;i < 100;i++)
			if(dataBlock[i]==null||dataBlock[i].dataBlockFlag == 0) {
				dataBlock[i]=new DataBlock();
				return dataBlock[i];
			}
		return null;
	}
	boolean getDirty() {//获取脏位
		return dirty;
	}
	void modifyDirty() {//修改脏位
		dirty = true;
	}
}
