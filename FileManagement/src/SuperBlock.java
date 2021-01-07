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
		return null;
	}
	boolean getDirty() {//获取脏位
		return dirty;
	}
	void modifyDirty() {//修改脏位
		dirty = true;
	}	
}

