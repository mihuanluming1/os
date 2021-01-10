package file_system;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyJFrame extends JFrame{
	DetailJPanel detailJPanel; //��ʾ��ϸ��Ϣ�Ľ���
	static String frameNameString="�ļ�ϵͳ";
	static int frameHeight=720;
	static int frameWidth=720;//1280;
	public MyJFrame() {
		// TODO �Զ����ɵĹ��캯�����
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
	public void repaintDetailPanel() { //ˢ�½���
		// TODO �Զ����ɵķ������
		detailJPanel.repaintGridPanel();
		
	}

}
