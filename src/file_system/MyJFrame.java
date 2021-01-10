package file_system;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyJFrame extends JFrame{
	DetailJPanel detailJPanel; //显示详细信息的界面
	static String frameNameString="文件系统";
	static int frameHeight=720;
	static int frameWidth=720;//1280;
	public MyJFrame() {
		// TODO 自动生成的构造函数存根
		super(frameNameString);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(frameWidth,frameHeight);
		setLocationRelativeTo(null);
		setLayout(null);
		detailJPanel=new DetailJPanel();
		add(detailJPanel);
		setVisible(true);
		repaint();
	
	}
	public void repaintDetailPanel() { //刷新界面
		// TODO 自动生成的方法存根
		detailJPanel.repaintGridPanel();
		
	}

}
