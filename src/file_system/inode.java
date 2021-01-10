package file_system;

import java.io.Serializable;

class Inode  {
     
	int inodeNum;// 索引号
      int inodeFlag;  // 是否被使用
      DataBlock datablock;  //声明数据块子对象
      
    /*初始化*/
    Inode(){
    	inodeFlag=0;  //初始成未被使用
    	datablock=null;
    }
   void write(String fileContent){ //向数据块中写入信息
	    int x=0;  //偏移参数		
		datablock=SuperBlock.DataBlockAllocation();
		if(datablock==null) {
			//有错
			System.out.println("error");
		}
		//没有加分配失败的处理
		datablock.write(fileContent, x);
		inodeFlag=1;// 已经被使用
    }
   StringBuffer  getFileContent() { //获取文件内容
	   if(datablock!=null) {
		   return datablock.getFileContent();
	   }
	   return null;
   }
   void delete() { //删除索引
	   if(datablock!=null)
		   datablock.delete();  //调用数据块删除
	   inodeFlag=0;
	   datablock=null;
   }
}
