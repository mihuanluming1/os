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
import javax.swing.text.View;

class LoginJFrame extends JFrame{
	JButton loginButton;  //登录按钮
	JTextField usernameField;//用户名输入框
	JPasswordField passwordField;//密码输入框
	JLabel usernameJLabel;//用户名标签
	JLabel passwordJLabel;//密码标签
	LoginJFrame (){
		super("登录");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(225,300);
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
		loginButton=new JButton("登录");
		loginButton.setFont(new Font(null, Font.PLAIN, 20));
		loginButton.setBounds(70, 200, 80, 40);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (e.getSource()==loginButton) {
					String userName=usernameField.getText();
					int flag=FileSystem.checkUser(usernameField.getText(), String.valueOf(passwordField.getPassword()));
					System.out.println(flag);
					if (flag==0) {
						FileSystem.initPanel(userName);
						dispose();
					}
					else if (flag==1){
						JOptionPane.showMessageDialog(null, "用户名与密码不匹配", "Error", JOptionPane.ERROR_MESSAGE); 
					}
					else {
						JOptionPane.showMessageDialog(null, "用户名不存在", "Error", JOptionPane.ERROR_MESSAGE); 
						
					}
				}
			}
		});
		add(loginButton);
		setVisible(true);
		repaint();
	}

}
