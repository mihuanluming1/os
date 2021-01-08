package file_system;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MyJPopupMenu extends JPopupMenu{
	JMenuItem openItem;
	JMenuItem deleteItem;
	JMenuItem newItem;
	JMenuItem renameItem;
	JMenuItem newFileItem;
	public MyJPopupMenu(int type, Dentry currentDentry, GridJPanel gridJPanel) {
		openItem=new JMenuItem("打开");
		deleteItem=new JMenuItem("删除");
		newItem=new JMenuItem("新建目录");
		newFileItem=new JMenuItem("新建文件");
		renameItem=new JMenuItem("重命名");
		// TODO 自动生成的构造函数存根
		if (type==0) { //文件菜单
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						FileJFrame fileJFrame=new FileJFrame();
					}
				}
			});
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//rename();
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//delete();
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
		}
		else if (type==1) {//目录菜单
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//rename();
						StringBuffer dentryName=new StringBuffer(JOptionPane.showInputDialog("请输入目录名："));
						currentDentry.renameDentryName(dentryName);
						gridJPanel.showFile();
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//delete();
						currentDentry.dentryDelete();
						gridJPanel.showFile();
					}
				}
			});
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//open();
						FileSystem.setCurrentDentry(currentDentry);
						gridJPanel.showFile();
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
		}
		else if (type==2){//新建菜单
			add(newItem);
			newItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//new();
						String dentryName=new String(JOptionPane.showInputDialog("请输入目录名："));
						currentDentry.dentryCreate(dentryName, null, currentDentry);
						gridJPanel.showFile();
					}
				}
			});
			add(newFileItem);
			newFileItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//newfile();
					}
				}
			});
		}
	}
}
