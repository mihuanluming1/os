package file_system;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class File {//鏂囦欢绫�

	private StringBuffer fileName;//鏂囦欢鍚嶅瓧
	private StringBuffer fullPath;//鏂囦欢鎵�鍦ㄧ洰褰曪紝鐩稿鐩綍锛屽彧瑕佺埗鐩綍
	private StringBuffer userName;//鐢ㄦ埛鍚�                  
	private String modifyTime;//鏂囦欢淇敼鏃堕棿                 

	Inode fileInode;//鏂囦欢绱㈠紩
	private int fileSize;//鏂囦欢澶у皬
	private boolean fileFlag;//鏍囧織浣�
	Inode inode ;

	DataBlock datablock = new DataBlock();

	public File(StringBuffer fileName,StringBuffer fullPath,StringBuffer userName) {
		this.fileName = fileName;
		this.fullPath = fullPath; 
		this.userName = userName;

		fileSize = 0;
		fileInode = SuperBlock.InodeAllocation();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡
        modifyTime = df.format(new Date());// new Date()涓鸿幏鍙栧綋鍓嶇郴缁熸椂闂�

        fileFlag = true;

		if(fileInode == null) {
			//鎶ラ敊
		}
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}

	void rename(StringBuffer fileName) {//淇敼鏂囦欢鍚�
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		sb.append(scanner.next());
		this.fileName = fileName;
		
	}
	//娌℃湁鍦版柟璋冪敤浜唖etTime
	private void setTime() {//璁剧疆淇敼鏃堕棿
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//璁剧疆鏃ユ湡鏍煎紡
        modifyTime = df.format(new Date());// new Date()涓鸿幏鍙栧綋鍓嶇郴缁熸椂闂�
        
	}
	private void deleteFlag() {
		fileSize = 0;
		fileName = null;
		fullPath = null;
		userName = null;
		modifyTime = null;
		fileSize = 0;
		
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		
	}
	void fileDelete() {
		fileFlag = false;
		deleteFlag();
		inode.delete();
		
	}
	//娌℃湁鍦版柟璋冪敤浜唚rite
	void write(String fileContent){
		inode.write(fileContent);
		
	}
	StringBuffer getContent() {
		if(inode != null) {
			return inode.getFileContent();
		}
		return null;
	}
	StringBuffer getFileName() {
		return fileName;
	}
	StringBuffer getFullpath() {
		return fullPath;
	}
	StringBuffer getUserName() {
		return userName;
	}
	String getModifyTime() {
		return modifyTime;
	}
	int getFileSize() {
		return fileSize;
	}
	boolean getFileFlag() {
		return fileFlag;
	}
}
