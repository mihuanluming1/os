package file_system;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class DetailJFrame extends JFrame{

	public DetailJFrame(Dentry currentDentry) {//��ʾĿ¼��ϸ��Ϣ
		// TODO �Զ����ɵĹ��캯�����
		super("��ϸ��Ϣ");
		setSize(400,300);
		setLocationRelativeTo(null);
		setLayout(null);
		JTextPane  jTextPane=new JTextPane ();
		String msg=new String();
		jTextPane.setBounds(50, 50, 300, 200);
		msg="Ŀ¼���ƣ�"+currentDentry.getDentryName()+"\n"+"�����ߣ�"+currentDentry.getUserName()+"\n"+"λ�ã�"+currentDentry.getFullPath()+"\n����ʱ�䣺"+currentDentry.getCreateTime()+"\n�޸�ʱ�䣺"+currentDentry.getChangeTime();
		jTextPane.setText(msg);
		jTextPane.setEditable(false);
		jTextPane.setOpaque(false);
		jTextPane.setFont(new Font(null, Font.PLAIN, 18));
		add(jTextPane);
		setVisible(true);
		repaint();
	}

	public DetailJFrame(MyFile file) {//��ʾ�ļ���ϸ��Ϣ
		// TODO �Զ����ɵĹ��캯�����
		super("��ϸ��Ϣ");
		setSize(400,300);
		setLocationRelativeTo(null);
		setLayout(null);
		JTextPane  jTextPane=new JTextPane ();
		String msg=new String();
		jTextPane.setBounds(50, 50, 300, 200);
		msg="�ļ����ƣ�"+file.getFileName()+"\n"+"�����ߣ�"+file.getUserName()+"\n"+"λ�ã�"+file.getFullPath()+"\n����ʱ�䣺"+file.getCreateTime()+"\n�޸�ʱ�䣺"+file.getChangeTime();
		jTextPane.setText(msg);
		jTextPane.setEditable(false);
		jTextPane.setOpaque(false);
		jTextPane.setFont(new Font(null, Font.PLAIN, 18));
		add(jTextPane);
		setVisible(true);
		repaint();
	}

}
