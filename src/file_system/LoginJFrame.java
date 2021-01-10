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
	JButton loginButton;  //��¼��ť
	JTextField usernameField;//�û��������
	JPasswordField passwordField;//���������
	JLabel usernameJLabel;//�û�����ǩ
	JLabel passwordJLabel;//�����ǩ
	LoginJFrame (){
		super("��¼");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(225,300);
		setLocationRelativeTo(null);
		setLayout(null);
		usernameJLabel=new JLabel("�û�����");
		usernameJLabel.setBounds(10, 20, 100, 20);
		usernameJLabel.setFont(new Font(null, Font.PLAIN, 20));
		add(usernameJLabel);
		usernameField=new JTextField();
		usernameField.setBounds(10, 50, 190, 30);
		usernameField.setFont(new Font(null, Font.PLAIN, 20));
		add(usernameField);
		passwordJLabel=new JLabel("���룺");
		passwordJLabel.setBounds(10, 100, 100, 20);
		passwordJLabel.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordJLabel);
		passwordField=new JPasswordField();
		passwordField.setBounds(10, 130, 190, 30);
		passwordField.setFont(new Font(null, Font.PLAIN, 20));
		add(passwordField);
		loginButton=new JButton("��¼");
		loginButton.setFont(new Font(null, Font.PLAIN, 20));
		loginButton.setBounds(70, 200, 80, 40);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (e.getSource()==loginButton) {
					String userName=usernameField.getText();
					int flag=FileSystem.checkUser(usernameField.getText(), String.valueOf(passwordField.getPassword()));
					System.out.println(flag);
					if (flag==0) {
						FileSystem.initPanel(userName);
						dispose();
					}
					else if (flag==1){
						JOptionPane.showMessageDialog(null, "�û��������벻ƥ��", "Error", JOptionPane.ERROR_MESSAGE); 
					}
					else {
						JOptionPane.showMessageDialog(null, "�û���������", "Error", JOptionPane.ERROR_MESSAGE); 
						
					}
				}
			}
		});
		add(loginButton);
		setVisible(true);
		repaint();
	}

}
