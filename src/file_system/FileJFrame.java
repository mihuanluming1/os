package file_system;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

class FileJFrame extends JFrame{
	static int frameHeight=600;
	static int frameWidth=800;
	JTextPane displayPane; //�ļ�������ʾ����
	String text="hello world";  //�ļ�����
	public FileJFrame(MyFile file) {
		// TODO �Զ����ɵĹ��캯�����
		super();
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		setLocationRelativeTo(null);
		setLayout(null);
		displayPane=new JTextPane();
		StringBuffer temp=file.getContent();
		if (temp==null)
			text=null;
		else {
			text=temp.toString();
		}
		displayPane.setText(text);
		displayPane.setSize(frameWidth, frameHeight);
		displayPane.setFont(new Font(null, Font.PLAIN, 20));
		add(displayPane);
		setVisible(true);
		repaint();
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e){
	        	  int n=JOptionPane.showConfirmDialog(null, "�Ƿ񱣴��ļ��޸Ľ����", "",JOptionPane.YES_NO_OPTION);
	        	  if (n==0) {
	        		  //save
	        		  file.write(displayPane.getText());
	        	  }
	          }
	      });
	}

}
