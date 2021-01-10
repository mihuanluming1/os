package file_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogonJFrame extends JFrame{
	JButton logonButton; //新建按钮
	JTextField usernameField;//用户名输入框
	JPasswordField passwordField;//密码输入框
	JPasswordField passwordField2;//密码确认输入框
	JLabel usernameJLabel;//用户名标签
	JLabel passwordJLabel;//密码标签
	JLabel passwordJLabel2;//密码确认标签
	LogonJFrame (){
		super("新建");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(225,400);
		setLocationRelativeTo(null);
		setLayout(null);
		usernameJLabel=new JLabel("用户名：");
		usernameJLabel.setBounds(10, 20, 100, 20);
		usernameJLabel.setFont(new Font(null, Font.PLAIN, 20));
		add(usernameJLabel);
		usernameField=new JTextField();
		usernameField.setBounds(10, 50, 190, 30);
		usernameField.setFont(new Font(null, Font.PLAIN, 20));
		add(usernameField);
		passwordJLabel=new JLabel("密码：");
		passwordJLabel.setBounds(10, 100, 100, 20);
		passwordJLabel.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordJLabel);
		passwordField=new JPasswordField();
		passwordField.setBounds(10, 130, 190, 30);
		passwordField.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordField);
		passwordJLabel2=new JLabel("再次输入密码：");
		passwordJLabel2.setBounds(10, 180, 150, 20);
		passwordJLabel2.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordJLabel2);
		passwordField2=new JPasswordField();
		passwordField2.setBounds(10, 210, 190, 30);
		passwordField2.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordField2);
		logonButton=new JButton("新建");
		logonButton.setFont(new Font(null, Font.PLAIN, 20));
		logonButton.setBounds(70, 280, 80, 40);
		logonButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (e.getSource()==logonButton) {
					if (FileSystem.checkUserName(usernameField.getText())) {
						if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField2.getPassword()))) {
							dispose();
							FileSystem.createUser(usernameField.getText(), String.valueOf(passwordField.getPassword()));
							
						}
						else {
							JOptionPane.showMessageDialog(null, "两次输入的密码不匹配", "Error", JOptionPane.ERROR_MESSAGE); 
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "用户名已存在", "Error", JOptionPane.ERROR_MESSAGE); 
					}
			
				}
			}
		});
		add(logonButton);
		setVisible(true);
		repaint();
	}

}

