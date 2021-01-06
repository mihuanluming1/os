package file_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class CmdJPanel extends JPanel{
	JTextField orderField;
	JTextPane displayPane;
	JButton confirmButton;
	int width=560;
	int height=720;
	int x=1280-width;
	int y=0;
	public CmdJPanel() {
		// TODO 自动生成的构造函数存根
		super();
		initialAll();
	}
	private void initialAll() {
		// TODO 自动生成的方法存根
		setVisible(false);
		setBounds(x, y, width, height);
		setLayout(null);
		//setBackground(new Color(0));
		initialDisplayPane();
		initialOrderField();
		//initialConfirmButton();
		setVisible(true);
		repaint();
	}
	
	private void initialConfirmButton() {
		// TODO 自动生成的方法存根
		confirmButton=new JButton();
		add(confirmButton);
		confirmButton.setBounds(460, 600,60, 40);
		orderField.setFont(new Font(null, Font.PLAIN, 20));
		confirmButton.setText("确认");
		confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nowString=displayPane.getText()+orderField.getText()+"\n";
            	displayPane.setText(nowString);
            	orderField.setText("请输入命令：");
            	orderField.setForeground(Color.GRAY);
            }
        });
	}
	private void initialDisplayPane() {
		// TODO 自动生成的方法存根
		displayPane=new JTextPane();
		//displayPane.setBackground(new Color(0));
		displayPane.setEditable(false);
		displayPane.setFont(new Font(null, Font.PLAIN, 20));
		//displayPane.setBounds(20, 20, 500, 570);
		JScrollPane jsp = new JScrollPane(displayPane);
        //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
        jsp.setBounds(20, 20, 500, 585);
        //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		displayPane.setText("hello\nworld!\n");
		add(jsp);
	}
	private void initialOrderField() {
		// TODO 自动生成的方法存根
		orderField=new JTextField();
		orderField.setBounds(20, 620, 500, 40);
		orderField.setFont(new Font(null, Font.PLAIN, 20));
		orderField.addFocusListener(new JTextFieldHintListener(orderField,"请输入命令："));
		orderField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				if ((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
					String nowString=displayPane.getText()+orderField.getText()+"\n";
	            	displayPane.setText(nowString);
	            	orderField.setText("请输入命令：");
	            	orderField.setForeground(Color.GRAY);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				if (orderField.getText().contains("请输入命令：")) {
					orderField.setText(null);
					orderField.setForeground(Color.BLACK);
				}
			}
		});
		add(orderField);
	}

}

class JTextFieldHintListener implements FocusListener{
	
	private String hintText;
	private JTextField textField;
	
	public JTextFieldHintListener(JTextField TextField,String hintText) {
		this.textField = TextField;
		this.hintText = hintText;
		TextField.setText(hintText);  //默认直接显示
		TextField.setForeground(Color.GRAY);
	}
 
	@Override
	public void focusGained(FocusEvent e) {
		//获取焦点时，清空提示内容
		String temp = textField.getText();
		if(temp.equals(hintText)) {
			textField.setText("");
			textField.setForeground(Color.BLACK);
		}
	}
 
	@Override
	public void focusLost(FocusEvent e) {
		//失去焦点时，没有输入内容，显示提示内容
		String temp = textField.getText();
		if(temp.equals("")) {
			textField.setForeground(Color.GRAY);
			textField.setText(hintText);
		}
	}
 
}
