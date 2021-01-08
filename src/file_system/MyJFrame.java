package file_system;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyJFrame extends JFrame{
	CmdJPanel cmdJPanel;
	DetailJPanel detailJPanel;
	static String frameNameString="文件系统";
	static int frameHeight=720;
	static int frameWidth=1280;
	public MyJFrame() {
		// TODO 自动生成的构造函数存根
		super(frameNameString);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(frameWidth,frameHeight);
		setLocationRelativeTo(null);
		setLayout(null);
		cmdJPanel=new CmdJPanel();
		add(cmdJPanel);
		detailJPanel=new DetailJPanel();
		add(detailJPanel);
		setVisible(true);
		repaint();
	}

}
