package file_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DetailJPanel extends JPanel{
	JTextField addressField;
	GridJPanel gridJPanel;
	public DetailJPanel() {
		// TODO 自动生成的构造函数存根
		super();
		initialAll();
		
	}
	void initialAll() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		initialJTextField();
		initialGridJPanel(addressField);
		setVisible(true);
	}
	private void initialJTextField() {
		// TODO 自动生成的方法存根
		addressField=new JTextField();
		addressField.setBounds(50, 20, 620, 40);
		addressField.setText(FileSystem.getCurrentDentry().getFullPath().toString());
		addressField.setFont(new Font(null, Font.PLAIN, 20));
		addressField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				if ((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
					FileSystem.cdOrder(addressField.getText());
				}
				
			}
		});
		add(addressField);
		
	}
	void initialGridJPanel(JTextField addressField) {
		
		gridJPanel=new GridJPanel(addressField);
		JScrollPane jsp = new JScrollPane(gridJPanel);
        jsp.setBounds(50, 65, 620, 600);
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.repaint();
		add(jsp);
		
	}
	public void repaintGridPanel() {
		// TODO 自动生成的方法存根
		gridJPanel.showFile();
		
	}

}
