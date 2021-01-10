package file_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DetailJPanel extends JPanel{
	JTextField addressField;//��ַ��
	GridJPanel gridJPanel;//��ַ��ϸ���ݽ���
	public DetailJPanel() {
		// TODO �Զ����ɵĹ��캯�����
		super();
		initialAll();
		
	}
	void initialAll() {//��ʼ��
		setLayout(null);
		setBounds(0, 0, 700, 700);
		initialJTextField();
		initialGridJPanel(addressField);
		setVisible(true);
	}
	private void initialJTextField() {//��ʼ����ַ��
		// TODO �Զ����ɵķ������
		addressField=new JTextField();
		addressField.setBounds(50, 20, 620, 40);
		addressField.setText(FileSystem.getCurrentDentry().getFullPath().toString());
		addressField.setFont(new Font(null, Font.PLAIN, 20));
		addressField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				if ((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
					FileSystem.cdOrder(addressField.getText());
				}
				
			}
		});
		add(addressField);
		
	}
	void initialGridJPanel(JTextField addressField) {//��ʼ����ַ������ϸҳ��
		
		gridJPanel=new GridJPanel(addressField);
		JScrollPane jsp = new JScrollPane(gridJPanel);
        jsp.setBounds(50, 65, 620, 600);
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.repaint();
		add(jsp);
		
	}
	public void repaintGridPanel() {//ˢ��
		// TODO �Զ����ɵķ������
		gridJPanel.showFile();
		
	}

}
