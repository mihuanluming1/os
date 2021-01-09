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
	JButton loginButton;
	JTextField usernameField;
	JPasswordField passwordField;
	JLabel usernameJLabel;
	JLabel passwordJLabel;
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
					String userName=FileSystem.checkUser(usernameField.getText(), String.valueOf(passwordField.getPassword()));
					if (userName!=null) {
						FileSystem.initPanel(userName);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "用户名与密码不匹配", "Error", JOptionPane.ERROR_MESSAGE); 
					}
				}
			}
		});
		add(loginButton);
		setVisible(true);
		repaint();
	}

}
