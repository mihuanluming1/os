package file_system;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class DetailJFrame extends JFrame{

	public DetailJFrame(Dentry currentDentry) {//显示目录详细信息
		// TODO 自动生成的构造函数存根
		super("详细信息");
		setSize(400,300);
		setLocationRelativeTo(null);
		setLayout(null);
		JTextPane  jTextPane=new JTextPane ();
		String msg=new String();
		jTextPane.setBounds(50, 50, 300, 200);
		msg="目录名称："+currentDentry.getDentryName()+"\n"+"所有者："+currentDentry.getUserName()+"\n"+"位置："+currentDentry.getFullPath()+"\n创建时间："+currentDentry.getCreateTime()+"\n修改时间："+currentDentry.getChangeTime();
		jTextPane.setText(msg);
		jTextPane.setEditable(false);
		jTextPane.setOpaque(false);
		jTextPane.setFont(new Font(null, Font.PLAIN, 18));
		add(jTextPane);
		setVisible(true);
		repaint();
	}

	public DetailJFrame(MyFile file) {//显示文件详细信息
		// TODO 自动生成的构造函数存根
		super("详细信息");
		setSize(400,300);
		setLocationRelativeTo(null);
		setLayout(null);
		JTextPane  jTextPane=new JTextPane ();
		String msg=new String();
		jTextPane.setBounds(50, 50, 300, 200);
		msg="文件名称："+file.getFileName()+"\n"+"所有者："+file.getUserName()+"\n"+"位置："+file.getFullPath()+"\n创建时间："+file.getCreateTime()+"\n修改时间："+file.getChangeTime();
		jTextPane.setText(msg);
		jTextPane.setEditable(false);
		jTextPane.setOpaque(false);
		jTextPane.setFont(new Font(null, Font.PLAIN, 18));
		add(jTextPane);
		setVisible(true);
		repaint();
	}

}
